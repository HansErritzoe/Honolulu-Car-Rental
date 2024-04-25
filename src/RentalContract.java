import CarClasses.Car;
import CustomerClasses.Customer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RentalContract implements Serializable {
    protected int contractID;
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected int maxKM;
    protected int startKM;
    protected ArrayList<Car> rentedCars;
    protected Customer customer;
    protected double price;

    public RentalContract(int contractID, LocalDateTime startTime, LocalDateTime endTime, int maxKM, int startKM, ArrayList<Car> rentedCars, Customer customer, double price) {
        this.contractID = contractID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxKM = maxKM;
        this.startKM = startKM;
        this.rentedCars = rentedCars;
        this.customer = customer;
        this.price = price;
    }
    ////////////////////////////////////////////////////////////////////////
    //                      Getters and Setters below                     //
    ////////////////////////////////////////////////////////////////////////

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getMaxKM() {
        return maxKM;
    }

    public void setMaxKM(int maxKM) {
        this.maxKM = maxKM;
    }

    public int getStartKM() {
        return startKM;
    }

    public void setStartKM(int startKM) {
        this.startKM = startKM;
    }

    public ArrayList<Car> getRentedCars() {
        return rentedCars;
    }

    public void setRentedCars(ArrayList<Car> rentedCars) {
        this.rentedCars = rentedCars;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
