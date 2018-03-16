package tu5_lock;

public class Test {
    public static void main(String[] args) {

        RunnerBefore runner = new RunnerBefore();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    runner.firstThread();
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    runner.secondThread();

                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        try{
            runner.finished();
        } catch (InterruptedException e){
            e.printStackTrace();
        }



    }
}
