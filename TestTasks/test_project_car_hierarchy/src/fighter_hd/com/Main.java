package fighter_hd.com;

import fighter_hd.com.car.Car;
import fighter_hd.com.car.Hybrid;
import fighter_hd.com.details.body.BodyType;
import fighter_hd.com.details.transmission.TransmissionType;

public class Main {
    public static void main(String[] args) {
        Car audiA6 = new Hybrid("Audi", "A6 Allroad Quatro", 5, 4, 260,
                                "Blue", BodyType.Hatchback, TransmissionType.Automatic);

        System.out.println("Weight: " + audiA6.getWeight());
        System.out.println("Manufacture year: " + audiA6.getManufactureYear());

        audiA6.stopEngine();

        audiA6.startEngine();

        audiA6.increaseSpeed();
        audiA6.increaseSpeed();

        audiA6.decreaseSpeed();

        audiA6.turnLeft();
        audiA6.turnRight();

        audiA6.decreaseSpeed();
        audiA6.decreaseSpeed();

        audiA6.stopEngine();
    }
}
