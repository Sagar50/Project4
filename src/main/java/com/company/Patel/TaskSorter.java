package com.company.Patel;

import java.util.Comparator;

public class TaskSorter implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        return o1.getTask().compareTo(o2.getTask());
    }
}
