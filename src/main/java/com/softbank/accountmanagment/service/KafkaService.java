package com.softbank.accountmanagment.service;

public interface KafkaService {

    void send(String topic, String message);
}
