package com.parallelism.mergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrayToSort = List.of(8, 1, 6, 2, 3, 9, 7, 5);
        ExecutorService es = Executors.newCachedThreadPool();
        MultithreadtedMergeSorter sorter = new MultithreadtedMergeSorter(arrayToSort, es);//Pass threadPool as well becasue creation if multiple threadpool is not a good idea
        Future<List<Integer>> future = es.submit(sorter);
        List<Integer> sortedArray= future.get();
        System.out.println(sortedArray);
    }
}
