package com.jatin.parallelMergeSort;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@AllArgsConstructor
public class MergeSort implements Callable<List<Integer>> {

    private List<Integer> values = new ArrayList<>();
    private ExecutorService executorService;

    @Override
    public List<Integer> call() throws Exception {

        if (values.size() <= 1) {
            return values;
        }

        int mid = values.size() / 2;

        List<Integer> leftArray = values.subList(0, mid);
        List<Integer> rightArray = values.subList(mid, values.size());

        MergeSort leftSorter = new MergeSort(leftArray, executorService);
        MergeSort rightSorter = new MergeSort(rightArray, executorService);

        Future<List<Integer>> sortedLeft = executorService.submit(leftSorter);
        Future<List<Integer>> sortedRight = executorService.submit(rightSorter);

        return merge(sortedLeft, sortedRight);
    }

    private List<Integer> merge(Future<List<Integer>> sortedLeftFuture, Future<List<Integer>> sortedRightFuture)
            throws InterruptedException, ExecutionException {

        List<Integer> mergeList = new ArrayList<>();
        int first = 0;
        int second = 0;

        List<Integer> sortedLeft = sortedLeftFuture.get();
        List<Integer> sortedRight = sortedRightFuture.get();

        while (first < sortedLeft.size() && second < sortedRight.size()) {
            if (sortedLeft.get(first) < sortedRight.get(second)) {
                mergeList.add(sortedLeft.get(first));
                ++first;
            } else {
                mergeList.add(sortedRight.get(second));
                ++second;
            }
        }

        while (first < sortedLeft.size()) {
            mergeList.add(sortedLeft.get(first));
            ++first;
        }

        while (second < sortedRight.size()) {
            mergeList.add(sortedRight.get(second));
            ++second;
        }

        return mergeList;
    }
}
