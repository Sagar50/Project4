package com.company.Patel;

import java.util.ArrayList;
import java.util.Iterator;
public class TaskCollection implements Iterable<Task> {
    ArrayList<Task> taskCollections;

    public TaskCollection(ArrayList<Task> taskCollections){
        this.taskCollections = taskCollections;
    }
    @Override
    public Iterator<Task> iterator() {
        return taskCollections.iterator();
    }
}
