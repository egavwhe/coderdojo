package com.exhange;

import java.util.concurrent.Exchanger;

class Customer extends Person implements Runnable {
    Exchanger<String> exchanger;

    Customer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        receiveMessage(exchanger);
        sendMessage(exchanger, "I would like to buy a suit.");
        receiveMessage(exchanger);
    }

}