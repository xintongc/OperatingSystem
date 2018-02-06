package horseRace;

public class Race {
    private int rank = 0;

    public synchronized void getReadyToRace() throws InterruptedException{
        this.wait();
    }

    public synchronized void startRace(){
        this.notifyAll();
    }
    public synchronized int crossFinishLine(){
        return ++rank;
    }
}
