import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player {

    public Human(String name) {
        super(name);
    }

    @Override
    public Card playCard() {
        System.out.println("Your hand: ");
        for (int i = 0; i < Hand.size(); i++) {
            System.out.println((i + 1) + ": " + Hand.get(i).toString());
        }
        System.out.println("Choose a card to play (enter the number): ");
        int choice = getInput(Hand.size() + 1) - 1;
        Card chosenCard = Hand.get(choice);
        Hand.remove(choice);
        return chosenCard;
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
