package com.concurreny.runnable;

public class Starter {

    public static void main(String[] args) {
        Atm atm = new Atm();
        Thread thread1 = new Thread(atm);
        Thread thread2 = new Thread(atm);
        Thread thread3 = new Thread(atm);
        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Atm implements Runnable {

    int numberOfUsers;

    @Override
    public void run() {
        useAtm();
    }

    private synchronized void useAtm() {
        numberOfUsers++;
        System.out.println("Number of users: " + numberOfUsers);
    }
}