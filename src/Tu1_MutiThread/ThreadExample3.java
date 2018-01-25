package Tu1_MutiThread;

public class ThreadExample3 implements Runnable {

    private String name;

    ThreadExample3(String name){
        this.name = name;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " value " + i);
        }
    }
}
