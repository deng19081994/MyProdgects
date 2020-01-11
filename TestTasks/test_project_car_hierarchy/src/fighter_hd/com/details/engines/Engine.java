package fighter_hd.com.details.engines;

public class Engine {
    private EngineType type;
    private float weight;
    private float power;
    private int maxRPM;
    private int currentRPM;
    private boolean isWorking;

    public Engine(EngineType type) {
        if (type == EngineType.Gas_Burning || type == EngineType.Electric) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Engine must be gas burning or electric type!");
        }

        if (type == EngineType.Gas_Burning) {
            this.weight = 350;
            this.power = 150;

        } else if (type == EngineType.Electric) {
            this.weight = 100;
            this.power = 250;
        }

        if (type == EngineType.Gas_Burning) {
            this.maxRPM = 8000;
        } else if (type == EngineType.Electric) {
            this.weight = 0;
        }
    }

    public void start() {
        this.currentRPM = this.maxRPM / 10;
        this.isWorking = true;
        System.out.println(type + " engine started.");
    }

    public void stop() {
        this.currentRPM = 0;
        this.isWorking = false;
        System.out.println(type + " engine stopped.");
    }

    public void increaseRPM() {
        if (this.currentRPM < this.maxRPM) {
            this.currentRPM = this.currentRPM + (this.maxRPM / 10);
        }
    }

    public void decreaseRPM() {
        if (this.currentRPM > this.maxRPM / 10) {
            this.currentRPM = this.currentRPM - (this.maxRPM / 10);
        }
    }

    public EngineType getType() {
        return type;
    }

    public float getPower() {
        return power;
    }

    public float getWeight() {
        return weight;
    }

    public int getMaxRPM() {
        return maxRPM;
    }

    public int getCurrentRPM() {
        return currentRPM;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}
