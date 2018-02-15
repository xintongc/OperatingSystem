package tu4_semaphore;

import java.util.concurrent.Semaphore;

public class Request {

    private static Request instance = new Request();

    private int request = 0;

    private Semaphore sem = new Semaphore(10);

    private Request(){

    }

    public static Request getInstance(){
        return instance;
    }
    public void connection(){
        try{
            sem.acquire();

        } catch (InterruptedException e){
            e.printStackTrace();
        }

        synchronized (this){
            request++;
            System.out.println("Current requests: " + request);
        }

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        synchronized (this){
            request--;
        }

        sem.release();

    }


}
