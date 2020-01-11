package fighter_hd.com.details.transmission;

public class Transmission {
    private TransmissionType type;
    private int gearsNumber;
    private float weight;
    private int currentGear;

    public Transmission(TransmissionType type) {
        this.type = type;

        if (type == TransmissionType.Automatic) {
            this.weight = 300 + gearsNumber * 15;
            this.gearsNumber = 5;

        } else if (type == TransmissionType.Mechanic) {
            this.weight = 200 + gearsNumber * 10;
            this.gearsNumber = 6;

        } else if (type == TransmissionType.Without_Transmission) {
            this.weight = 0;
            this.gearsNumber = 1;

        } else {
            throw new IllegalArgumentException("You choose incorrect transmission type.");
        }
    }

    public void shiftUp() {
        if (this.currentGear < this.gearsNumber) {
            this.currentGear++;
        }
    }

    public void shiftDown() {
        if (this.currentGear > 0) {
            this.currentGear--;
        }
    }

    public void onRearGear() {
        this.currentGear = -1;
    }

    public void onNeutral() {
        this.currentGear = 0;
    }

    public int getCurrentGear() {
        return this.currentGear;
    }

    public TransmissionType getType() {
        return this.type;
    }

    public int getGearsNumber() {
        return this.gearsNumber;
    }

    public float getWeight() {
        return this.weight;
    }
}
