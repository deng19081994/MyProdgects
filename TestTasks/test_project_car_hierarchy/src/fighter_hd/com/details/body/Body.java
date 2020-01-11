package fighter_hd.com.details.body;

import fighter_hd.com.details.body.doors.Bonnet;
import fighter_hd.com.details.body.doors.Door;
import fighter_hd.com.details.body.doors.TrunkDoor;

public class Body {
    private BodyType type;
    private String color;
    private float weight;

    private int wheelCount;
    private Wheel[] wheels;

    private int doorCount;
    private Door[] doors;

    public Body(BodyType type, String color, int wheelCount, int doorCount) {
        if (wheelCount % 2 != 0) {
            throw new IllegalArgumentException("Wheels count must be pair number!");
        }

        if (doorCount <= 2) {
            throw new IllegalArgumentException("Doors count must be above then 2!");
        }

        this.type = type;
        this.color = color;
        this.wheelCount = wheelCount;
        this.doorCount = doorCount;
        this.wheels = new Wheel[wheelCount];

        this.doors = new Door[doorCount + 1];
        this.doors[0] = new Bonnet(color);
        this.doors[1] = new TrunkDoor(color);

        for (int i = 2; i <= doorCount; i++) {
            this.doors[i] = new Door(color);
        }

        for (int i = 0; i < wheelCount; i++) {
            this.wheels[i] = new Wheel();
        }

        this.weight = calculateWeight();
    }

    private float calculateWeight() {
        float resultWeight = 500;

        resultWeight += doors.length * doors[0].getWeight();
        resultWeight += wheels.length * wheels[0].getWeight();

        return resultWeight;
    }

    public BodyType getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getWeight() {
        return weight;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public Door[] getDoors() {
        return doors;
    }
}
