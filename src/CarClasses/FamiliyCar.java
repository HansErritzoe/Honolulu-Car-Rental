package CarClasses;
public class FamiliyCar extends Car{
    protected int seats;

    public FamiliyCar(String brandAndModel, String fuelType, int registrationNumber, int registrationYearMonth, int odoMeter, boolean automaticGear, boolean isAvailable, int seats) {
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
