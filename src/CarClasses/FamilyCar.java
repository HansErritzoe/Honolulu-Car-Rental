package CarClasses;

import java.io.Serializable;

public class FamilyCar extends Car implements Serializable {
    protected int seats;

    public FamilyCar(String brand, String model, String fuelType, String registrationNumber, int registrationYearMonth, int odoMeter, boolean automaticGear, boolean isAvailable, int seats) {
        super(brand, model, fuelType, registrationNumber, registrationYearMonth, odoMeter, automaticGear, isAvailable);
        this.seats = seats;
    }


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
