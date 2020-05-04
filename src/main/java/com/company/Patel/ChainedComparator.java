package com.company.Patel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ChainedComparator implements Comparator<Task> {
    private List<Comparator<Task>> comparators;
    public ChainedComparator(Comparator<Task>... comparators) {
        this.comparators = Arrays.asList(comparators);

    }

    public ChainedComparator(PrioritySorter prioritySorter, TaskSorter taskSorter) {

    }

    @Override
    public int compare(Task o1, Task o2) {
        for(Comparator<Task> comparator : comparators) {
            int result = comparator.compare(o1, o2);
            if(result != 0) {
                return result;
            }
        }
        return 0;
    }
}

