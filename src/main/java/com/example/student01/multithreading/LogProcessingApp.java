package com.example.student01.multithreading;

import java.util.concurrent.PriorityBlockingQueue;

class Task implements Comparable<Task> {
    private final String name;
    private final int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(o.priority, this.priority); // Higher priority comes first
    }

    public String getName() {
        return name;
    }
}

class LogProcessor {
    private final PriorityBlockingQueue<Task> logQueue = new PriorityBlockingQueue<>();

    public void produceLog(String log, int priority) {
        logQueue.put(new Task(log, priority));
    }

    public Task consumeLog() throws InterruptedException {
        return logQueue.take();
    }
}

class Producer extends Thread {
    private final LogProcessor processor;

    public Producer(LogProcessor processor) {
        this.processor = processor;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            processor.produceLog("Log " + i, i % 3); // Varying priorities
        }
    }
}

class Consumer extends Thread {
    private final LogProcessor processor;

    public Consumer(LogProcessor processor) {
        this.processor = processor;
    }

    public void run() {
        try {
            while (true) {
                Task log = processor.consumeLog();
                System.out.println("Consumed: " + log.getName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class LogProcessingApp {
    public static void main(String[] args) {
        LogProcessor processor = new LogProcessor();
        Producer producer = new Producer(processor);
        Consumer consumer = new Consumer(processor);
        producer.start();
        consumer.start();
    }
}

