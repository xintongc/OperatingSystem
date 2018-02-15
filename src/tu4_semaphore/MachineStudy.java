package tu4_semaphore;

import java.util.concurrent.Semaphore;

public class MachineStudy {

    public static void main(String[] args) {
        Semaphore machine = new Semaphore(2);

        new Person(machine,"aaa");
        new Person(machine,"bbb");
        new Person(machine,"ccc");
    }
}

class Person extends Thread{

    private Semaphore machine;

    Person(Semaphore machine, String name){
        this.machine = machine;
        this.setName(name);
        this.start();
    }

    public void run(){
        try{
            System.out.println(getName() + " is waiting for machine");
            machine.acquire();

            System.out.println(getName() + " is using the machine");
            System.out.println(getName() + " is leaving the machine");

            machine.release();
            System.out.println(getName() + " left the machine");
        } catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
