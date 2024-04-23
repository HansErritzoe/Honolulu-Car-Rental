package CarClasses;
public class SportCar extends Car {
    protected int horsePower;

    public SportCar(String brandAndModel, String fuelType, int registrationNumber, int registrationYearMonth, int odoMeter, boolean automaticGear, boolean isAvailable, int horsePower) {
        super(brandAndModel, fuelType, registrationNumber, registrationYearMonth, odoMeter, automaticGear, isAvailable);
        this.horsePower = horsePower;
    }


    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
