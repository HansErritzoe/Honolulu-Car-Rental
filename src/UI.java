import CarClasses.Car;
import CustomerClasses.Customer;

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
                    Main.registerRental();
                    break;
                case 2:
                    System.out.println("Test 2");
                    Main.registerCar();
                    break;
                case 3:
                    System.out.println("Test 3");
                    Main.registerCustomer();
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
                    Main.removeCar();
                    break;
                case 2:
                    System.out.println("Test 3");
                    Main.removeCustomer();
                    break;
            }
        }catch (InputMismatchException ignored){
            Main.userInput.nextLine();
            mainMenu();
        }
    }
}
