package com.company.Patel;

import java.util.Scanner;

public class Task {
    private String task;
    private String description;
    private int priority;

    public Task(String task, String description, int priority) {
        this.task = task;
        this.description = description;
        this.priority = priority;

    }


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }



    @Override
    public String toString() {
        return "Task: " + task + " - " + description + " (" + priority + ")";
    }

}

