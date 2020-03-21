package foobar;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {

    private Semaphore semaphore;
    private Semaphore semaphore2;

    private ReentrantLock reentrantLock;
    private Condition condition;
    private int food;
    private int n;

    public static FooBar fooBar;

    public FooBar(int n) {
        this.n = n;
        this.semaphore = new Semaphore(0);
        this.semaphore2 = new Semaphore(1);
        this.food = 0;
        reentrantLock = new ReentrantLock();
        condition = reentrantLock.newCondition();

    }

    public static FooBar getInstance(int n) {
        if (FooBar.fooBar == null) {
            FooBar.fooBar = new FooBar(n);
        }
        return FooBar.fooBar;

    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            this.semaphore.acquire();
//            reentrantLock.lock();
//            while (food == 1) {
//                condition.signal();
//                condition.await();
//            }
            food += 1;
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
//            condition.signal();
//            reentrantLock.unlock();
//            this.semaphore.release();
            this.semaphore2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            this.semaphore2.acquire();;
//            reentrantLock.lock();
//            while (food == 0) {
//                condition.signal();
//                condition.await();
//            }
            // printBar.run() outputs "bar". Do not change or remove this line.
//            food -= 1;
            printBar.run();
//            condition.signal();
//            reentrantLock.unlock();
            this.semaphore.release();
//            this.semaphore2.release();
        }
    }
}

class RunnableThread implements Runnable {

    private String word;

    public RunnableThread(String word) {
        this.word = word;
    }

    public void run() {
        System.out.println(word);

    }
}
