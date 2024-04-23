import CustomerClasses.*;
import java.time.LocalDate;

public class Main {

//    public static ArrayList<RentalContracts> rentalContracts = ... FileHandler.getRentalcontract();
//    public static ArrayList<Car> rentalCars = FileHandler.getRentalCars();

    public static void main(String[] args){

        PrivateCustomer test1 = new PrivateCustomer("Bobby Bobsen","Bobsalley 12", 2500,
                "Honolulu", 25503425, "bobbyBobsen123@hotmail.com",123456789,LocalDate.now());
        test1.setEmail("Bobby321@hotmail.com");
        System.out.println(test1.getEmail());

    }

}
