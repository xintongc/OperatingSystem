package tu5_lock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnerBefore {

    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

//v1.    public void firstThread() throws InterruptedException{
//        increment();
//    }

//v1.    public void secondThread() throws InterruptedException{
//        increment();
//    }

    public void finished() throws InterruptedException{
        System.out.println("Count is: " + count);
    }

//v1.    private Lock lock = new ReentrantLock();

    public void firstThread() throws InterruptedException{ //same effect as synchronized
        lock.lock();

        System.out.println("I am waiting......");
        cond.await(); //release the lock, the first one wait and let other to execute

        System.out.println("I am up...........");
        try {
            increment();
        } finally {
            lock.unlock();  //put unlock into finally block, to make sure it must be executed even an interrupt happend
        }
    }

    public void secondThread() throws InterruptedException{

        Thread.sleep(2000);

        lock.lock();
        System.out.println("Press the return key");
        new Scanner(System.in).nextLine();
        System.out.println("Got key");
        cond.signal();  //the first one continue the execution

        try {
            increment();
        } finally {
            lock.unlock(); //if comment this line, the second cannot release the lock, so the first one cannot continue
        }
    }


}
