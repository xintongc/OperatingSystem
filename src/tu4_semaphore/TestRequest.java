package tu4_semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRequest {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 0; i < 200; i++){
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    Request.getInstance().connection();
                }
            });

            executor.shutdown();
        }


    }
}
