import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player {

    public Human(String name) {
        super(name);
    }
    
    public static int getInput(int limit) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true; // this condition ends the loop
        int input = 0;
        while (loop) {
            try {
                input = sc.nextInt();
                if (input > 0 && input < limit) {
                    loop = false;
                } else {
                    System.out.println("Invalid input try again ");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input try again ");
                sc.nextLine();
            }
        }
        return input;

    }

}
