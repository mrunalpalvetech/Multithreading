package com.producerConsumerSemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
    private int maxSize;

    public ConcurrentLinkedDeque<Object> getItems() {
        return items;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

   /* public void setItems(List<Object> items) {
        this.items = items;
    }*/

    private ConcurrentLinkedDeque<Object> items;// used instead of list to avoid concurrency issue
    Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ConcurrentLinkedDeque<>();
    }

    public void addItem() {
        this.items.add(new Object());
        System.out.println("Producer produced item, current size: " + this.items.size());
    }

    public void removeItem() { //remove can make concurrency issue hence use synchronied data structure
        //this.items.remove(this.items.size() - 1);
        this.items.remove();
        System.out.println("Consumer consumed item, current size: " + this.items.size());
    }

}
