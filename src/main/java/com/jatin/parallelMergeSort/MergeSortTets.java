package com.jatin.parallelMergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSortTets {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Integer> list = List.of(10, 9, 8, 7, 6, 1, 2, 3, 4, 5);

        ExecutorService executorService = Executors.newCachedThreadPool();
        MergeSort mergeSort = new MergeSort(list, executorService);

        Future<List<Integer>> sortedList = executorService.submit(mergeSort);
        System.out.println(sortedList.get());
    }
}
