package com.synchronization;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value val = new Value();
        Adder adder = new Adder(val);
        Subtractor subtractor = new Subtractor(val);

        ExecutorService es = Executors.newCachedThreadPool();
        Future<Integer> addedFuture = es.submit(adder);
        Future<Integer> subFuture = es.submit(subtractor);

        addedFuture.get();
        subFuture.get();

        System.out.println(val.value);
    }
}
