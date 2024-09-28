package com.helloWorldPrinter;

public class HellowWorldPrint implements Runnable{

    public void doSomething(){
        System.out.println("Something " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("Hellow world printer is printing " + Thread.currentThread().getName());
        doSomething();
    }
}
