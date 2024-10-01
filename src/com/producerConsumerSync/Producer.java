package com.producerConsumerSync;

public class Producer implements Runnable {


    private Store store;
    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            synchronized(store){ //if we don't add sync it will try to access -1 index at consumer. After adding sync it will go into infinite loop producer will produce consumer will consume.It's horrible way to do it hence use semaphore.
                if(store.getItems().size() < store.getMaxSize()) {
                    store.addItem();
                }
            }
        }
    }

}
