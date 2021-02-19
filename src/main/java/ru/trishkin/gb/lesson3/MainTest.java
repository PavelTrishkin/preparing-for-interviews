package ru.trishkin.gb.lesson3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        pingPong(executorService);
//        counterTest(executorService);
    }

    public static void pingPong(ExecutorService executorService) throws InterruptedException {
        PingPong pingPong = new PingPong();

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                pingPong.ping();
                pingPong.pong();
            });

        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
    }

    public static void counterTest(ExecutorService executorService) throws InterruptedException {
        LockCounter lockCounter = new LockCounter();


        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    lockCounter.increment();
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println(lockCounter.getValue());
    }
}
