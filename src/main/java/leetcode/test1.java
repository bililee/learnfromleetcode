package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class test1 {


    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("error");
        }

        Foo foo = new Foo();
        for (int i = 0; i < args.length ; i++) {
            new MyThread(Integer.valueOf(args[i]), foo).start();
        }
//        System.out.println(123);
    }
}





class Foo {

    public ReentrantLock lock;
    public Condition condition;
    public Integer flag;


    public Foo() {
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
        this.flag = 1;

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        while (flag != 1) {
            condition.signal();
            condition.await();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag++;
        condition.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        while (flag != 2) {
            condition.signal();
            condition.await();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag++;
        condition.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        while (flag != 3) {
            condition.signal();
            condition.await();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        flag++;
        condition.signal();
        lock.unlock();
    }
}

class PrintFirst implements  Runnable{
    public void run() {
        System.out.println(1);
    }
}

class PrintSecond implements  Runnable{
    public void run() {
        System.out.println(2);
    }
}

class PrintThird implements  Runnable{
    public void run() {
        System.out.println(3);
    }
}

class MyThread extends Thread{
    private Integer runNum;

    private Foo foo;

    public MyThread(Integer num, Foo foo) {
        this.runNum = num;
        this.foo = foo;
    }

    @Override
    public void  run() {
        try {
//            this.foo.lock.lock();
//            while (this.foo.flag != this.runNum) {
//                this.foo.condition.await();
//            }
            if (this.runNum == 1) {
                this.foo.first(new PrintFirst());
            }
            if (this.runNum == 2 ) {
                this.foo.second(new PrintSecond());
            }

            if (this.runNum == 3) {
                this.foo.third(new PrintThird());
            }
//            this.foo.flag ++;
//            this.foo.condition.signal();
//            this.foo.lock.unlock();
        } catch (Exception exp) {
            exp.printStackTrace();
        }


    }
}