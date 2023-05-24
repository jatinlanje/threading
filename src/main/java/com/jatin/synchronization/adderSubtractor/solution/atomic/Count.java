package com.jatin.synchronization.adderSubtractor.solution.atomic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@Setter
public class Count {

    private AtomicInteger value;

    public void increment(Integer value) {
        this.value.getAndAdd(value);
    }
    public void decrement(Integer value) {
        this.value.getAndAdd(-value);
    }

}
