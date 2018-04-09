package Assignment8;

public class ReverseHello implements Runnable {

    private static int index = 1;

    @Override
    public void run() {

        if (index <= 50) {

            Thread t = new Thread(new ReverseHello(), "Hello from Thread " + (index++));
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        Thread t = new Thread(new ReverseHello(), "Hello from Thread " + (index++));
        t.start();
    }
}
