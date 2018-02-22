package tu2_Synchronization;

public class Deadlock {
    private static class Friend {
        private final String name;
        Friend(String name) {
            this.name = name;
        }
        String getName() {
            return this.name;
        }
        synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + " has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this); // attention !!! this, point to bower now
        }
        synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
        }
    }
    public static void main(String[] args) {
        final Friend xiaoming = new Friend("xiaoming");
        final Friend xiaohong = new Friend("xiaohong");
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                xiaoming.bow(xiaohong);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                xiaohong.bow(xiaoming);
            }
        });
        thread1.start();
        thread2.start();
    }
}
