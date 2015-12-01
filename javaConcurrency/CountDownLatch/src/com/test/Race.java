/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2013
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.test;

import java.util.concurrent.CountDownLatch;

public class Race {

    static CountDownLatch countdown = new CountDownLatch(5);

    public static void main(String[] args) {
        Runner r1 = new Runner("Gavin", countdown);
        Runner r2 = new Runner("Tony", countdown);
        Runner r3 = new Runner("Mossy", countdown);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Main thread failed to sleep.");
        }
        while (countdown.getCount() > 0) {
            System.out.println(countdown.getCount());
            countdown.countDown();
        }

    }
}

class Runner extends Thread {
    CountDownLatch timer;
    String name;

    public Runner(String name, CountDownLatch cdl) {
        timer = cdl;
        this.name = name;
        start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is ready.");
            timer.await();
        } catch (InterruptedException e) {
            System.err.println("Interrupted - Cannot start race.");
        }
        System.out.println(name + " has started running.");
    }
}