package com.multithreading;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {


        ExecutorService executor = Executors.newFixedThreadPool(3);
//        ExecutorService executor = Executors.newCachedThreadPool();
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        Callable<String> callable = ()-> {
//            Thread.sleep(1000);
//            System.out.println("Thread -- "+ Thread.currentThread().getName());
            return "ok";
        };

//        scheduledExecutorService.schedule(callable, 1000, TimeUnit.MILLISECONDS);

        List<Future<String>> futures = new ArrayList<>();
        for(int i = 0 ; i < 20 ; i++ ){
            futures.add(executor.submit(callable));
        }

        futures.forEach(t -> {
            try {
                System.out.println("Thread -- "+ Thread.currentThread().getName());
                System.out.println(t.get());
            } catch (Exception  e) {
                throw new RuntimeException(e);
            }
        });

        executor.shutdown();
    }

}
/*
*
*  newFixedThreadPool -
*
*  threadpool - [T1, T2, T3 .... ]
*
*  []
*
* main T -
*
*
* future.get() // wait for task to complete
* future.isDone() // doesn't wait for task.it just checks the status of the task
*
* // Thread life cycle
*
*  getRequest -> future <- submitted task <- executor
*
* newCachedThreadPool -
*
* [t1, t2] -> t3 -> [t1, t2, t3] -> [t1, t2, t3, t4] -> [t5, t2, t3, t4] -> [t5, t6, t3, t4] -> [t5, t6, t4] -> [t5, t6, t4, t7]
 *
 *  // Even/Odd number - 1..100
 *
 * 1 thread - even
 * 2 thread - odd
 *
 * 1 - thread odd
 *2 - thread even
3
 4*
* 5
*
*
*  Flow how task runs -
*
*   pool - [1...10] -> Executor accept the pool ->
* Executor service executes the task after submitting task by submit method and future return the successfully result in get method
*
*
* */