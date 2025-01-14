import java.util.Random;
public class Dice {

    private int sides;

    public Dice() { // Holds original dice sides.
        this.sides = 6;
    }
    public Dice(int sides) { // If user chooses to change origin/bounds.
        this.sides = sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }
    public int getSides() {
        return sides;
    }

    // Gets random integer between origin/bound.
    public int roll() {
        Random rand = new Random();

        setSides(6);
        return rand.nextInt(getSides()) + 1;
    }
}