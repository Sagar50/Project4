package com.company.Patel;

import java.util.Comparator;

public class PrioritySorter implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        return Integer.compare(o2.getPriority(), o1.getPriority());
    }
}
