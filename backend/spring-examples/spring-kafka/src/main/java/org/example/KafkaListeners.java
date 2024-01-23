package org.example;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "myTopic", groupId = "groupId")
    void listener(String data){
        System.out.println("Listener received: " + data);
    }
}
