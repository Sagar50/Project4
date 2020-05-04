//Sagar Patel, CSCI 1660, Project 4

package com.company.Patel;

import com.google.gson.Gson;


import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        while (true) {
            int response = getResponse();
            while (response != 1 && response != 2 && response != 3 && response != 4 && response != 0 && response != 5 && response != 6) {
                System.out.println("Please enter the correct number.");
                response = input.nextInt();

            }
            if (response == 1) {
                tasks.add(newClass());
                System.out.println("Task added");
            } else if (response == 2) {
                boolean pass = true;
                while (pass) {
                    try {
                        System.out.println("What is the index of the task?");
                        int index = input.nextInt();
                        tasks.remove(index);
                        pass = false;
                    } catch (IndexOutOfBoundsException error) {
                        System.out.println("The index you have chosen does not exist please choose the correct index.");
                        pass = true;
                    }
                }
            } else if (response == 3) {
                boolean pass = true;
                while (pass) {
                    try {
                        System.out.println("What is the index of the task?");
                        int index = input.nextInt();
                        tasks.set(index, newClass()); // Due to the function "newClass()" being called inside of tasks.set, the error is handled after all the info has been entered.
                        pass = false;
                    } catch (IndexOutOfBoundsException error) {
                        System.out.println("The index you have chosen does not exist please choose the correct index.");
                        pass = true;
                    }
                }
            } else if (response == 4) {
                for (Task task : tasks) {
                    System.out.println(task);
                }
            } else if (response == 5) {
                System.out.println("What is the priority of the task?");
                int priority = input.nextInt();
                for (Task task : tasks) {
                    if (priority == task.getPriority()) {
                        System.out.println(task);
                    }
                }
            } else if (response == 6) {

                tasks.sort(new ChainedComparator(new PrioritySorter(), new TaskSorter()));
                TaskCollection taskCollection = new TaskCollection(tasks);
                for (Task task : taskCollection) {
                    System.out.println(task);
                }
            } else {
                Gson gson = new Gson();
                try {
                    FileWriter writer = new FileWriter("task.json");
                    for (int i = 0; i< tasks.size(); i++) {
                        Task task = tasks.get(i);
                        gson.toJson(task, writer);
                    }
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public static Task newClass() {
        Scanner input2 = new Scanner(System.in);
        System.out.println("What is the task? ");
        String taskText = input2.nextLine();
        System.out.println("What is the description of the task? ");
        String taskDescription = input2.nextLine();
        int taskPriority = -1;
        while (taskPriority != 1 && taskPriority != 2 && taskPriority != 3 && taskPriority != 4 && taskPriority != 0 && taskPriority != 5) {
            System.out.println("What is the priority of the task(0-5)? ");
            taskPriority = input2.nextInt();
        }
        return new Task(taskText, taskDescription, taskPriority);
    }

    public static int getResponse() {
        boolean pass = true;
        int response = 0;
        while (pass) {
            try {
                Scanner input3 = new Scanner(System.in);
                System.out.println("Please choose an option: ");
                System.out.println("(1) Add a task.");
                System.out.println("(2) Remove a task.");
                System.out.println("(3) Update a task.");
                System.out.println("(4) List all task.");
                System.out.println("(5) List all tasks of a certain priority.");
                System.out.println("(6) List all tasks based on priority and name.");
                System.out.println("(0) Exit.");
                System.out.println("Choose an option.");
                response = input3.nextInt();
                input3.nextLine();
                pass = false;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input type, please choose the correct option.");
                pass = true;
            }
        }
        return response;
    }




}

