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
        // Car objects
        Car car1 = new Car("Toyota", "Corolla", "Gasoline", "ABC123", LocalDate.of(2020, 5, 10), 5000, true, true);
        Car car2 = new Car("Honda", "Civic", "Diesel", "DEF456", LocalDate.of(2019, 8, 20), 7000, false, true);
        Car car3 = new Car("Ford", "Focus", "Gasoline", "GHI789", LocalDate.of(2021, 2, 15), 3000, true, false);
        Car car4 = new Car("BMW", "3 Series", "Electric", "JKL012", LocalDate.of(2022, 10, 5), 2000, false, false);
// FamilyCar objects
        FamilyCar familyCar1 = new FamilyCar("Volkswagen", "Passat", "Diesel", "MNO345", LocalDate.of(2018, 12, 25), 8000, true, true, 5);
        FamilyCar familyCar2 = new FamilyCar("Subaru", "Outback", "Gasoline", "PQR678", LocalDate.of(2017, 6, 30), 6000, false, true, 7);
        FamilyCar familyCar3 = new FamilyCar("Kia", "Sorento", "Hybrid", "STU901", LocalDate.of(2019, 3, 12), 4000, true, true, 7);
        FamilyCar familyCar4 = new FamilyCar("Mazda", "CX-5", "Gasoline", "VWX234", LocalDate.of(2020, 9, 18), 3500, true, false, 5);
// LuxuryCar objects
        LuxuryCar luxuryCar1 = new LuxuryCar("Mercedes-Benz", "S-Class", "Gasoline", "YZA567", LocalDate.of(2022, 1, 5), 1500, true, true, 4000);
        LuxuryCar luxuryCar2 = new LuxuryCar("Audi", "A8", "Diesel", "BCD890", LocalDate.of(2021, 11, 15), 2500, false, true, 3500);
        LuxuryCar luxuryCar3 = new LuxuryCar("Lexus", "LS", "Hybrid", "EFG123", LocalDate.of(2023, 4, 20), 1000, true, false, 3000);
        LuxuryCar luxuryCar4 = new LuxuryCar("Porsche", "Panamera", "Electric", "HIJ456", LocalDate.of(2020, 7, 10), 1800, false, false, 4500);
// SportCar objects
        SportCar sportCar1 = new SportCar("Ferrari", "488 GTB", "Gasoline", "KLM789", LocalDate.of(2021, 8, 30), 500, true, true, 670);
        SportCar sportCar2 = new SportCar("Lamborghini", "Huracan", "Gasoline", "NOP012", LocalDate.of(2020, 6, 25), 600, false, true, 700);
        SportCar sportCar3 = new SportCar("McLaren", "720S", "Gasoline", "QRS345", LocalDate.of(2023, 3, 10), 550, true, false, 710);
        SportCar sportCar4 = new SportCar("Aston Martin", "DB11", "Gasoline", "TUV678", LocalDate.of(2022, 5, 15), 520, false, false, 680);
// PrivateCustomer objects
        PrivateCustomer customer1 = new PrivateCustomer("Bobby Bobsen", "Bobsalley 12", 2500, "Honolulu", 25503425, "bobbyBobsen123@hotmail.com", 123456789,  LocalDate.of(2015, 7, 20));
        PrivateCustomer customer2 = new PrivateCustomer("Alice Anderson", "123 Main Street", 1234, "New York", 98765432, "alice.anderson@email.com", 987654321, LocalDate.of(2018, 9, 15));
        PrivateCustomer customer3 = new PrivateCustomer("John Johnson", "456 Elm Street", 5678, "Los Angeles", 12345678, "john.johnson@email.com", 123456789, LocalDate.of(2019, 11, 25));
        PrivateCustomer customer4 = new PrivateCustomer("Emily Smith", "789 Oak Avenue", 9012, "Chicago", 34567890, "emily.smith@email.com", 987654321, LocalDate.of(2020, 3, 5));
// CompanyCustomer objects
        CompanyCustomer company1 = new CompanyCustomer("John Smith", "10 Business Blvd", 12345, "San Francisco", 987654321, "info@abccompany.com", "ABC Company Inc.", "10 Business Blvd", 987654321, 12345678);
        CompanyCustomer company2 = new CompanyCustomer("Jane Doe", "20 Corporate Ave", 54321, "Seattle", 123456789, "contact@xyzcorp.com", "XYZ Corporation Ltd.", "20 Corporate Ave", 123456789, 87654321);
        CompanyCustomer company3 = new CompanyCustomer("Robert Johnson", "30 Enterprise St", 13579, "Houston", 234567890, "info@efgent.com", "EFG Enterprises LLC", "30 Enterprise St", 234567890, 56789012);
        CompanyCustomer company4 = new CompanyCustomer("Emily Brown", "40 Industry Road", 97531, "Miami", 345678901, "hello@pqrinc.com", "PQR Inc.", "40 Industry Road", 345678901, 90123456);
// RentalContract objects
        RentalContract rentalContract1 = new RentalContract(1, LocalDateTime.of(2024, 5, 5, 10, 0), LocalDateTime.of(2024, 5, 10, 18, 0), 1000, 200, car1, customer1, 300.0);
        RentalContract rentalContract2 = new RentalContract(2, LocalDateTime.of(2024, 5, 7, 9, 0), LocalDateTime.of(2024, 5, 12, 15, 0), 1200, 300, car2, customer2, 350.0);
        RentalContract rentalContract3 = new RentalContract(3, LocalDateTime.of(2024, 5, 8, 8, 0), LocalDateTime.of(2024, 5, 15, 12, 0), 1500, 400, car3, customer3, 400.0);
        RentalContract rentalContract4 = new RentalContract(4, LocalDateTime.of(2024, 5, 10, 11, 0), LocalDateTime.of(2024, 5, 18, 14, 0), 1300, 500, car4, customer4, 380.0);
// Add them all to the ArrayLists
        Collections.addAll(rentalCars,car1,car2,car3,car4,familyCar1,familyCar2,familyCar3,familyCar4,sportCar1,sportCar2,sportCar3,sportCar4,luxuryCar1,luxuryCar2,luxuryCar3,luxuryCar4);
        Collections.addAll(customerList,customer1,customer2,customer3,customer4,company1,company2,company3,company4);
        Collections.addAll(rentalContracts,rentalContract1,rentalContract2,rentalContract3,rentalContract4);

        /* PrivateCustomer customer1 = new PrivateCustomer("Bobby Bobsen","Bobsalley 12", 2500, "Honolulu", 25503425, "bobbyBobsen123@hotmail.com",123456789, LocalDate.now());
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
        */
    }
}  