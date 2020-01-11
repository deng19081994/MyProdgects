package fighter_hd.com.details.body.doors;

public class Door {
    private String color;
    private float weight;

    public Door(String color) {
        this.color = color;
        this.weight = 20;
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

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
