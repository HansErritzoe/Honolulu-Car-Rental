import java.util.InputMismatchException;

public class UI {
    public static void mainMenu(){
        try {
            int answer;
            do {
                System.out.println("Du er i menuen");
                answer = Main.userInput.nextInt();
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
            Main.userInput.nextLine();//clearer scanneren
            mainMenu();
        }
    }
}
