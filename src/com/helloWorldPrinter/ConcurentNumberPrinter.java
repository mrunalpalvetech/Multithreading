package com.helloWorldPrinter;

public class ConcurentNumberPrinter implements Runnable {
    private int numberToPrint;

    public ConcurentNumberPrinter(int x) {
        numberToPrint = x;
    }

    @Override
    public void run() {
        System.out.println("Number : " + numberToPrint + " Thread : " + Thread.currentThread().getName());
    }
}
