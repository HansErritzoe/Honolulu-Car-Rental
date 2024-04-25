import CarClasses.*;

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
