package CarClasses;

import java.io.Serializable;
import java.time.LocalDate;

public class Car implements Serializable {

    protected String brand;
    protected String model;
    protected String fuelType;
    protected String registrationNumber;
    protected LocalDate registrationYearMonth;
    protected int odoMeter;
    protected boolean automaticGear;
    protected boolean isAvailable;

    public Car(String brand, String model, String fuelType, String registrationNumber, LocalDate registrationYearMonth, int odoMeter, boolean automaticGear, boolean isAvailable) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.registrationNumber = registrationNumber;
        this.registrationYearMonth = registrationYearMonth;
        this.odoMeter = odoMeter;
        this.automaticGear = automaticGear;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Brand:"+brand;
    }
    ////////////////////////////////////////////////////////////////////////
    //                      Getters and Setters below                     //
    ////////////////////////////////////////////////////////////////////////

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

    public LocalDate getRegistrationYearMonth() {
        return registrationYearMonth;
    }

    public void setRegistrationYearMonth(LocalDate registrationYearMonth) {
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
