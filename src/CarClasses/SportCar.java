package CarClasses;

import java.io.Serializable;
import java.time.LocalDate;

public class SportCar extends Car implements Serializable {
    protected int horsePower;

    public SportCar(String brand, String model, String fuelType, String registrationNumber, LocalDate registrationYearMonth, int odoMeter, boolean automaticGear, boolean isAvailable, int horsePower) {
        super(brand, model, fuelType, registrationNumber, registrationYearMonth, odoMeter, automaticGear, isAvailable);
        this.horsePower = horsePower;
    }
    @Override
    public String toString() {
        return super.toString();
    }
    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
