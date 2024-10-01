package com.mutex.lock.synchronization;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Lock lock = new ReentrantLock();
        Value val = new Value();
        Adder adder = new Adder(val, lock);
        Subtractor subtractor = new Subtractor(val, lock);

        ExecutorService es = Executors.newCachedThreadPool();
        Future<Integer> addedFuture = es.submit(adder);
        Future<Integer> subFuture = es.submit(subtractor);

        addedFuture.get();
        subFuture.get();

        System.out.println(val.value);
    }
}
