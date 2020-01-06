package com.cheng.stream.customer;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
public class StreamListenerReceiveService {

    @StreamListener(Sink.INPUT) // 4
    public void receiveByStreamListener1(String receiveMsg) {
        System.out.println("receiveByStreamListener1: " + receiveMsg);
    }

    @StreamListener(Sink1.INPUT) // 4
    public void receiveByStreamListener2(String receiveMsg) {
        System.out.println("receiveByStreamListener2: " + receiveMsg);
    }
}