package CarClasses;

import java.io.Serializable;

public class Car implements Serializable {

    protected String brand;
    protected String model;
    protected String fuelType;
    protected String registrationNumber;
    protected int registrationYearMonth;
    protected int odoMeter;
    protected boolean automaticGear;
    protected boolean isAvailable;

    public Car(String brand, String model, String fuelType, String registrationNumber, int registrationYearMonth, int odoMeter, boolean automaticGear, boolean isAvailable) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.registrationNumber = registrationNumber;
        this.registrationYearMonth = registrationYearMonth;
        this.odoMeter = odoMeter;
        this.automaticGear = automaticGear;
        this.isAvailable = isAvailable;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Car(){
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getRegistrationYearMonth() {
        return registrationYearMonth;
    }

    public void setRegistrationYearMonth(int registrationYearMonth) {
        this.registrationYearMonth = registrationYearMonth;
    }

    public int getOdoMeter() {
        return odoMeter;
    }

    public void setOdoMeter(int odoMeter) {
        this.odoMeter = odoMeter;
    }

    public boolean isAutomaticGear() {
        return automaticGear;
    }

    public void setAutomaticGear(boolean automaticGear) {
        this.automaticGear = automaticGear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
