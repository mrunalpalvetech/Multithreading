package com.helloWorldPrinter;

public class HelloWorldPrint implements Runnable{

    public void doSomething(){
        System.out.println("Something " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("Hello world printer is printing " + Thread.currentThread().getName());
        doSomething();
    }
}
