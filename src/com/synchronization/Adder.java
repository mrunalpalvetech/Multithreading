package com.synchronization;

import java.util.concurrent.Callable;

class Adder implements Callable<Integer> {
    private Value val;

    Adder(Value val) {
        this.val = val;
    }
    @Override
    public Integer call() throws Exception {
        for(int i =0; i <= 5000; i++) {
            this.val.value += i;
        }
        return null;
    }
}
