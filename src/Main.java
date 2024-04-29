import CarClasses.*;
import CustomerClasses.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<RentalContract> rentalContracts =  FileHandler.readRentalContractsFromFile();
    public static ArrayList<Car> rentalCars = FileHandler.readCarsFromFile(); //loads cars from File on Startup
    public static ArrayList<Customer> customerList = FileHandler.readCustomersFromFile();

    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args){
        UI.welcomeMessage();
        UI.mainMenu();

        //Car tests below

        /* PrivateCustomer test1 = new PrivateCustomer("Bobby Bobsen","Bobsalley 12", 2500, "Honolulu", 25503425, "bobbyBobsen123@hotmail.com",123456789, LocalDate.now());
        Car c1 = new Car("Chevrolet", "Spark", "Diesel", "MGN 530", 200505,250,true,true);
        Car c2 = new Car("Kia", "Rio", "Gasoline 95","YHP 353",2018,2500,false,false);
        FamilyCar c3 = new FamilyCar("Mitsubishi", "Mirage", "Gasoline 90", "SDE 320", 202004,2300,true,true,8);
        Collections.addAll(rentalCars,c1,c2,c3);
        FileHandler.writeCarsToFile(rentalCars);
        for(Car car : rentalCars){
            System.out.println(car.getBrand());
        }*/

        //Customer tests below

        /* PrivateCustomer ctest1 = new PrivateCustomer("Bobby Bobsen","Bobsalley 12", 2500, "Honolulu", 25503425, "bobbyBobsen123@hotmail.com",123456789, LocalDate.now());
        Customer ctest2 = new Customer("Johnny Bobsen", "BObbyvej 12",2600,"Hanoi",342342343,"JohnB@email.com");
        Collections.addAll(customerList,ctest1,ctest2);
        for(Customer cust : customerList){
            System.out.println(cust.getDriverName());
        }
        FileHandler.writeCustomersToFile(customerList); */

        //RentalContract tests below
        /*
        Car car1 = new Car("Chevrolet", "Spark", "Diesel", "MGN 530", 200505,250,true,true);
        Car car2 = new Car("Kia", "Rio", "Gasoline 95","YHP 353",2018,2500,false,false);
        FamilyCar car3 = new FamilyCar("Mitsubishi", "Mirage", "Gasoline 90", "SDE 320", 202004,2300,true,true,8);
        PrivateCustomer custTest1 = new PrivateCustomer("Bobby Bobsen","Bobsalley 12", 2500, "Honolulu", 25503425, "bobbyBobsen123@hotmail.com",123456789, LocalDate.now());
        Customer custTest2 = new Customer("Johnny Bobsen", "BObbyvej 12",2600,"Hanoi",342342343,"JohnB@email.com");
        ArrayList<Car> rentalContractTestArray = new ArrayList<>();
        ArrayList<Car> rentalContractTestArray2 = new ArrayList<>();
        Collections.addAll(rentalContractTestArray,car1, car2);
        Collections.addAll(rentalContractTestArray2,car3);
        RentalContract rtest1 = new RentalContract(1, LocalDateTime.now(),LocalDateTime.now(),300,0, rentalContractTestArray, custTest1,5000);
        RentalContract rtest2 = new RentalContract(2, LocalDateTime.now(),LocalDateTime.now(),200,5, rentalContractTestArray2, custTest2,10000);
        Collections.addAll(rentalContracts,rtest2,rtest1);
        FileHandler.writeRentalContractsToFile(rentalContracts);

        for(RentalContract r : rentalContracts){
            System.out.println("ID: " + r.getContractID());
            System.out.println("price: " + r.getPrice());
            System.out.println(r.getCustomer().getDriverName());
            System.out.println(r.getRentedCars().get(0).getBrand());
            System.out.println(r.getRentedCars().get(0).getModel());
        }
         */
    }
}