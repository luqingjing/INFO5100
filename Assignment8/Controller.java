package Assignment8;

public class Controller extends Thread {

    Device device;
    Sensor heat;
    Sensor pressure;

    public Controller(Device device, Sensor heat, Sensor pressure) {

        this.device = device;
        this.heat = heat;
        this.pressure = pressure;
    }

    @Override
    public void run() {

        device.startup();
        synchronized (device) {
            while(heat.getValue() <= 70 && pressure.getValue() <= 100) {
                try {
                    System.out.printf("heat -> %.2f, pressure %.2f\n", heat.getValue(), pressure.getValue());
                    device.wait();
                } catch (InterruptedException e) {

                }
            }
        }
        device.shutdown();
    }
}

class Device {
    public void startup() {

        System.out.println("Device started");
    }

    public void shutdown() {

        System.out.println("Device shutting down due to maintenance");
        System.exit(0);
    }
}

class Sensor extends Thread {

    private final Device device;
    private double value;

    public Sensor(Device device) {
        this.device = device;
    }

    public double getValue() {
        return value;
    }

    public void updateValue() {
        this.value += 0.001;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (device) {
                double oldValue = value;
                updateValue();
                if (oldValue != value)
                    device.notify();
            }
        }
    }
}
