package com.example.kafka.embedded;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String payload){
        LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
    }

    /*
    * public void sendMessage(String message) {

    ListenableFuture<SendResult<String, String>> future =
      kafkaTemplate.send(topicName, message);

    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

        @Override
        public void onSuccess(SendResult<String, String> result) {
            System.out.println("Sent message=[" + message +
              "] with offset=[" + result.getRecordMetadata().offset() + "]");
        }
        @Override
        public void onFailure(Throwable ex) {
            System.out.println("Unable to send message=["
              + message + "] due to : " + ex.getMessage());
        }
    });
}*/
}
