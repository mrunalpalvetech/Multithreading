package com.synchronization;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Integer> {
    Value v;
    public Subtractor(Value v) {
        this.v = v;
    }
    @Override
    public Integer call() throws Exception {
        for(int i =0; i <= 5000; i++) {
            this.v.value -= i;
        }
        return null;
    }
}
