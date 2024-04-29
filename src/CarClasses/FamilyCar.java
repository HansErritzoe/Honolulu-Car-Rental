package CarClasses;

import java.io.Serializable;
import java.time.LocalDate;

public class FamilyCar extends Car implements Serializable {
    protected int seats;

    public FamilyCar(String brand, String model, String fuelType, String registrationNumber, LocalDate registrationYearMonth, int odoMeter, boolean automaticGear, boolean isAvailable, int seats) {
        super(brand, model, fuelType, registrationNumber, registrationYearMonth, odoMeter, automaticGear, isAvailable);
        this.seats = seats;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
