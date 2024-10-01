package com.producerConsumerSync;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int maxSize;

    public List<Object> getItems() {
        return items;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    private List<Object> items;
    Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    public void addItem() {
        this.items.add(new Object());
        System.out.println("Producer produced item, current size: " + items.size());
    }

    public void removeItem() {
        this.items.remove(this.items.size() - 1);
        System.out.println("Consumer consumed item, current size: " + items.size());
    }

}
