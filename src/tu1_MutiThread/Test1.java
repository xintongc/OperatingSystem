package tu1_MutiThread;

public class Test1 {
    public static void main(String[] args) {
        ThreadEx1 tr1 = new ThreadEx1("alpha");
        ThreadEx1 tr2 = new ThreadEx1("beta");
        tr1.start();

        try{
            tr1.join(); //don't go to the next thread before finish
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        tr2.start();

//        try{
//            tr2.join();
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }

        System.out.println("Main finished");
        //Main is a thread as well, Main may print before the tr2 done
    }
}
