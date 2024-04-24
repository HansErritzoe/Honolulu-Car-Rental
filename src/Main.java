import CustomerClasses.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

//    public static ArrayList<RentalContracts> rentalContracts = ... FileHandler.getRentalcontract();
//    public static ArrayList<Car> rentalCars = FileHandler.getRentalCars();
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){

        PrivateCustomer test1 = new PrivateCustomer("Bobby Bobsen","Bobsalley 12", 2500,
                "Honolulu", 25503425, "bobbyBobsen123@hotmail.com",123456789,LocalDate.now());
        test1.setEmail("Bobby321@hotmail.com");
        System.out.println(test1.getEmail());
        menu();
    }
    public static void menu(){
        try {
            int answer;
            do {
                answer = scan.nextInt();
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