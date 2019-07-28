package io.code.TwitterStream.controller;

import io.code.TwitterStream.service.TwitterStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/twitter")
public class StreamController {

    @Autowired
    private TwitterStreamService twitterStreamService;

    @GetMapping("/")
    public ResponseEntity<?> twitterStreamApi() {
        ResponseEntity responseEntity = null;
        try {
            twitterStreamService.connectToStream();
            responseEntity = new ResponseEntity("Success in connection ", HttpStatus.OK);
        } catch (Exception exe) {
            responseEntity = new ResponseEntity("Exception occured " + exe.getMessage() ,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
