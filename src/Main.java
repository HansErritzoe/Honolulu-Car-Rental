import CarClasses.*;
import CustomerClasses.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static ArrayList<RentalContract> rentalContracts =  FileHandler.readRentalContractsFromFile();
    public static ArrayList<Car> rentalCars = FileHandler.readCarsFromFile(); //loads cars from File on Startup
    public static ArrayList<Customer> customerList = FileHandler.readCustomersFromFile();

    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args){
        addTestData();
        UI.welcomeMessage();
        UI.mainMenu();
    }

    public static void addTestData(){
        PrivateCustomer customer1 = new PrivateCustomer("Bobby Bobsen","Bobsalley 12", 2500, "Honolulu", 25503425, "bobbyBobsen123@hotmail.com",123456789, LocalDate.now());
        CompanyCustomer customer2 = new CompanyCustomer("Michael Johnson", "St. Paul Avenue 23", 3300,"New York",343030320,"MichaelJohnson@gmail.com","Johnson Inc.","Pin Oak Street 211",340340303,24039403);
        Collections.addAll(customerList,customer1,customer2);

        Car car1 = new Car("Chevrolet", "Spark", "Diesel", "MGN 530", LocalDate.now().minusYears(1),250,true,true);
        Car car2 = new Car("Kia", "Rio", "Gasoline 95","YHP 353",LocalDate.now().minusYears(2),2500,false,false);
        FamilyCar car3 = new FamilyCar("Mitsubishi", "Mirage", "Gasoline 90", "SDE 320", LocalDate.now(),2300,true,true,8);
        SportCar car4 = new SportCar("Ferrari","488 Spider","Diesel","LSG 488",LocalDate.now(),0,true,true,2500);
        LuxuryCar car5 = new LuxuryCar("Rolls Royce", "Spectre", "Gasoline 95","OPO 340", LocalDate.now(),0,true,true,9001);
        Collections.addAll(rentalCars,car1,car2,car3,car4,car5);

        RentalContract rentaltest1 = new RentalContract(1, LocalDateTime.now(),LocalDateTime.now().plusWeeks(1),3000,0, car4, customer1,5000);
        RentalContract rentaltest2 = new RentalContract(2, LocalDateTime.now(),LocalDateTime.now().plusWeeks(1),2000,255, car5, customer2,10000);
        Collections.addAll(rentalContracts,rentaltest1,rentaltest2);
    }
}  