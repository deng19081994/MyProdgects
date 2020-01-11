package fighter_hd.com.car;

import fighter_hd.com.details.body.Body;
import fighter_hd.com.details.body.BodyType;
import fighter_hd.com.details.engines.Engine;
import fighter_hd.com.details.transmission.Transmission;
import fighter_hd.com.details.transmission.TransmissionType;

import java.util.Date;

public abstract class Car {
    protected String brand;
    protected String model;
    protected int manufactureYear;
    protected int doorsCount;
    protected int wheelsCount;
    protected float maxSpeed;
    protected float weight;
    protected float power;
    protected String color;
    protected BodyType bodyType;
    protected TransmissionType transmissionType;

    protected Body body;
    protected Transmission transmission;
    protected Engine[] engines;

    public Car(String brand, String model, int doorsCount, int wheelsCount, float maxSpeed, String color,
               BodyType bodyType, TransmissionType transmissionType) {

        this.brand = brand;
        this.model = model;
        this.doorsCount = doorsCount;
        this.wheelsCount = wheelsCount;
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.bodyType = bodyType;
        this.transmissionType = transmissionType;

        this.manufactureYear = new Date().getYear();
        this.body = new Body(bodyType, color, wheelsCount, doorsCount);
        this.transmission = new Transmission(transmissionType);
    }

    public void startEngine() {
        for (Engine engine : engines) {
            if ( ! engine.isWorking()) {
                engine.start();
            } else {
                System.out.println("Engine working already");
            }
        }
    }

    public void stopEngine() {
        for (Engine engine : engines) {
            if (engine.isWorking()) {
                engine.stop();
            } else {
                System.out.println("Engine stopped already");
            }
        }
    }

    public void increaseSpeed() {
        transmission.shiftUp();

        for (Engine engine : engines) {
            engine.increaseRPM();
        }
    }

    public void decreaseSpeed() {
        transmission.shiftDown();

        for (Engine engine : engines) {
            engine.decreaseRPM();
        }
    }

    public void turnLeft() {
        System.out.println("Turning left");
    }

    public void turnRight() {
        System.out.println("Turning right");
    }

    protected static float calculateWeight(Body body, Transmission transmission, Engine[] engines) {
        float resultWeight = body.getWeight() + transmission.getWeight();

        for (Engine engine : engines) {
            resultWeight += engine.getWeight();
        }

        return resultWeight;
    }

    protected static float calculatePower(Engine[] engines) {
        float resultPower = 0;

        for (Engine engine : engines) {
            resultPower += engine.getPower();
        }

        return resultPower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public int getDoorsCount() {
        return doorsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public float getWeight() {
        return weight;
    }

    public float getPower() {
        return power;
    }

    public String getColor() {
        return color;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public Body getBody() {
        return body;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Engine[] getEngines() {
        return engines;
    }
}
