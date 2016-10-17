package com.exhange;

import java.util.concurrent.Exchanger;

public class Chat {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String args[]) {
        Thread customer = new Thread(new Customer(exchanger));
        Thread business = new Thread(new Business(exchanger));
        customer.start();
        business.start();
    }
}