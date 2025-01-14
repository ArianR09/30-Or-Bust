
public class Game {

    Player player = new Player();

    String[] players = new String[2]; // Two players allowed
    int[] scores = new int[players.length]; // Scores length, based off # of players

    // Prompts instructions, displays rules of the game.
    public void instructions() {
        player.Users(players);

        System.out.println("30 or BUST");
        System.out.println("Welcome " + players[0] + " and " + players[1]);
        System.out.println("First to 30 points wins!");
        System.out.println("If your score exceeds 30 points, your score will be reset down to 0.");
    }

    // Prompts user scores, and appends them to scores index of players turn. Checks win/0.
    public void userChoice() {

        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i] + " it's your turn.");
            System.out.println("Your score: " + scores[i]);

            scores[i] += player.rollValueChoice();
            System.out.println("Your new score is: " + scores[i]);
            System.out.println("==========================");

            if (scores[i] > 30) {
                scores[i] = 0;
                System.out.println("Your score has been reset to 0");
                System.out.println("==========================");
            } else if (scores[i] == 30) {
                break;
            }
        }
    }

    // Gameplay, checks win.
    public void setGameFunctions() {
        boolean game = true;
        while (game) {

            userChoice();

            for (int i = 0; i < scores.length; i++) {
                if (scores[i] == 30) {
                    System.out.println(players[i] + " wins!");
                    game = false;
                    break;
                }
            }
        }
    }
}
