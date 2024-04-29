import CarClasses.Car;
import CustomerClasses.Customer;

import CarClasses.Car;
import CarClasses.LuxuryCar;
import CarClasses.SportCar;
import CustomerClasses.CompanyCustomer;
import CustomerClasses.Customer;
import CustomerClasses.PrivateCustomer;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class UI {
    public static void mainMenu(){
        try {
            int answer;
            do {
                System.out.println();
                System.out.println("                   Main Menu                   ");
                System.out.println("===============================================");
                System.out.println("      Input a number to select an option       ");
                System.out.println("===============================================");
                System.out.println("  type 1: Register Rental Contract/Car/Customer");
                System.out.println("  type 2: Edit Rental Contract/Car/Customer    ");
                System.out.println("  type 3: Process Rental Contract              ");
                System.out.println("  type 4: View all Rental Contract/Car/Customer");
                System.out.println("  type 5: Delete Rental Contract/Car/Customer  ");
                System.out.println("  type 0: To exit program                      ");
                answer = Main.userInput.nextInt();
                switch (answer) {
                    case 1:
                        createMenu();
                        break;
                    case 2:
                        System.out.println("Test 2");
                        break;
                    case 3:
                        System.out.println("Test 3");
                        break;
                    case 4:
                        System.out.println("Test 4");
                        for(Car car : Main.rentalCars){
                            System.out.println(car.getBrand());
                        }
                        for(Customer cust : Main.customerList){
                            System.out.println(cust.getDriverName());
                        }
                        for(RentalContract rental : Main.rentalContracts){
                            System.out.println(rental.getContractID());
                        }
                        break;
                    case 5:
                        System.out.println("Test 5");
                        removeMenu();
                        break;
                }
            }
            while (answer != 0);
        }catch (InputMismatchException ignored){
            Main.userInput.nextLine();//clearer scanneren
            mainMenu();
        }
    }

    public static void welcomeMessage(){
        try {
            System.out.println("===============================================");
            System.out.println("        Welcome to Honolulu Car Rental");
            System.out.println("===============================================");
            System.out.println();
            System.out.println("         -           __");
            System.out.println("       --          ~( @\\   \\");
            System.out.println("      ---   _________]_[__/_>________");
            System.out.println("           /  ____ \\ <>     |  ____  \\");
            System.out.println("          =\\_/ __ \\_\\_______|_/ __ \\__D");
            System.out.println("_______________(__)_____________(__)___________");
            Thread.sleep(2000);
        } catch (Exception error) {
            error.printStackTrace();
        }

    }

    public static void createMenu(){
        int answer;
        try {
            System.out.println();
            System.out.println("===============================================");
            System.out.println("      Input a number to select an option       ");
            System.out.println("===============================================");
            System.out.println("  type 1: Register a Rental Contract           ");
            System.out.println("  type 2: Register a Car                       ");
            System.out.println("  type 3: Register a Customer                  ");
            System.out.println("  type 0: To return to the main menu           ");
            answer = Main.userInput.nextInt();
            switch (answer) {
                case 1:
                    registerRental();
                    break;
                case 2:
                    System.out.println("Test 2");
                    registerCar();
                    break;
                case 3:
                    System.out.println("Test 3");
                    registerCustomer();
                    break;
            }
        }catch (InputMismatchException ignored){
            Main.userInput.nextLine();
            mainMenu();
        }
    }

    public static void removeMenu(){
        int answer;
        try {
            System.out.println();
            System.out.println("===============================================");
            System.out.println("      Input a number to select an option       ");
            System.out.println("===============================================");
            System.out.println("  type 1: Remove a Car                         ");
            System.out.println("  type 2: Remove a Customer                    ");
            System.out.println("  type 0: To return to the main menu           ");
            answer = Main.userInput.nextInt();
            switch (answer) {
                case 1:
                    removeCar();
                    break;
                case 2:
                    System.out.println("Test 3");
                    removeCustomer();
                    break;
            }
        }catch (InputMismatchException ignored){
            Main.userInput.nextLine();
            mainMenu();
        }
    }
    ////////////////////////////////////////////////////////////////////////
    //                      register Object below                         //
    ////////////////////////////////////////////////////////////////////////

    public static void registerRental(){
        try {

        }catch (InputMismatchException ignored){
            Main.userInput.nextLine();
            mainMenu();
        }
    }

    public static void registerCar(){
        try {
            System.out.println("Enter car details:");
            System.out.print("Brand: ");
            String brand = Main.userInput.next();
            System.out.print("Model: ");
            String model = Main.userInput.next();

            System.out.print("Fuel type: ");
            String fuelType = Main.userInput.next();

            System.out.print("Registration number: ");
            String registrationNumber = Main.userInput.next();

            System.out.print("Odometer reading: ");
            int odoMeter = Main.userInput.nextInt();

            System.out.print("Automatic gear (true/false): ");
            boolean automaticGear = Main.userInput.nextBoolean();

            System.out.println("Enter the car type\ntype 1: Family car\ntype 2: Luxury car\ntype 3: Sport car");
            int carType = Main.userInput.nextInt();
            Car tempcar = null;
            switch(carType) {
                case 1:
                    System.out.println("How many seats does it have?");
                    int seats = Main.userInput.nextInt();
                    tempcar = new SportCar(brand, model, fuelType, registrationNumber, LocalDate.now().minusDays(0), odoMeter, automaticGear, true, seats);
                    break;
                case 2:
                    System.out.println("What is the cmc of the car?");
                    int cmc = Main.userInput.nextInt();
                    tempcar = new LuxuryCar(brand, model, fuelType, registrationNumber, LocalDate.now().minusDays(0), odoMeter, automaticGear, true, cmc);
                    break;
                case 3:
                    System.out.println("How many horsepower's does the car have?");
                    int horsePower = Main.userInput.nextInt();
                    tempcar = new SportCar(brand, model, fuelType, registrationNumber, LocalDate.now().minusDays(0), odoMeter, automaticGear, true, horsePower);
                    break;
                default:
                    System.out.println("Invalid input. No car was registered");
                    mainMenu();
            }
            if (tempcar != null) {
                Main.rentalCars.add(tempcar);
                System.out.println("The following car was added to the list: "+ tempcar);
            }
        }catch (InputMismatchException ignored){
            Main.userInput.nextLine();
            mainMenu();
        }
    }

    public static void registerCustomer() {
        try {
            System.out.println("Enter driver details:");
            System.out.println("Driver Name: ");
            String driverName = Main.userInput.nextLine();
            Main.userInput.nextLine();
            System.out.println("Address: ");
            String address = Main.userInput.nextLine();
            System.out.print("Postal Code: ");
            int postalCode = Main.userInput.nextInt();
            Main.userInput.nextLine();
            System.out.print("City: ");
            String city = Main.userInput.nextLine();
            System.out.print("Phone Number: ");
            int phoneNumber = Main.userInput.nextInt();
            Main.userInput.nextLine();
            System.out.print("Email: ");
            String email = Main.userInput.nextLine();
            System.out.print("Enter driver type\n type 1: Private\n type 2: Company");
            int driverType = Main.userInput.nextInt();
            Customer tempCustomer = null;
            if (driverType == 1) {
                System.out.print("License Number: ");
                int licenseNumber = Main.userInput.nextInt();
                Main.userInput.nextLine();
                System.out.print("Release Date (e.g YYYY-MM-DD): ");
                String releaseDateStr = Main.userInput.nextLine();
                LocalDate releaseDate = LocalDate.parse(releaseDateStr);
                tempCustomer = new PrivateCustomer(driverName, address, postalCode, city, phoneNumber, email, licenseNumber, releaseDate);
            } else if (driverType == 2) {
                Main.userInput.nextLine();
                System.out.print("Company Name: ");
                String companyName = Main.userInput.nextLine();
                Main.userInput.nextLine();
                System.out.print("Company Address: ");
                String companyAddress = Main.userInput.nextLine();
                System.out.print("Company Phone Number: ");
                int companyPhone = Main.userInput.nextInt();
                System.out.print("Company Registration Number (CRN): ");
                int crn = Main.userInput.nextInt();
                tempCustomer = new CompanyCustomer(driverName, address, postalCode, city, phoneNumber, email, companyName, companyAddress, companyPhone, crn);
            }
            if(tempCustomer != null) {
                Main.customerList.add(tempCustomer);
                System.out.println("The following customer was added to the list: " + tempCustomer);
            }
        } catch (InputMismatchException ignored) {
            Main.userInput.nextLine();
            mainMenu();
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
