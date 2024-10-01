package com.mutex.lock.synchronization;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

class Adder implements Callable<Integer> {
    private Value val;
    private Lock lock;

    Adder(Value val, Lock lock) {
        this.val = val;
        this.lock = lock;
    }
    @Override
    public Integer call() throws Exception {
        for(int i =0; i <= 50; i++) {
            System.out.println("Adder got lock :" + Thread.currentThread().getName() + " " + i);
            lock.lock();
            this.val.value += i;
            lock.unlock();
        }
        return null;
    }
}
