import CarClasses.*;
import CustomerClasses.Customer;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    //method for saving ArrayList<Car> to file
    public static void writeCarsToFile(ArrayList<Car> carList){
        try  {
            ObjectOutputStream outPutStream = new ObjectOutputStream(new FileOutputStream("src/Files/rentalCars.ser",false));
            outPutStream.writeObject(carList);
            System.out.println("Cars saved to rentalCars.ser"); //slettes når vi sikrer på virker
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method for loading Cars from Files/rentalCars.ser into an ArrayList<Car>
    public static ArrayList<Car> readCarsFromFile(){
        if ((!fileIsEmpty("src/Files/rentalCars.ser"))) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/Files/rentalCars.ser"));
                ArrayList<Car> loadedCars = (ArrayList<Car>) objectInputStream.readObject();
                System.out.println("Cars loaded from rentalCars.ser:"); //slettes når vi er sikrer på virker
                return loadedCars;
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
                System.out.println("Couldn't load car file"); //slettes bare når vi er sikre på virker
                return null;
            }
        } else {
            System.out.println("src/Files/rentalCars.ser is empty");
            return new ArrayList<Car>();
        }
    }

    //writes ArrayList of Customer objects to file
    public static void writeCustomersToFile(ArrayList<Customer> customerList){
        try  {
            ObjectOutputStream outPutStream = new ObjectOutputStream(new FileOutputStream("src/Files/customerList.ser",false));
            outPutStream.writeObject(customerList);
            System.out.println("Customer's saved to customerList.ser"); //slettes når vi sikrer på virker
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //loads ArrayList of Customers from file
    public static ArrayList<Customer> readCustomersFromFile(){
        if ((!fileIsEmpty("src/Files/customerList.ser"))) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/Files/customerList.ser"));
                ArrayList<Customer> loadedcustomers = (ArrayList<Customer>) objectInputStream.readObject();
                System.out.println("customerList loaded from customerList.ser:"); //slettes når vi er sikrer på virker
                return loadedcustomers;
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
                System.out.println("Couldn't load customerList file"); //slettes bare når vi er sikre på virker
                return null;
            }
        } else {
            System.out.println("src/Files/customerList.ser is empty");
            return new ArrayList<Customer>();
        }
    }
    //writes RentalContract ArrayList to file
    public static void writeRentalContractsToFile(ArrayList<RentalContract> rentalContractsList){
        try  {
            ObjectOutputStream outPutStream = new ObjectOutputStream(new FileOutputStream("src/Files/rentalContract.ser",false));
            outPutStream.writeObject(rentalContractsList);
            System.out.println("RentalContracts saved to rentalContract.ser"); //slettes når vi sikrer på virker
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //loads ArrayList of RentalContracts from File
    public static ArrayList<RentalContract> readRentalContractsFromFile(){
        if ((!fileIsEmpty("src/Files/rentalContract.ser"))) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/Files/rentalContract.ser"));
                ArrayList<RentalContract> rentalContracts = (ArrayList<RentalContract>) objectInputStream.readObject();
                System.out.println("rentalContracts loaded from rentalContract.ser:"); //slettes når vi er sikrer på virker
                return rentalContracts;
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
                System.out.println("Couldn't load rentalContract file"); //slettes bare når vi er sikre på virker
                return null;
            }
        } else {
            System.out.println("src/Files/rentalContract.ser is empty");
            return new ArrayList<RentalContract>();
        }
    }


    //method for checking if Files are empty before attempting to reading from them
    public static Boolean fileIsEmpty(String filepath){
        try {
            File file = new File(filepath);
            if(file.length() != 0){
                return false;
            } else {
                return true;
            }
        } catch (NullPointerException error) {
            error.printStackTrace();
            System.out.println("Couldn't locate file: " + filepath);
            return true;
        }
    }

}
