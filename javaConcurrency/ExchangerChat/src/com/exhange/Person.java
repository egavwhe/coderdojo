package com.exhange;

import java.util.concurrent.Exchanger;

class Person {

    void sendMessage(Exchanger<String> exchanger, String message) {
        try {
            exchanger.exchange(message);
        } catch (InterruptedException e) {
            System.err.println("Exchanging data failed.");
        }
    }

    void receiveMessage(Exchanger<String> exchanger) {
        String reply;
        try {
            reply = exchanger.exchange("");
            System.out.println(reply);
        } catch (InterruptedException e) {
            System.err.println("Exchanging data failed.");
        }
    }

}