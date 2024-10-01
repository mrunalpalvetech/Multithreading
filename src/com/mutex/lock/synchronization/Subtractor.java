package com.mutex.lock.synchronization;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Integer> {
    private Value v;
    private Lock lock;
    public Subtractor(Value v, Lock lock) {
        this.lock = lock;
        this.v = v;
    }
    @Override
    public Integer call() throws Exception {
        for(int i =0; i <= 50; i++) {
            System.out.println("Subtractor got lock :" + Thread.currentThread().getName() + " " + i);
            lock.lock();
            this.v.value -= i;
            lock.unlock();
        }
        return null;
    }
}
