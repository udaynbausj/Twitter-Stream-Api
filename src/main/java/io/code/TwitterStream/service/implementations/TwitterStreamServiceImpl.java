package io.code.TwitterStream.service.implementations;

import com.google.gson.Gson;
import io.code.TwitterStream.Dtos.StatusDto;
import io.code.TwitterStream.config.Keys;
import io.code.TwitterStream.service.TwitterStreamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.util.concurrent.LinkedBlockingQueue;


@Service
public class TwitterStreamServiceImpl implements TwitterStreamService {

    private static Logger logger = LoggerFactory.getLogger(TwitterStreamServiceImpl.class);

    @Override
    public void connectToStream() {

        LinkedBlockingQueue<String >queue = new LinkedBlockingQueue<>();

        StatusListener listener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
                queue.offer(TwitterObjectFactory.getRawJSON(status));
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

            }

            @Override
            public void onTrackLimitationNotice(int i) {

            }

            @Override
            public void onScrubGeo(long l, long l1) {

            }

            @Override
            public void onStallWarning(StallWarning stallWarning) {

            }

            @Override
            public void onException(Exception e) {

            }
        };
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerSecret(Keys.CLIENT_SECRET)
                            .setOAuthConsumerKey(Keys.CLIENT_KEY)
                            .setOAuthAccessToken(Keys.ACCESS_TOKEN)
                            .setOAuthAccessTokenSecret(Keys.TOKEN_SECRET)
                            .setJSONStoreEnabled(true);
        TwitterStreamFactory twitterStreamFactory = new TwitterStreamFactory(configurationBuilder.build());
        TwitterStream twitterStream = twitterStreamFactory.getInstance();
        twitterStream.addListener(listener);
        Gson gson = new Gson();
        twitterStream.filter(new FilterQuery().language("en").follow(363088095)).onStatus(
                status -> {
                    logger.info(status.getText());
                    logger.info(status.toString());
                    StatusDto statusDto1 = new StatusDto();
                    statusDto1 = new Gson().fromJson(status.toString(),StatusDto.class);
                    logger.info(statusDto1.toString());
                }
        );
    }
}
