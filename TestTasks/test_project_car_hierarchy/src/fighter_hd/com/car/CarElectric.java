package fighter_hd.com.car;

import fighter_hd.com.details.body.BodyType;
import fighter_hd.com.details.engines.Engine;
import fighter_hd.com.details.engines.EngineType;
import fighter_hd.com.details.transmission.Transmission;
import fighter_hd.com.details.transmission.TransmissionType;

public class CarElectric extends Car {

    public CarElectric(String brand, String model, int doorsCount, int wheelsCount, float maxSpeed, String color,
                       BodyType bodyType, TransmissionType transmissionType) {

        super(brand, model, doorsCount, wheelsCount, maxSpeed, color, bodyType, transmissionType);

        this.transmission = new Transmission(TransmissionType.Without_Transmission);
        this.engines = new Engine[]{new Engine(EngineType.Electric)};
        this.weight = calculateWeight(body, transmission, engines);
        this.power = calculatePower(engines);
    }
}
