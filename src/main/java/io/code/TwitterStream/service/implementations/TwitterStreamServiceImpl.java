package io.code.TwitterStream.service.implementations;

import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth10aService;
import io.code.TwitterStream.config.Keys;
import io.code.TwitterStream.constants.Constants;
import io.code.TwitterStream.service.TwitterStreamService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import static io.code.TwitterStream.constants.Constants.FILE_OUT;

@Service
public class TwitterStreamServiceImpl implements TwitterStreamService {

    private static Logger logger = LoggerFactory.getLogger(TwitterStreamServiceImpl.class);

    @Override
    public void connectToStream() throws IOException ,InterruptedException, ExecutionException {
        final OAuth10aService service = new ServiceBuilder(Keys.CLIENT_KEY)
                                        .apiSecret(Keys.CLIENT_SECRET)
                                        .build(TwitterApi.instance());
        final Scanner in = new Scanner(System.in);

        logger.info("Twitter's OAuth1 Flow Started ");
        logger.info("Getting Request Token with clientKey : {} and clientSecret : {} ",
                                                Keys.CLIENT_KEY,Keys.CLIENT_SECRET);
        final OAuth1RequestToken requestToken = service.getRequestToken();
        logger.info("Got the Request Token! : {} ",requestToken.toString());

        logger.info("Please authorize Twitipy by clicking on following link : {}",
                service.getAuthorizationUrl(requestToken));
        logger.info("Paste the code here : ");
        final String oauthVerifier = in.nextLine();
        // Trade the Request Token and Verfier for the Access Token
        logger.info("Trading the Request Token for an Access Token...");
        final OAuth1AccessToken accessToken = service.getAccessToken(requestToken, oauthVerifier);
        logger.info("Got the Access Token! : {} ",accessToken.getRawResponse());
        String userAccessToken = accessToken.getToken();
        String userAccessTokenSecret = accessToken.getTokenSecret();
        logger.info("Access Token : {} " , userAccessToken);
        logger.info("Access Token Secret : {} ", userAccessTokenSecret);
        logger.info(" Calling Twitter Stream Url : {} " , Constants.TWITTER_STREAM_URL);
        final OAuthRequest request = new OAuthRequest(Verb.POST, Constants.TWITTER_STREAM_URL);
        request.addQuerystringParameter("follow","363088095,");
        service.signRequest(accessToken,request);
        final Response response = service.execute(request);
        if(response.isSuccessful()) {
            logger.info("Status Code : {} ",response.getCode());
            File file = new File(FILE_OUT);
            try(OutputStream outputStream = new FileOutputStream(file)){
                IOUtils.copy(response.getStream(), outputStream);
            } catch (FileNotFoundException e) {
                // handle exception here
                logger.error("File not found " + e.getLocalizedMessage());
            } catch (IOException e) {
                logger.error("IO exception " + e.getStackTrace());
            }
        }
    }
}
