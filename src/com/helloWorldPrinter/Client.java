package com.helloWorldPrinter;

public class Client {
    public static void main(String[] args) {
     //   HellowWorldPrint printer1 = new HellowWorldPrint();
        //printer1.run();//Will strat only main thread it will not create any thread

       // Thread t1 = new Thread(printer1);
      //  t1.start();
        //System.out.println("Main Function " + Thread.currentThread().getName());
        /*
* Output :
* Hellow world printer is printing Thread-0
Main Function main
Something Thread-0*/

        for(int i = 1; i <= 100; i++) {
            AsyncNumberPrinter asyncNumberPrinter = new AsyncNumberPrinter(i);
            Thread t = new Thread(asyncNumberPrinter);
            t.start();
        }

    }
}



