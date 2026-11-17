package Multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProesOfExecutor {
    public static void main(String[] args) {

        Pool tp = new Pool();
        
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i = 1; i <= 10000; i++) {

            int taskNo = i;

            executor.execute(() -> tp.checkOut(taskNo));
        }

        executor.shutdown();
    }
}

class Pool {

    public void checkOut(int taskNo) {
        System.out.println("Task no: " + taskNo + " is performed by " + Thread.currentThread().getName());
    }
}

// create a method call ceckOut(int taskNo)
// That take a argument of type int
// And print the task no with the current thread name that execute 
// the task

// In the main method a executorService will created of type newFixedThreadPool(5)
// of 5 threadinside that pool
// and inside a for loop which run 10 thousand time the execute 
// method will be called which will take a runnable and inside that 
// runnable the checkout method will be called

// and at the end the executor.shutdown method will be called 

// if we create the normal thread using the new keyword it will consume so much space in the memory and it will slowdown the application
// Because the normal thread take 500kb to 1mb of space each

// But in case of executor framework only fixed no od thread will be created and they will perform every task one by one and once the task is
// over they will be present in the thread pool id no thread is present to perform a task then the task will wait in the waiting queue
// if so much task came at a time then the task will be execute(which is very rare)