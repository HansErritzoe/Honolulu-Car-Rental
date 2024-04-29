import CarClasses.*;
import CustomerClasses.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

    ////////////////////////////////////////////////////////////////////////
    //                      register Object below                         //
    ////////////////////////////////////////////////////////////////////////

    public static void registerRental(){
        try {

        }catch (InputMismatchException ignored){
            userInput.nextLine();
            UI.mainMenu();
        }
    }
    public static void registerCar(){
        try {
            System.out.println("Enter car details:");
            System.out.print("Brand: ");
            String brand = userInput.next();
            System.out.print("Model: ");
            String model = userInput.next();

            System.out.print("Fuel type: ");
            String fuelType = userInput.next();

            System.out.print("Registration number: ");
            String registrationNumber = userInput.next();

            System.out.print("Registration year and month (e.g., YYYY-MM): ");
            String registrationYearMonthStr = userInput.nextLine();
            LocalDate registrationYearMonth = LocalDate.parse(registrationYearMonthStr);

            System.out.print("Odometer reading: ");
            int odoMeter = userInput.nextInt();

            System.out.print("Automatic gear (true/false): ");
            boolean automaticGear = userInput.nextBoolean();

            System.out.println("Enter the car type\ntype 1: Family car\ntype 2: Luxury car\ntype 3: Sport car");
            int carType = userInput.nextInt();
            Car tempcar = null;
            switch(carType) {
                case 1:
                    System.out.println("How many seats does it have?");
                    int seats = userInput.nextInt();
                    tempcar = new SportCar(brand, model, fuelType, registrationNumber, registrationYearMonth, odoMeter, automaticGear, true, seats);
                    break;
                case 2:
                    System.out.println("What is the cmc of the car?");
                    int cmc = userInput.nextInt();
                    tempcar = new LuxuryCar(brand, model, fuelType, registrationNumber, registrationYearMonth, odoMeter, automaticGear, true, cmc);
                    break;
                case 3:
                    System.out.println("How many horsepower's does the car have?");
                    int horsePower = userInput.nextInt();
                    tempcar = new SportCar(brand, model, fuelType, registrationNumber, registrationYearMonth, odoMeter, automaticGear, true, horsePower);
                    break;
                default:
                    System.out.println("Invalid input. No car was registered");
                    UI.mainMenu();
            }
            if (tempcar != null) {
                rentalCars.add(tempcar);
                System.out.println("The following car was added to the list: "+ tempcar);
            }
        }catch (InputMismatchException ignored){
            userInput.nextLine();
            UI.mainMenu();
        }
    }
    public static void registerCustomer() {
        try {
            System.out.println("Enter driver details:");
            System.out.println("Driver Name: ");
            String driverName = userInput.nextLine();
            userInput.nextLine();
            System.out.println("Address: ");
            String address = userInput.nextLine();
            System.out.print("Postal Code: ");
            int postalCode = userInput.nextInt();
            userInput.nextLine();
            System.out.print("City: ");
            String city = userInput.nextLine();
            System.out.print("Phone Number: ");
            int phoneNumber = userInput.nextInt();
            userInput.nextLine();
            System.out.print("Email: ");
            String email = userInput.nextLine();
            System.out.print("Enter driver type\n type 1: Private\n type 2: Company");
            int driverType = userInput.nextInt();
            Customer tempCustomer = null;
            if (driverType == 1) {
                System.out.print("License Number: ");
                int licenseNumber = userInput.nextInt();
                userInput.nextLine();
                System.out.print("Release Date (e.g YYYY-MM-DD): ");
                String releaseDateStr = userInput.nextLine();
                LocalDate releaseDate = LocalDate.parse(releaseDateStr);
                tempCustomer = new PrivateCustomer(driverName, address, postalCode, city, phoneNumber, email, licenseNumber, releaseDate);
            } else if (driverType == 2) {
                userInput.nextLine();
                System.out.print("Company Name: ");
                String companyName = userInput.nextLine();
                userInput.nextLine();
                System.out.print("Company Address: ");
                String companyAddress = userInput.nextLine();
                System.out.print("Company Phone Number: ");
                int companyPhone = userInput.nextInt();
                System.out.print("Company Registration Number (CRN): ");
                int crn = userInput.nextInt();
                tempCustomer = new CompanyCustomer(driverName, address, postalCode, city, phoneNumber, email, companyName, companyAddress, companyPhone, crn);
            }
            if(tempCustomer != null) {
                customerList.add(tempCustomer);
                System.out.println("The following customer was added to the list: " + tempCustomer);
            }
        } catch (InputMismatchException ignored) {
            userInput.nextLine();
            UI.mainMenu();
        }
    }

    ////////////////////////////////////////////////////////////////////////
    //                      Remove object below                           //
    ////////////////////////////////////////////////////////////////////////

    public static void removeCar(){

    }

    public static void removeCustomer(){

    }
}