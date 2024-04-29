package CarClasses;

import java.io.Serializable;
import java.time.LocalDate;

public class Car implements Serializable, Comparable<Car> {

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

    //compareTo method for sorting Cars
    //sorts by Brand first if not the same, otherwise sorts by Model
    public int compareTo(Car other){
        //if not same brand, sort by brand name
        if(!this.brand.equals(other.brand)){
            return this.brand.compareTo(other.brand);
        } else { //sort by model name
            return this.model.compareTo(other.model);
        }
    }


    @Override
    public String toString() {
        String gear ;
        String availability;
        String carType;
        if(this instanceof FamilyCar){
            carType = "Family Car";
        } else if(this instanceof SportCar){
            carType = "Sports Car";
        } else if (this instanceof LuxuryCar){
            carType = "Luxury Car";
        } else {
            carType = "Normal Car";
        }
        if(automaticGear){
            gear = "Automatic Gear";
        } else {
            gear = "Manual Gear";
        }
        if(isAvailable){
            availability = "Available";
        } else {
            availability = "Unavailable";
        }

        return  brand + " " + model + "\n" +
                "Category: " + carType + "\n" +
                gear + "\n" +
                "Fuel: " + fuelType + "\n" +
                "Registration Date: " + registrationYearMonth + "\n" +
                "License Plate: \"" + registrationNumber + "\"\n" +
                "Miles' driven: " + odoMeter + "\n" +
                availability + " for rent"
        ;
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
