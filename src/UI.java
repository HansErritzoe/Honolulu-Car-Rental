import CarClasses.*;
import CustomerClasses.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
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
                        editSubmenu();
                        break;
                    case 3:
                        processContract();
                        break;
                    case 4:
                        viewAllSubMenu();
                        break;
                    case 5:
                        removeMenu();
                        break;
                }
            }
            while (answer != 0);
        }catch (InputMismatchException ignored){
            Main.userInput.nextLine();
            mainMenu();
        }
    }


    //submenu for selecting which objects you want to edit
    private static void editSubmenu() {
        System.out.println();
        System.out.println("               Edit Submenu                ");
        System.out.println("===============================================");
        System.out.println("      Input a number to select an option       ");
        System.out.println("===============================================");
        System.out.println("  type 1: Edit a car                           ");
        System.out.println("  type 2: Edit a customer                      ");
        System.out.println("  type 3: Edit a rental contract               ");
        System.out.println("  type 0: To return to the main menu           ");
        try {
            int answer = Main.userInput.nextInt();
            switch(answer){
                case 1:
                    editCar();
                    break;
                case 2:
                    Main.userInput.nextLine();
                    editCustomer();
                    break;
                case 3:
                    editRentalContract();
                    break;
                case 0:
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid Choice");
                    System.out.println("Try again");
                    editSubmenu();
                    break;
            }
        } catch (Exception ignored) {
            Main.userInput.nextLine();
            System.out.println();
            System.out.println("Invalid Input");
            System.out.println("Try again");
            System.out.println();
            editSubmenu();
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
            //Thread.sleep(2000); //uncomment at launch!
        } catch (Exception ignored) {
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
            Main.userInput.nextLine();
            Customer tempCustomer = null;
            do{
                System.out.println("Enter the customer's full name");
                String name = Main.userInput.nextLine();
                int count = 0;
                for(Customer foundCustomer : Main.customerList){
                    if(foundCustomer.getDriverName().equalsIgnoreCase(name)){
                        tempCustomer = foundCustomer;
                        count++;
                    }
                }
                if(count == 0 && name != null & !name.isEmpty()){
                    System.out.println("Sorry no customer with that name in our files");
                    System.out.println("Add a new Customer to our files?\ntype 1: To add new Customer\ntype 0: To try again");
                    int answer;
                    try{
                        answer = Main.userInput.nextInt();
                        Main.userInput.nextLine();
                        if (answer == 1){
                            registerCustomer();
                        }
                    } catch (InputMismatchException ignored){
                        System.out.println("Invalid input. Please enter 1 or 0");
                    }
                }
            }while(tempCustomer == null);
            Car tempCar = null;
            do{
                System.out.println("Enter the cars numberplate");
                String car = Main.userInput.nextLine();
                int count = 0;
                for(Car foundCar : Main.rentalCars){
                    if(foundCar.getRegistrationNumber().equalsIgnoreCase(car)){
                        tempCar = foundCar;
                        count++;
                    }
                }
                if(count == 0 && car != null & !car.isEmpty()){
                    System.out.println("Sorry no car with that numberplate in our files");
                    System.out.println("Add a new Car to our files?\ntype 1: To add new Car\ntype 0: To try again");
                    int answer;
                    try{
                        answer = Main.userInput.nextInt();
                        Main.userInput.nextLine();
                        if (answer == 1){
                            registerCar();
                            Main.userInput.nextLine();
                        }
                    } catch (InputMismatchException ignored){
                        System.out.println("Invalid input. Please enter 1 or 0");
                    }
                }
            }while(tempCar == null);
            tempCar.setAvailable(false);
            int contractID = 0;
            for (RentalContract contract : Main.rentalContracts) {
                if (contract.getContractID() >= contractID) {
                    contractID = contract.getContractID() + 1;
                }
            }
            System.out.println(contractID);
            LocalDateTime startTime = LocalDateTime.now();
            LocalDateTime endTime = null;
            do {
                System.out.println("Choose duration for rental end time:");
                System.out.println("1. 1 week");
                System.out.println("2. 2 weeks");
                System.out.println("3. Custom");
                int choice = Main.userInput.nextInt();
                Main.userInput.nextLine();
                switch (choice) {
                    case 1:
                        endTime = startTime.plusWeeks(1);
                        break;
                    case 2:
                        endTime = startTime.plusWeeks(2);
                        break;
                    case 3:
                        System.out.print("Enter Custom End Date (yyyy-MM-dd): ");
                        String endDateString = Main.userInput.nextLine();
                        endTime = LocalDateTime.parse(endDateString);
                        break;
                    default:
                        System.out.println("Invalid input. Please try again");
                }
            }while (endTime == null);
            System.out.print("Enter Max KM: ");
            int maxKM = Main.userInput.nextInt();
            Main.userInput.nextLine();
            int startKM = tempCar.getOdoMeter();
            int price;
            if(tempCar instanceof FamilyCar){
                price = 150;
            } else if(tempCar instanceof LuxuryCar){
                price = 300;
            } else  if(tempCar instanceof SportCar){
                price = 250;
            } else{
                price = 100;
            }
            Main.userInput.nextLine();
            RentalContract tempContract = new RentalContract(contractID,startTime,endTime,maxKM,startKM,tempCar,tempCustomer,price);
            Main.rentalContracts.add(tempContract);
            FileHandler.writeRentalContractsToFile(Main.rentalContracts);
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
                FileHandler.writeCarsToFile(Main.rentalCars);
                System.out.println("The following car was added to the list: \n\n"+ tempcar);
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
                FileHandler.writeCustomersToFile(Main.customerList);
                System.out.println("The following customer was added to the list: " + tempCustomer);
            }
        } catch (InputMismatchException ignored) {
            Main.userInput.nextLine();
            mainMenu();
        }
    }
    public static void processContract(){
        System.out.println("Enter the id of the contract you want to process");
        if(Main.userInput.hasNextLine()){Main.userInput.nextLine();}
        int contractID = Main.userInput.nextInt();
        for(RentalContract contract : Main.rentalContracts){
            if (contract.getContractID() == contractID){
                System.out.println("What is the new odometer reading of the car?");
                int newOdometer = Main.userInput.nextInt();
                int oldOdometer = contract.getRentedCars().getOdoMeter();
                double toPay = contract.price;
                if(newOdometer - oldOdometer > contract.maxKM){
                    toPay += (newOdometer - oldOdometer)*1.5;
                }
                System.out.println("The total price to pay for renting is: "+toPay);
                contract.getRentedCars().setOdoMeter(newOdometer);
                contract.getRentedCars().setAvailable(true);
                Main.rentalContracts.remove(contract);
                break;
            }
        }
        FileHandler.writeRentalContractsToFile(Main.rentalContracts);
    }


    //displays submenu where user can select if they want to view registered cars, customers or rental contracts
    public static void viewAllSubMenu(){
        System.out.println();
        System.out.println("               View all Submenu                ");
        System.out.println("===============================================");
        System.out.println("      Input a number to select an option       ");
        System.out.println("===============================================");
        System.out.println("  type 1: View cars                 ");
        System.out.println("  type 2: View customers            ");
        System.out.println("  type 3: View rental contracts     ");
        System.out.println("  type 0: To return to the main menu           ");
        try {
            int answer = Main.userInput.nextInt();
            switch(answer){
                case 1:
                    viewCarsMenu();
                    break;
                case 2:
                    viewCustomersMenu();
                    break;
                case 3:
                    viewRentalContractsMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid Choice");
                    System.out.println("Try again");
                    viewAllSubMenu();
                    break;
            }
        } catch (Exception ignored) {
            Main.userInput.nextLine();
            System.out.println();
            System.out.println("Invalid Input");
            System.out.println("Try again");
            System.out.println();
            viewAllSubMenu();
        }
    }

    //submenu where user can select how they want the Rental Contracts displayed
    private static void viewRentalContractsMenu() {
        System.out.println();
        System.out.println("           View Rental Contracts Menu          ");
        System.out.println("===============================================");
        System.out.println("      Input a number to select an option       ");
        System.out.println("===============================================");
        System.out.println("  type 1: View all Rental Contracts            ");
        System.out.println("  type 2: Search by ID                         ");
        System.out.println("  type 3: Search by Customer name              ");
        System.out.println("  type 0: To return to the main menu           ");
        try {
            int answer = Main.userInput.nextInt();
            switch(answer){
                case 1: //print all
                    Collections.sort(Main.rentalContracts);
                    System.out.println();
                    for(RentalContract rentalContract : Main.rentalContracts){
                        System.out.println(rentalContract);
                        System.out.println();
                    }
                    break;
                case 2: //search by ID
                    System.out.println("Input Contract ID");
                    int id = Main.userInput.nextInt();
                    int count = 0;
                    for(RentalContract rentalContract : Main.rentalContracts){
                        if (rentalContract.getContractID() == id) {
                            System.out.println();
                            System.out.println(rentalContract);
                            System.out.println();
                            count++;
                        }
                    }
                    if(count == 0){
                        System.out.println();
                        System.out.println("Sorry no Rental Contract with that ID in our files");
                        System.out.println();
                        viewRentalContractsMenu();
                    }
                    break;
                case 3: //search by customer name
                    Main.userInput.nextLine();
                    System.out.println("Input customer name");
                    String name = Main.userInput.nextLine();
                    int count2 = 0;
                    for(RentalContract rentalContract : Main.rentalContracts){
                        if (rentalContract.getCustomer().getDriverName().equalsIgnoreCase(name)) {
                            System.out.println();
                            System.out.println(rentalContract);
                            System.out.println();
                            count2++;
                        }
                    }
                    if(count2 == 0){
                        System.out.println();
                        System.out.println("Sorry no Rental Contract with a customer with that name in our files");
                        System.out.println();
                        viewCustomersMenu();
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid Choice");
                    System.out.println("Try again");
                    System.out.println();
                    viewRentalContractsMenu();
                    break;

            }
        } catch (Exception ignored) {
            Main.userInput.nextLine();
            System.out.println();
            System.out.println("Invalid Input");
            System.out.println("Try again");
            System.out.println();
            viewRentalContractsMenu();
        }
    }

    //submenu where user can select how they want customers displayed or search by name
    private static void viewCustomersMenu() {
        System.out.println();
        System.out.println("            View All Customers menu         ");
        System.out.println("===============================================");
        System.out.println("      Input a number to select an option       ");
        System.out.println("===============================================");
        System.out.println("  type 1: View all customers alphabetically    ");
        System.out.println("  type 2: View all Private Customers           ");
        System.out.println("  type 3: View all Company Customers           ");
        System.out.println("  type 4: Search Customer by name              ");
        System.out.println("  type 0: To return to the main menu           ");
        try {
            int answer = Main.userInput.nextInt();
            switch(answer){
                case 1: //print all customers alphabetically
                    Collections.sort(Main.customerList);
                    System.out.println();
                    for(Customer customer : Main.customerList){
                        System.out.println(customer);
                        System.out.println();
                    }
                    break;
                case 2://view all Private customers
                    Collections.sort(Main.customerList);
                    System.out.println();
                    for(Customer customer : Main.customerList){
                        if(customer instanceof PrivateCustomer) {
                            System.out.println(customer);
                            System.out.println();
                        }
                    }
                    break;
                case 3: //view all Company customers
                    Collections.sort(Main.customerList);
                    System.out.println();
                    for(Customer customer : Main.customerList){
                        if(customer instanceof CompanyCustomer) {
                            System.out.println(customer);
                            System.out.println();
                        }
                    }
                    break;
                case 4: //search by name
                    System.out.println("Input full name of customer");
                    Main.userInput.nextLine();//clears scanner from int
                    String input = Main.userInput.nextLine();
                    int count = 0;
                    for(Customer customer : Main.customerList){
                        if (customer.getDriverName().equalsIgnoreCase(input)) {
                            System.out.println();
                            System.out.println(customer);
                            System.out.println();
                            count++;
                        }
                    }
                    if(count == 0){ //if no customers were found
                        System.out.println();
                        System.out.println("Sorry no customer by that name in our files");
                        System.out.println();
                        viewCustomersMenu();
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid Choice");
                    System.out.println("Try again");
                    viewCustomersMenu();
                    break;
            }
        } catch (Exception ignored) {
            Main.userInput.nextLine();
            System.out.println();
            System.out.println("Invalid Input");
            System.out.println("Try again");
            System.out.println();
            viewCustomersMenu();
        }
    }

    //submenu where user can select which cars they want displayed
    private static void viewCarsMenu() {
        System.out.println();
        System.out.println("               View All Cars menu              ");
        System.out.println("===============================================");
        System.out.println("      Input a number to select an option       ");
        System.out.println("===============================================");
        System.out.println("  type 1: View all cars alphabetically         ");
        System.out.println("  type 2: View only available cars             ");
        System.out.println("  type 3: View only available Normal Cars      ");
        System.out.println("  type 4: View only available Family Cars      ");
        System.out.println("  type 5: View only available Sports Cars      ");
        System.out.println("  type 6: View only available Luxury Cars      ");
        System.out.println("  type 0: To return to the main menu           ");
        try {
            int answer = Main.userInput.nextInt();
            switch(answer){
                case 1: //all cars alphabetically
                    Collections.sort(Main.rentalCars);
                    System.out.println();
                    for(Car car : Main.rentalCars){
                        System.out.println();
                        System.out.println(car.toString());
                    }
                    break;
                case 2: //only available cars
                    Collections.sort(Main.rentalCars);
                    System.out.println();
                    for(Car car : Main.rentalCars){
                        if(car.isAvailable()) {
                            System.out.println();
                            System.out.println(car);
                        }
                    }
                    break;
                case 3: //only available normal cars
                    Collections.sort(Main.rentalCars);
                    System.out.println();
                    for(Car car : Main.rentalCars){
                        if(car.isAvailable() && !(car instanceof FamilyCar) && !(car instanceof SportCar) && !(car instanceof LuxuryCar)) {
                            System.out.println() ;
                            System.out.println(car);
                        }
                    }
                    break;
                case 4: //only available Family Cars
                    Collections.sort(Main.rentalCars);
                    System.out.println();
                    for(Car car : Main.rentalCars){
                        if(car.isAvailable() && car instanceof FamilyCar) {
                            System.out.println();
                            System.out.println(car);
                        }
                    }
                    break;
                case 5: //only available sports Cars
                    Collections.sort(Main.rentalCars);
                    System.out.println();
                    for(Car car : Main.rentalCars){
                        if(car.isAvailable() && car instanceof SportCar) {
                            System.out.println();
                            System.out.println(car);
                        }
                    }
                    break;
                case 6: //only available Luxury Cars
                    Collections.sort(Main.rentalCars);
                    System.out.println();
                    for(Car car : Main.rentalCars){
                        if(car.isAvailable() && car instanceof LuxuryCar) {
                            System.out.println();
                            System.out.println(car);
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid Choice");
                    System.out.println("Try again");
                    viewCarsMenu();
                    break;
            }
        } catch (Exception ignored) {
            Main.userInput.nextLine();
            System.out.println();
            System.out.println("Invalid Input");
            System.out.println("Try again");
            System.out.println();
            viewCarsMenu();
        }
    }
    //method for editing a Rental Contract object through the console
    private static void editRentalContract() {
        try {
            System.out.println();
            Collections.sort(Main.rentalContracts);
            for(RentalContract rentalContract : Main.rentalContracts){
                System.out.println(rentalContract);
                System.out.println();
            }
            System.out.println("Above is displayed list of all rental contracts in case needed");
            System.out.println();
            int rentalContractID;
            RentalContract tempContract = null;
            do {
                System.out.println("Enter Rental Contract ID of the contract you want to edit");
                rentalContractID = Main.userInput.nextInt();
                int count = 0;
                for(RentalContract rentalContract : Main.rentalContracts){
                    if(rentalContract.getContractID() == rentalContractID){
                        tempContract = rentalContract;
                        count++;
                    }
                }
                if(count == 0){ //if no rental contract
                    System.out.println("Sorry no rental contract with that ID found");
                    System.out.println();
                    System.out.println("Type 1 to try again");
                    System.out.println("Type 0 to return to Main Menu");
                    int answer = Main.userInput.nextInt();
                    Main.userInput.nextLine();
                    if(answer == 0){
                        System.out.println("Returning to Main Menu");
                        return;
                    }
                }
            } while (tempContract == null);
            System.out.println("Rental contract found with ID: \"" + rentalContractID + "\"");
            System.out.println("  type 1: Edit contract ID               ");
            System.out.println("  type 2: Edit contract start time       ");
            System.out.println("  type 3: Edit contract end time         ");
            System.out.println("  type 4: Edit contract max miles        ");
            System.out.println("  type 5: Edit contract start miles      ");
            System.out.println("  type 6: Edit which Car is on the contract             ");
            System.out.println("  type 7: Edit which Customer is on the contract        ");
            System.out.println("  type 8: Edit contracts price           ");
            System.out.println("  type 0: To return to the main menu     ");
            int answer = Main.userInput.nextInt();
            Main.userInput.nextLine();
            switch(answer){
                case 1://contract ID
                    System.out.println("This contract's current ID = \""+tempContract.getContractID()+"\"");
                    System.out.println("Enter new contract ID");
                    int newID = Main.userInput.nextInt();
                    tempContract.setContractID(newID);
                    System.out.println("Change accepted, contract now looks like this:");
                    printContractNicely(tempContract);
                    break;
                case 2: //start time
                    LocalDateTime newStartTime = null;
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm");
                    do{
                        System.out.println("This contract's current start time = \""+tempContract.getStartTime().format(dateTimeFormatter)+"\"");
                        System.out.println("Enter new start time for this contract");
                        System.out.println("Format: yyyy-mm-dd hh:mm as seen above");
                        String newTime = Main.userInput.nextLine();
                        int count = 0;
                        try{
                            newStartTime = LocalDateTime.parse(newTime,dateTimeFormatter);
                        } catch (Exception e){
                            System.out.println();
                            System.out.println("Invalid format");
                            System.out.println("Try again");
                            System.out.println();
                        }
                    } while (newStartTime == null);
                    tempContract.setStartTime(newStartTime);
                    System.out.println("Change accepted, Rental Contract now looks like this:");
                    printContractNicely(tempContract);
                    break;
                case 3: //end time
                    LocalDateTime newEndTime = null;
                    DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm");
                    do{
                        System.out.println("This contract's current end time = \""+tempContract.getEndTime().format(dateTimeFormatter2)+"\"");
                        System.out.println("Enter new end time for this contract");
                        System.out.println("Format: yyyy-mm-dd hh:mm as seen above");
                        String newTime = Main.userInput.nextLine();
                        int count = 0;
                        try{
                            newEndTime = LocalDateTime.parse(newTime,dateTimeFormatter2);
                        } catch (Exception e){
                            System.out.println();
                            System.out.println("Invalid format");
                            System.out.println("Try again");
                            System.out.println();
                        }
                    } while (newEndTime == null);
                    tempContract.setEndTime(newEndTime);
                    System.out.println("Change accepted, Rental Contract now looks like this:");
                    printContractNicely(tempContract);
                    break;
                case 4: //max miles
                    System.out.println("This contract's max miles = \""+tempContract.getMaxKM()+"\"");
                    System.out.println("Enter new max miles");
                    int newMaxMiles = Main.userInput.nextInt();
                    tempContract.setMaxKM(newMaxMiles);
                    System.out.println("Change accepted, contract now looks like this:");
                    printContractNicely(tempContract);
                    break;
                case 5: //start miles
                    System.out.println("This contract's start miles = \""+tempContract.getStartKM()+"\"");
                    System.out.println("Enter new start miles");
                    int newStartMiles = Main.userInput.nextInt();
                    tempContract.setStartKM(newStartMiles);
                    System.out.println("Change accepted, contract now looks like this:");
                    printContractNicely(tempContract);
                    break;
                case 6: //car
                    String licensePlate;
                    Car tempCar = null;
                    do { //do while car not found
                        System.out.println("Enter License Plate of the car you want on the contract");
                        licensePlate = Main.userInput.nextLine();
                        int count = 0;
                        for(Car car : Main.rentalCars){
                            if(car.getRegistrationNumber().equalsIgnoreCase(licensePlate.toLowerCase())){
                                tempCar = car;
                                count++;
                            }
                        }
                        if(count == 0){ //if no car found
                            System.out.println("Sorry no Car with that license plate found");
                            System.out.println();
                            System.out.println("Type 1 to try again");
                            System.out.println("Type 2 to add a new car to the system");
                            System.out.println("Type 0 to return to Main Menu");
                            int answer2 = Main.userInput.nextInt();
                            Main.userInput.nextLine();
                            if(answer2 == 0){
                                System.out.println("Returning to Main Menu");
                                return;
                            } else if(answer2 == 2){
                                registerCar();
                                Main.userInput.nextLine();
                                System.out.println();
                            }
                        }
                    } while (tempCar == null); //do while car not found
                    System.out.println("Car found with license plate: \"" + licensePlate+"\":");
                    printCarNicely(tempCar);
                    tempContract.setRentedCars(tempCar);
                    System.out.println("Change accepted, contract now looks like this:");
                    printContractNicely(tempContract);
                    break;
                case 7: //customer
                    String driverName;
                    Customer tempCustomer = null;
                    do { //do while customer not found
                        System.out.println("Enter driver name of customer you want on the contract");
                        driverName = Main.userInput.nextLine();
                        int count = 0;
                        for(Customer customer : Main.customerList){
                            if(customer.getDriverName().equalsIgnoreCase(driverName.toLowerCase())){
                                tempCustomer = customer;
                                count++;
                            }
                        }
                        if(count == 0){ //if no car found
                            System.out.println("Sorry no customer with that driver name found");
                            System.out.println();
                            System.out.println("Type 1 to try again");
                            System.out.println("Type 2 to add a new customer to the system");
                            System.out.println("Type 0 to return to Main Menu");
                            int answer3 = Main.userInput.nextInt();
                            Main.userInput.nextLine();
                            if(answer3 == 0){
                                System.out.println("Returning to Main Menu");
                                return;
                            } else if(answer3 == 2){
                                registerCustomer();
                                Main.userInput.nextLine();
                                System.out.println();
                            }
                        }
                    } while (tempCustomer == null); //do while car not found
                    System.out.println("Customer found with driver name: \"" + driverName+"\":");
                    printCustomerNicely(tempCustomer);
                    tempContract.setCustomer(tempCustomer);
                    System.out.println("Change accepted, contract now looks like this:");
                    printContractNicely(tempContract);
                    break;
                case 8://price
                    System.out.println("This current price = \""+tempContract.getPrice()+"\"");
                    System.out.println("Enter new price");
                    int newPrice = Main.userInput.nextInt();
                    tempContract.setMaxKM(newPrice);
                    System.out.println("Change accepted, contract now looks like this:");
                    printContractNicely(tempContract);
                    break;
                case 0:
                    System.out.println("Returning to main Menu");
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid Choice");
                    System.out.println("Try again");
                    editRentalContract();
                    break;
            }
        } catch (Exception e) {
            Main.userInput.nextLine();
            System.out.println();
            System.out.println("Invalid Input");
            System.out.println("Returning to Main Menu");
        }

    }


    //method for user to edit a Customer Object through the console
    public static void editCustomer(){
        try {
            System.out.println();
            Collections.sort(Main.customerList);
            for(Customer customer : Main.customerList){
                System.out.println(customer);
                System.out.println();
            }
            System.out.println("Above is displayed list of all Customers in case needed");
            System.out.println();
            String driverName;
            Customer tempCustomer = null;
            do {
                System.out.println("Enter Driver name of the customer you want to edit");
                driverName = Main.userInput.nextLine();
                int count = 0;
                for(Customer customer : Main.customerList){
                    if(customer.getDriverName().equalsIgnoreCase(driverName)){
                        tempCustomer = customer;
                        count++;
                    }
                }
                if(count == 0){ //if no customer
                    System.out.println("Sorry no Customer with that driver name found");
                    System.out.println();
                    System.out.println("Type 1 to try again");
                    System.out.println("Type 0 to return to Main Menu");
                    int answer = Main.userInput.nextInt();
                    Main.userInput.nextLine();
                    if(answer == 0){
                        System.out.println("Returning to Main Menu");
                        return;
                    }
                }
            } while (tempCustomer == null);
            System.out.println("Customer found with driver name: \"" + driverName+"\"");
                System.out.println("  type 1: Edit driver's name                     ");
                System.out.println("  type 2: Edit Address                           ");
                System.out.println("  type 3: Edit postal code                       ");
                System.out.println("  type 4: Edit city                              ");
                System.out.println("  type 5: Edit phone number                      ");
                System.out.println("  type 6: Edit email                             ");
                if(tempCustomer instanceof PrivateCustomer){
                    System.out.println("  type 7: Edit licenseNumber                 ");
                    System.out.println("  type 8: Edit license release date          ");
                } else if(tempCustomer instanceof CompanyCustomer) {
                    System.out.println("  type 7: Edit company name                  ");
                    System.out.println("  type 8: Edit company address               ");
                    System.out.println("  type 9: Edit company phone                 ");
                    System.out.println("  type 10: Edit company's crn number          ");
                }
                System.out.println("  type 0: To return to the main menu           ");
                int answer = Main.userInput.nextInt();
                Main.userInput.nextLine();
                switch(answer){ //switch for changing the specific field
                    case 1://driver's name
                        System.out.println("Customer's current driver name: \"" + tempCustomer.getDriverName() + "\"");
                        System.out.println("Enter new driver name");
                        String newDriverName = Main.userInput.nextLine();
                        tempCustomer.setDriverName(newDriverName);
                        System.out.println("Change accepted, Customer now looks like this:");
                        printCustomerNicely(tempCustomer);
                        break;
                    case 2://address
                        System.out.println("Customer's current address: \"" + tempCustomer.getAddress() + "\"");
                        System.out.println("Enter new address");
                        String newAddress = Main.userInput.nextLine();
                        tempCustomer.setAddress(newAddress);
                        System.out.println("Change accepted, Customer now looks like this:");
                        printCustomerNicely(tempCustomer);
                        break;
                    case 3://postal code
                        System.out.println("Customer's current postal code: \"" + tempCustomer.getPostalCode() + "\"");
                        System.out.println("Enter new postal code");
                        int newPostalCode = Main.userInput.nextInt();
                        tempCustomer.setPostalCode(newPostalCode);
                        System.out.println("Change accepted, Customer now looks like this:");
                        printCustomerNicely(tempCustomer);
                        break;
                    case 4://city
                        System.out.println("Customer's current city: \"" + tempCustomer.getCity() + "\"");
                        System.out.println("Enter new city");
                        String newCity = Main.userInput.nextLine();
                        tempCustomer.setCity(newCity);
                        System.out.println("Change accepted, Customer now looks like this:");
                        printCustomerNicely(tempCustomer);
                        break;
                    case 5://phone number
                        System.out.println("Customer's current phone number: \"" + tempCustomer.getPhoneNumber() + "\"");
                        System.out.println("Enter new phone number");
                        int newPhoneNumber = Main.userInput.nextInt();
                        tempCustomer.setPhoneNumber(newPhoneNumber);
                        System.out.println("Change accepted, Customer now looks like this:");
                        printCustomerNicely(tempCustomer);
                        break;
                    case 6://email
                        System.out.println("Customer's current email: \"" + tempCustomer.getEmail() + "\"");
                        System.out.println("Enter new email address");
                        String newEmail = Main.userInput.nextLine();
                        tempCustomer.setEmail(newEmail);
                        System.out.println("Change accepted, Customer now looks like this:");
                        printCustomerNicely(tempCustomer);
                        break;
                    case 7://company type dependant: private=licenseNumber - Company=company name
                        if(tempCustomer instanceof PrivateCustomer){
                            System.out.println("Customer's current license number: \"" + ((PrivateCustomer) tempCustomer).getLicenseNumber() + "\"");
                            System.out.println("Enter new license number");
                            int newLicenseNumber = Main.userInput.nextInt();
                            ((PrivateCustomer) tempCustomer).setLicenseNumber(newLicenseNumber);
                            System.out.println("Change accepted, Customer now looks like this:");
                            printCustomerNicely(tempCustomer);
                        } else if (tempCustomer instanceof CompanyCustomer){
                            System.out.println("Customer's current email: \"" + ((CompanyCustomer) tempCustomer).getCompanyName() + "\"");
                            System.out.println("Enter new company name");
                            String newCompanyName = Main.userInput.nextLine();
                            ((CompanyCustomer) tempCustomer).setCompanyName(newCompanyName);
                            System.out.println("Change accepted, Customer now looks like this:");
                            printCustomerNicely(tempCustomer);
                        }
                        break;
                    case 8: //company type dependant: private=release date - Company = company address
                        if(tempCustomer instanceof PrivateCustomer){
                            System.out.println("Customer's current license release date: \"" + ((PrivateCustomer) tempCustomer).getReleaseDate() + "\"");
                            System.out.println("Enter new license release date (format: yyyy-mm-dd)");
                            LocalDate newDate;
                            newDate = LocalDate.parse(Main.userInput.nextLine());
                            ((PrivateCustomer) tempCustomer).setReleaseDate(newDate);
                            System.out.println("Change accepted, Customer now looks like this:");
                            printCustomerNicely(tempCustomer);
                        } else if (tempCustomer instanceof CompanyCustomer){
                            System.out.println("Customer's current company address: \"" + ((CompanyCustomer) tempCustomer).getCompanyAddress() + "\"");
                            System.out.println("Enter new company address");
                            String newCompanyAddress = Main.userInput.nextLine();
                            ((CompanyCustomer) tempCustomer).setCompanyAddress(newCompanyAddress);
                            System.out.println("Change accepted, Customer now looks like this:");
                            printCustomerNicely(tempCustomer);
                        }
                        break;
                    case 9: //company type dependant: private=mainMenu - Company = company phone
                        if(tempCustomer instanceof PrivateCustomer){
                            System.out.println("Invalid choice for private customer - returning to main menu");
                            return;
                        } else if (tempCustomer instanceof CompanyCustomer){
                            System.out.println("Customer's current company phone: \"" + ((CompanyCustomer) tempCustomer).getCompanyPhone() + "\"");
                            System.out.println("Enter new company phone");
                            int newCompanyPhone = Main.userInput.nextInt();
                            ((CompanyCustomer) tempCustomer).setCompanyPhone(newCompanyPhone);
                            System.out.println("Change accepted, Customer now looks like this:");
                            printCustomerNicely(tempCustomer);
                        }
                        break;
                    case 10: //company type dependant private=mainMenu - company=crn number
                        if(tempCustomer instanceof PrivateCustomer){
                            System.out.println("Invalid choice for private customer - returning to main menu");
                            return;
                        } else if (tempCustomer instanceof CompanyCustomer){
                            System.out.println("Customer's current CRN number: \"" + ((CompanyCustomer) tempCustomer).getCrn() + "\"");
                            System.out.println("Enter new CRN number");
                            int newCrnNumber = Main.userInput.nextInt();
                            ((CompanyCustomer) tempCustomer).setCrn(newCrnNumber);
                            System.out.println("Change accepted, Customer now looks like this:");
                            printCustomerNicely(tempCustomer);
                        }
                        break;
                    case 0: //main menu
                        System.out.println("Returning to main Menu");
                        break;
                    default:
                        System.out.println();
                        System.out.println("Invalid Choice");
                        System.out.println("Try again");
                        editCustomer();
                        break;
                }
        } catch (Exception ignored) {
            Main.userInput.nextLine();
            System.out.println();
            System.out.println("Invalid Input");
            System.out.println("Returning to Main Menu");
        }

    }

    //method for user to edit a Car object through the Console
    private static void editCar() {
        try {
            System.out.println();
            Collections.sort(Main.rentalCars);
            for(Car car : Main.rentalCars){
                System.out.println(car);
                System.out.println();
            }
            System.out.println("Above is printed the list of all cars in case needed");
            if(Main.userInput.hasNextLine()){ //clears scanner if already has input
                Main.userInput.nextLine();
            }
            String licensePlate;
            Car tempCar = null;
            do { //do while car not found
                System.out.println("Enter License Plate of the car you want to edit");
                licensePlate = Main.userInput.nextLine();
                int count = 0;
                for(Car car : Main.rentalCars){
                    if(car.getRegistrationNumber().equalsIgnoreCase(licensePlate.toLowerCase())){
                        tempCar = car;
                        count++;
                    }
                }
                if(count == 0){ //if no car found
                    System.out.println("Sorry no Car with that license plate found");
                    System.out.println();
                    System.out.println("Type 1 to try again");
                    System.out.println("Type 0 to return to Main Menu");
                    int answer = Main.userInput.nextInt();
                    Main.userInput.nextLine();
                    if(answer == 0){
                        System.out.println("Returning to Main Menu");
                        return;
                    }
                }
            } while (tempCar == null); //do while car not found

            System.out.println("Car found with license plate: \"" + licensePlate+"\"");
            System.out.println("  type 1: Edit Brand                          ");
            System.out.println("  type 2: Edit Model                           ");
            System.out.println("  type 3: Edit fuel type                       ");
            System.out.println("  type 4: Edit License plate                   ");
            System.out.println("  type 5: Edit Registration Date     ");
            System.out.println("  type 6: Edit odoMeter                        ");
            System.out.println("  type 7: Change manual/automatic gear         ");
            System.out.println("  type 8: Change availability status           ");
            if(tempCar instanceof FamilyCar){
                System.out.println("  type 9: Edit amount of seats             ");
            } else if(tempCar instanceof LuxuryCar){
                System.out.println("  type 9: Edit CCM number                  ");
            } else if(tempCar instanceof SportCar){
                System.out.println("  type 9: Edit horsepower                  ");
            }
            System.out.println("  type 0: To return to the main menu           ");
            int answer = Main.userInput.nextInt();
            Main.userInput.nextLine();
            switch(answer){ //switch for changing the specific field
                case 1://brand
                    System.out.println("This car's current brand = \""+tempCar.getBrand()+"\"");
                    System.out.println("Enter new brand name");
                    String newBrand = Main.userInput.nextLine();
                    tempCar.setBrand(newBrand);
                    System.out.println("Change accepted, car now looks like this:");
                    printCarNicely(tempCar);
                    break;
                case 2://model
                    System.out.println("This car's current model = \""+tempCar.getModel()+"\"");
                    System.out.println("Enter new model name");
                    String newModel = Main.userInput.nextLine();
                    tempCar.setModel(newModel);
                    System.out.println("Change accepted, car now looks like this:");
                    printCarNicely(tempCar);
                    break;
                case 3://fuel type
                    System.out.println("This car's current fuel type = \""+tempCar.getFuelType()+"\"");
                    System.out.println("Enter new fuel type");
                    String newFuelType = Main.userInput.nextLine();
                    tempCar.setFuelType(newFuelType);
                    System.out.println("Change accepted, car now looks like this:");
                    printCarNicely(tempCar);
                    break;
                case 4://license plate
                    System.out.println("This car's current license plate = \""+tempCar.getRegistrationNumber()+"\"");
                    System.out.println("Enter new license plate");
                    String newLicensePlate = Main.userInput.nextLine();
                    tempCar.setRegistrationNumber(newLicensePlate.toUpperCase());
                    System.out.println("Change accepted, car now looks like this:");
                    printCarNicely(tempCar);
                    break;
                case 5://registration Date
                    System.out.println("This car's current registration date = \""+tempCar.getRegistrationYearMonth()+"\"");
                    System.out.println("Enter new date using format as seen above \"yyyy-MM-dd\"");
                    String newDate = Main.userInput.nextLine();
                    LocalDate newLocalDate = LocalDate.parse(newDate);
                    tempCar.setRegistrationYearMonth(newLocalDate);
                    System.out.println("Change accepted, car now looks like this:");
                    printCarNicely(tempCar);
                    break;
                case 6://odometer
                    System.out.println("This car's current Odometer = \""+tempCar.getOdoMeter()+"\"miles");
                    System.out.println("Enter new odometer number");
                    int newOdometer = Main.userInput.nextInt();
                    tempCar.setOdoMeter(newOdometer);
                    System.out.println("Change accepted, car now looks like this:");
                    printCarNicely(tempCar);
                    break;
                case 7://manual/automatic
                    if(tempCar.isAutomaticGear()){
                        System.out.println("This car is currently set to have automatic gear, changing it to manual");
                        tempCar.setAutomaticGear(false);
                        System.out.println("Change accepted, car now looks like this:");
                        printCarNicely(tempCar);
                    } else {
                        System.out.println("This car is currently set to have manual gear, changing it to automatic");
                        tempCar.setAutomaticGear(true);
                        System.out.println("Change accepted, car now looks like this:");
                        printCarNicely(tempCar);
                    }
                    break;
                case 8: //availability
                    if(tempCar.isAvailable()){
                        System.out.println("This car is currently available, changing it to unavailable");
                        tempCar.setAvailable(false);
                        System.out.println("Change accepted, car now looks like this:");
                        printCarNicely(tempCar);
                    } else {
                        System.out.println("This car is currently unavailable, changing it to available");
                        tempCar.setAvailable(true);
                        System.out.println("Change accepted, car now looks like this:");
                        printCarNicely(tempCar);
                    }
                    break;
                case 9: //car-type-dependant
                    if(tempCar instanceof FamilyCar){ //if FamilyCar
                        System.out.println("This car's current amount of seats = \""+((FamilyCar) tempCar).getSeats()+"\"");
                        System.out.println("Enter new amount of seats");
                        int newSeatNumber = Main.userInput.nextInt();
                        ((FamilyCar) tempCar).setSeats(newSeatNumber);
                        System.out.println("Change accepted, car now looks like this:");
                        printCarNicely(tempCar);
                    } else if(tempCar instanceof LuxuryCar){ //if LuxuryCar
                        System.out.println("This car's current amount of seats = \""+((LuxuryCar) tempCar).getCcm()+"\"");
                        System.out.println("Enter new CCM number");
                        int newCcmNumber = Main.userInput.nextInt();
                        ((LuxuryCar) tempCar).setCcm(newCcmNumber);
                        System.out.println("Change accepted, car now looks like this:");
                        printCarNicely(tempCar);
                    } else if(tempCar instanceof SportCar){ //if SportCar
                        System.out.println("This car's current horse power = \"" + ((SportCar) tempCar).getHorsePower());
                        System.out.println("Enter new horse power's");
                        int newHorsePower = Main.userInput.nextInt();
                        ((SportCar) tempCar).setHorsePower(newHorsePower);
                        System.out.println("Change accepted, car now looks like this:");
                        printCarNicely(tempCar);
                    } else { //if case 9 was chosen for a normal car
                        System.out.println();
                        System.out.println("Invalid Choice");
                        System.out.println("Returning to main Menu");
                        return;
                    }
                    break;
                case 0: //main menu
                    System.out.println("Returning to main Menu");
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid Choice");
                    System.out.println("Returning to main Menu");
            }

        } catch (Exception ignored) {
            Main.userInput.nextLine();
            System.out.println();
            System.out.println("Invalid Input");
            System.out.println("Returning to Main Menu");
        }
    }

    //method for printing car's nicely, saves quite a few lines of redundant code
    private static void printCarNicely(Car tempCar) {
        System.out.println();
        System.out.println(tempCar);
        System.out.println();
    }

    //method for printing Contracts nicely
    private static void printContractNicely(RentalContract rentalContract) {
        System.out.println();
        System.out.println(rentalContract);
        System.out.println();
    }
    //method for printing customers nicely
    private static void printCustomerNicely(Customer customer) {
        System.out.println();
        System.out.println(customer);
        System.out.println();
    }


    ////////////////////////////////////////////////////////////////////////
    //                      Remove object below                           //
    ////////////////////////////////////////////////////////////////////////

    public static void removeCar(){

    }

    public static void removeCustomer(){

    }
}
