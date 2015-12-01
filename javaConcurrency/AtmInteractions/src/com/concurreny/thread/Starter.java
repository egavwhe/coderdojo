package com.concurreny.thread;

class Starter {

    public static void main(String[] args) {
        Object lock = new Object();
        Atm atm1 = new Atm("GAVIN", lock);
        Atm atm2 = new Atm("STEPHEN", lock);
        Atm atm3 = new Atm("ROB", lock);
        atm1.start();
        atm2.start();
        atm3.start();
    }
}

class Atm extends Thread {

    private final String user;
    private final Object lock;

    public Atm(String user, Object lock) {
        this.user = user;
        this.lock = lock;
    }

    @Override
    public void run() {
        useAtm();
    }

    private void useAtm() {
        synchronized (lock) {
            System.out.println(user + " has started using the ATM.");
            System.out.println(user + " has finished using the ATM.");
        }
    }
}
