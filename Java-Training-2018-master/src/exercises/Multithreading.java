package exercises;

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("Duplicates")
public class Multithreading {

    public static void main(String args[]) {
        testRunnable();
        testThreads();
    }

    static void testRunnable() {
        RunnableDemo run1 = new RunnableDemo("Thread-001", 0, 49);
        RunnableDemo run2 = new RunnableDemo("Thread-002", 50, 99);
        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        System.out.println("Starting Runnable threads");
        t1.start();
        t2.start();
        System.out.println("Runnable Threads has been started");
        try {
            t1.join();
            t2.join();
            System.out.println(Arrays.toString(run1.task));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void testThreads() {
        Thread t4 = new ThreadDemo("Thread-001", 0, 49);
        Thread t3 = new ThreadDemo("Thread-002", 50, 99);
        System.out.println("Starting Thread threads");
        t3.start();
        t4.start();
        System.out.println("Thread threads has been started");
        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class RunnableDemo implements Runnable {
    private String threadName;
    private int a, b;
    public static int[] task = new int[100];

    public RunnableDemo(String name, int a, int b) {
        this.threadName = name;
        this.a = a;
        this.b = b;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Doing processing - START " + threadName);
        processArray();
        System.out.println("Doing processing - END " + threadName);
    }

    private void processArray() {
        Random random = new Random();
        for (int i = a; i < b; i++)
            task[i] = random.nextInt(100);
    }
}

class ThreadDemo extends Thread {

    private String threadName;
    private int a, b;
    public static int[] task = new int[100];

    public ThreadDemo(String name, int a, int b) {
        this.threadName = name;
        this.a = a;
        this.b = b;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Doing processing - START " + threadName);
        processArray();
        System.out.println("Doing processing - END " + threadName);
        System.out.println(Arrays.toString(task));
    }

    private void processArray() {
        Random random = new Random();
        for (int i = a; i < b; i++)
            task[i] = random.nextInt(100);
    }

}