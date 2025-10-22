package com.aws.study.poc_aws_soluctions_architect.config.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

public class BoundedExecutor implements Executor {
    private final Executor executor;
    private final Semaphore semaphore;

    public BoundedExecutor(Executor executor, int bound) {
        this.executor = executor;
        this.semaphore = new Semaphore(bound);
    }

    @Override
    public void execute(Runnable command) {
        executor.execute(() -> {
            boolean acquired = false;
            try {
                semaphore.acquire();
                acquired = true;
                command.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                if (acquired) semaphore.release();
            }
        });
    }
}

