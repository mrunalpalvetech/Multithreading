package com.producerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    private Store store;

    private Semaphore prodSemaphore;

    private Semaphore consSemaphore;

    Consumer(Store store, Semaphore prodSemaphore, Semaphore consSemaphore){
        this.store = store;
        this.prodSemaphore = prodSemaphore;
        this.consSemaphore = consSemaphore;
    }
    @Override
    public void run() {
        while(true){
         //   synchronized (store){
             //   if(store.getItems().size() > 0) {
            try {
                consSemaphore.acquire();
                Thread.sleep(10);
                store.removeItem();
                prodSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
