package com.example.student01.multithreading;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockSimulator {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void method1() {
        if (lock1.tryLock()) {
            try {
                if (lock2.tryLock()) {
                    try {
                        System.out.println("Method1: Acquired lock1 and lock2");
                    } finally {
                        lock2.unlock();
                    }
                }
            } finally {
                lock1.unlock();
            }
        }
    }

    public void method2() {
        if (lock2.tryLock()) {
            try {
                if (lock1.tryLock()) {
                    try {
                        System.out.println("Method2: Acquired lock2 and lock1");
                    } finally {
                        lock1.unlock();
                    }
                }
            } finally {
                lock2.unlock();
            }
        }
    }

    public static void main(String[] args) {
        DeadlockSimulator simulator = new DeadlockSimulator();
        Thread t1 = new Thread(simulator::method1);
        Thread t2 = new Thread(simulator::method2);
        t1.start();
        t2.start();
    }
}

