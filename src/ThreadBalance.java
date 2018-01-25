public class ThreadBalance {
    private int balance = 0;

    public static void main(String[] args) {
        ThreadBalance ob = new ThreadBalance();
        ob.test();
    }

    public void test(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi");

                for (int i = 0; i < 1000; i++) {
                    add();
                    System.out.println("ADD: i is " + i + " balance is " + balance);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    sub();
                    System.out.println("SUB: i is " + i + " balance is " + balance);

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


        System.out.println("Balance = " + balance);

    }

    public synchronized void add(){
        balance = balance + 1;
    }

    public synchronized void sub(){
        balance = balance - 1;
    }


}
