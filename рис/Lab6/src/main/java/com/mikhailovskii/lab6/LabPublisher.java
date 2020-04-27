package com.mikhailovskii.lab6;

import javax.xml.ws.Endpoint;

public class LabPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/ws/hello", new LabImpl());
    }

}
