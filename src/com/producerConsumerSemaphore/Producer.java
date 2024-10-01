package com.producerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

    private Semaphore prodSemaphore;

    private Semaphore consSemaphore;
    private Store store;
    public Producer(Store store, Semaphore prodSemaphore, Semaphore consSemaphore) {
        this.store = store;
        this.prodSemaphore = prodSemaphore;
        this.consSemaphore = consSemaphore;
    }

    @Override
    public void run() {
        while(true){
            //synchronized(store){ //if we don't add sync it will try to access -1 index at consumer. After adding sync it will go into infinite loop producer will produce consumer will consume.It's horrible way to do it hence use semaphore.
            try {
                // if(store.getItems().size() < store.getMaxSize()) no need of if because acquire will only allow to produce item it maxSize<list.size()
                prodSemaphore.acquire();
                Thread.sleep(10);
                store.addItem();
                consSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


              //  }
            //}
        }
    }

}
