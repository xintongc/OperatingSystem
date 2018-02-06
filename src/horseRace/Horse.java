package horseRace;

import java.util.Random;

public class Horse implements Runnable{
    
    private String name;
    private Race race;
    private WaterTrough trough;
    private Random rand = new Random(System.currentTimeMillis());
    
    public Horse(String name, Race race, WaterTrough trough){
        this.name = name;
        this.race = race;
        this.trough = trough;
    }
    
    public long runLap() throws InterruptedException{
        long duration = Math.abs((this.rand.nextLong())) % 4000 + 200;
        Thread.sleep(duration);
        return duration;
    }

    
    
    public void run(){
        try{
            this.race.getReadyToRace();
            System.out.println(this.name + " is off and running");

            for (int i = 0; i <= 3 ; i++) {
                long time = this.runLap();
                System.out.println(name + " completes lap" + i + " in " + (double)time);

                time = this.trough.getDrink();
                System.out.println(name + " drinks for " + (double)time/(double)1000.0);
            }

            int place = this.race.crossFinishLine();
            System.out.println(">>> " + name + " finishes in position " + place + " !<<<");
        }
        catch (InterruptedException ie){
            System.out.println(name + " apparently broke a leg and won't be finishing");
        }
        
    }
}
