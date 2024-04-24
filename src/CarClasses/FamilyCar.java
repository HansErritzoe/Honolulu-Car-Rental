package CarClasses;

import java.io.Serializable;

public class FamilyCar extends Car implements Serializable {
    protected int seats;

    public FamilyCar(String brandAndModel, String fuelType, String registrationNumber, int registrationYearMonth, int odoMeter, boolean automaticGear, boolean isAvailable, int seats) {
        super(brandAndModel, fuelType, registrationNumber, registrationYearMonth, odoMeter, automaticGear, isAvailable);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
