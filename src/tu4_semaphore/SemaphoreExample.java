package tu4_semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(1);
        //if sem = 0, then program will keep waiting and no printing

        try {
            sem.acquire(); //Semaphore - 1
        }catch (Exception e){

        }

        System.out.println("Available permits: " + sem.availablePermits());

        sem.release(); //Semaphore + 1
        System.out.println("Available permits: " + sem.availablePermits());

    }
}
