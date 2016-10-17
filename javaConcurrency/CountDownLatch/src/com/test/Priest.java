package com.test;

import java.util.concurrent.CountDownLatch;

public class Priest {
    private static CountDownLatch cdl = new CountDownLatch(2);

    public static void main(String[] args) {
        Man ciaran = Man.getInstance();
        Woman carole = Woman.getInstance();
    }

    public static void readyForMarriage(Person person) {
        if (person instanceof Man) {
            cdl.countDown();
        } else if (person instanceof Woman) {
            cdl.countDown();
        }
        try {
            cdl.await();
        } catch (InterruptedException ie) {
            System.err.println("The application was interrupted.");
        }
        System.out.println("Now you are married :)");

    }
}

interface Person {
}

class Man extends Thread implements Person {
    private final static Man man = new Man();

    private Man() {
        this.start();
        System.out.println("man is waiting.");
    }

    public static Man getInstance() {
        return man;
    }

    @Override
    public void run() {
        Priest.readyForMarriage(this);
    }
}

class Woman extends Thread implements Person {
    private static Woman instance = null;

    private Woman() {
        this.start();
        System.out.println("woman is waiting.");
    }

    public static Woman getInstance() {
        if (instance == null) {
            instance = new Woman();
        }
        return instance;
    }

    @Override
    public void run() {
        Priest.readyForMarriage(this);
    }
}