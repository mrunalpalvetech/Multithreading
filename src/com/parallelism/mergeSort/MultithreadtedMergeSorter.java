package com.parallelism.mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadtedMergeSorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    ExecutorService es;
    public MultithreadtedMergeSorter(List<Integer> arrayToSort, ExecutorService es ) {
        this.arrayToSort = arrayToSort;
        this.es = es;
    }


    @Override
    public List<Integer> call() throws Exception {
        if (arrayToSort.size() <= 1) {
            return arrayToSort;
        }
        int mid = arrayToSort.size() / 2;
        List<Integer> left = arrayToSort.subList(0, mid);
        List<Integer> right = arrayToSort.subList(mid, arrayToSort.size());

        ExecutorService es = Executors.newCachedThreadPool();
        MultithreadtedMergeSorter letfSorterTask1 = new MultithreadtedMergeSorter(left, es);
        MultithreadtedMergeSorter rightSorterTask1 = new MultithreadtedMergeSorter(right, es);

        Future<List<Integer>> sortedLeftFuture =  es.submit(letfSorterTask1);
        Future<List<Integer>> sortedRightFuture = es.submit(rightSorterTask1);

        List<Integer> sortedLeftArray = sortedLeftFuture.get();//Mandatory so that parent can wait until task gets completed
        List<Integer> sortedRightArray = sortedRightFuture.get();

        //Merge function

        int i = 0;
        int j = 0;
        List<Integer> sortedArray = new ArrayList<>();
        while (i < sortedLeftArray.size() && j < sortedRightArray.size()) {
            if (sortedLeftArray.get(i) <= sortedRightArray.get(j)) {
                sortedArray.add(sortedLeftArray.get(i));
                i+=1;
            } else {
                sortedArray.add(sortedRightArray.get(j));
                j += 1;
            }
        }
        while (i < sortedLeftArray.size()) {
            sortedArray.add(sortedLeftArray.get(i));
            i += 1;
        }
        while (j < sortedRightArray.size()) {
            sortedArray.add(sortedRightArray.get(j));
            j += 1;
        }

        return sortedArray;
    }
}
