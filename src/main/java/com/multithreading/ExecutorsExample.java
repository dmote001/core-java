package com.multithreading;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {


        ExecutorService executor1 = Executors.newFixedThreadPool(10);
        ExecutorService executor = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        Callable<String> callable = ()-> {
            Thread.sleep(1000);
            return "ok";
        };

        scheduledExecutorService.schedule(callable, 1000, TimeUnit.MILLISECONDS);

        List<Future<String>> futures = new ArrayList<>();
        for(int i = 0 ; i < 20 ; i++ ){
            futures.add(executor.submit(callable));
        }

        futures.forEach(t -> {
            try {
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
*
*
*
*
* newCachedThreadPool -
*
* [t1, t2] -> t3 -> [t1, t2, t3] -> [t1, t2, t3, t4] -> [t5, t2, t3, t4] -> [t5, t6, t3, t4] -> [t5, t6, t4] -> [t5, t6, t4, t7]
 *
 *
 *
 *

 *
* */