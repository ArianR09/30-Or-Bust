import java.util.Scanner;
public class Player {
    Scanner scanner = new Scanner(System.in);

    // Gets user input of usernames
    public void Users(String[] players) {
        int num = 1;

        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + num + ": ");
            players[i] = scanner.next();
            num++;
        }
    }

    // Rolls dice twice, gets total, gets user input and returns count.
    public int rollValueChoice() {

        Dice dice = new Dice(); // Created an object to use the getRoll() method.
        int[] values = new int[3]; // Hold values of integer values after every roll, (0, roll 1) (1, roll 2) (2, Total)

        int count = 0;
        int num = 1;

        for (int i = 0; i < values.length; i++) { // Generates values of dice
            if (i != 2) {
                values[i] = dice.roll();
                System.out.println("Die " + num + ": " + values[i]);
                num++;
            } else {
                values[2] = values[0] + values[1];
                System.out.println("Total: " + values[2]);

                label:
                do {
                    System.out.print("(1) Keep Die 1, (2) Keep Die 2, (3) Keep total: ");
                    String userInput = scanner.next();

                    switch (userInput) {
                        case "1":
                            count += values[0];
                            break label;
                        case "2":
                            count += values[1];
                            break label;
                        case "3":
                            count += values[2];
                            break label;
                        default:
                            System.out.println("Not valid input, please try again.");
                            break;
                    }
                } while (true);
            }
        }
        return count;
    }
}