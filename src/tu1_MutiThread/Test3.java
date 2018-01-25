package tu1_MutiThread;

public class Test3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadExample3("alpha"));
        Thread t2 = new Thread(new ThreadExample3("beta"));

        t1.start();
        t2.start();
    }
}
