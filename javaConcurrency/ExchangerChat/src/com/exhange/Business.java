package com.exhange;

import java.util.concurrent.Exchanger;

class Business extends Person implements Runnable {
    Exchanger<String> exchanger;

    Business(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        sendMessage(exchanger, "Hello how may I help you?");
        receiveMessage(exchanger);
        sendMessage(exchanger, "You're in luck, there's currently a sale  on suits!");
    }
}