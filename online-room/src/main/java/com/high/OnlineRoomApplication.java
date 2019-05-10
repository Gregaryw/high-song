package com.high;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: HarlanW
 * @Date: 2019/4/16 0016
 * @Version: 1.0
 */
@SpringBootApplication
public class OnlineRoomApplication {
    public static void main(String[] args){
        SpringApplication.run(OnlineRoomApplication.class,args);
//        PulsarClient client = PulsarClient.builder()
//                .serviceUrl("pulsar://192.168.72.128:6650")
//                .build();

//        Producer<String> stringProducer = client.newProducer(Schema.STRING)
//                .topic("my-topic")
//                .create();
//        stringProducer.send("My message");
    }
}
