import CarClasses.*;
import CustomerClasses.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

//    public static ArrayList<RentalContracts> rentalContracts = ... FileHandler.getRentalcontract();
    public static ArrayList<Car> rentalCars = FileHandler.readCarsFromFile(); //loads cars from File on Startup
    public static ArrayList<Customer> customerList = FileHandler.readCustomersFromFile();
    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args){

        /* PrivateCustomer test1 = new PrivateCustomer("Bobby Bobsen","Bobsalley 12", 2500, "Honolulu", 25503425, "bobbyBobsen123@hotmail.com",123456789, LocalDate.now());
        Car c1 = new Car("Chevrolet", "Spark", "Diesel", "MGN 530", 200505,250,true,true);
        Car c2 = new Car("Kia", "Rio", "Gasoline 95","YHP 353",2018,2500,false,false);
        FamilyCar c3 = new FamilyCar("Mitsubishi", "Mirage", "Gasoline 90", "SDE 320", 202004,2300,true,true,8);
        Collections.addAll(rentalCars,c1,c2,c3);
        FileHandler.writeCarsToFile(rentalCars);
        for(Car car : rentalCars){
            System.out.println(car.getBrand());
        }*/
        /*PrivateCustomer ctest1 = new PrivateCustomer("Bobby Bobsen","Bobsalley 12", 2500, "Honolulu", 25503425, "bobbyBobsen123@hotmail.com",123456789, LocalDate.now());
        Customer ctest2 = new Customer("Johnny Bobsen", "BObbyvej 12",2600,"Hanoi",342342343,"JohnB@email.com");
        Collections.addAll(customerList,ctest1,ctest2); */
        for(Customer cust : customerList){
            System.out.println(cust.getDriverName());
        }
        //FileHandler.writeCustomersToFile(customerList);
        //UI.welcomeMessage();
        //UI.mainMenu();
    }
}