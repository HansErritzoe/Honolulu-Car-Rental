import CarClasses.*;
import CustomerClasses.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

//    public static ArrayList<RentalContracts> rentalContracts = ... FileHandler.getRentalcontract();
    public static ArrayList<Car> rentalCars = FileHandler.readCarsFromFile(); //loads cars from File on Startup
    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args){

        /* PrivateCustomer test1 = new PrivateCustomer("Bobby Bobsen","Bobsalley 12", 2500, "Honolulu", 25503425, "bobbyBobsen123@hotmail.com",123456789,LocalDate.now());
        Car c1 = new Car("Chevrolet Spark", "Diesel", "MGN 530", 200505,250,true,true);
        Car c2 = new Car("Kia Rio", "Gasoline 95","YHP 353",2018,2500,false,false);
        FamilyCar c3 = new FamilyCar("Mitsubishi Mirage", "Gasoline 90", "SDE 320", 202004,2300,true,true,8);
        Collections.addAll(rentalCars,c1,c2,c3); */
        FileHandler.writeCarsToFile(rentalCars);
        for(Car car : rentalCars){
            System.out.println(car.getBrandAndModel());
        }
        //menu();
    }
    public static void menu(){
        try {
            int answer;
            do {
                answer = userInput.nextInt();
                switch (answer) {
                    case 1:
                        System.out.println("test");
                        break;
                    case 2:
                        System.out.println("Test 2");
                        break;
                    case 3:
                        System.out.println("Test 3");
                        break;
                    case 4:
                        System.out.println("Test 4");
                        break;
                    case 5:
                        System.out.println("Test 5");
                        break;
                    case 6:
                        System.out.println("Test 6");
                        break;
                    case 7:
                        System.out.println("Test 7");
                        break;
                }
            }
            while (answer != 0);
        }catch (InputMismatchException ignored){
        }
    }
}