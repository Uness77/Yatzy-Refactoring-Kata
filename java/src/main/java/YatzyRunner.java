import java.util.Random;
import java.util.Scanner;

public class YatzyRunner {

    private static final Random random = new Random();
    private static Yatzy yatzy = Yatzy.getInstance();

    private static boolean isValidDiceValue(int diceValue) {
        return diceValue >= 1 && diceValue <= 6;
    }

    private static int[] rollDice() {
        int[] rolls = new int[5];
        for (int i = 0; i < rolls.length; i++) {
            rolls[i] = random.nextInt(6) + 1; // Dice values range from 1 to 6
        }
        return rolls;
    }

    public static void main(String[] args) {
        System.out.println("       .-------.    ______    ");
        System.out.println("      /   o   /|   /\\     \\   ");
        System.out.println("     /_______/o|  /o \\  o  \\  ");
        System.out.println("     | o     | | /   o\\_____\\ ");
        System.out.println("     |   o   |o/ \\o   /o    / ");
        System.out.println("     |     o |/   \\ o/  o  /  ");
        System.out.println("     '-------'     \\/____o/   ");
        System.out.println("ascii art from https://www.asciiart.eu/miscellaneous/dice");
        System.out.println("\nWelcome to Yatzy!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to (1) roll a random set of five dice, or (2) input the dice values directly?");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        int[] dice;
        if (choice == 1) {
            dice = rollDice();
            System.out.println("Rolled dice: ");
        } else {
            dice = new int[5];
            System.out.println("Enter the values of five dice (1-6): ");
            for (int i = 0; i < 5; ) {
                var inputValue = scanner.nextInt();
                if (isValidDiceValue(inputValue)) {
                    dice[i] = inputValue;
                    i++;
                } else {
                    System.out.println("Invalid dice value. Please enter a value between 1 and 6.");
                }
            }
            System.out.println("You entered: ");
        }
        for (int diceValue : dice) {
            System.out.print(diceValue + " ");
        }
        int d1 = dice[0];
        int d2 = dice[1];
        int d3 = dice[2];
        int d4 = dice[3];
        int d5 = dice[4];

        System.out.println();

        System.out.println("Scores for your roll:");

        // Chance
        System.out.println("Chance Score : " + yatzy.computeChanceScore(d1, d2, d3, d4, d5));
        // Yatzy
        System.out.println("Yatzy Score : " + yatzy.computeYatzyScore(d1, d2, d3, d4, d5));

        // Ones, Twos, Threes, Fours, Fives, Sixes
        System.out.println("Ones Score : " + yatzy.computeSumOfSpecificDice(1, d1, d2, d3, d4, d5));
        System.out.println("Twos Score : " + yatzy.computeSumOfSpecificDice(2, d1, d2, d3, d4, d5));
        System.out.println("Threes Score : " + yatzy.computeSumOfSpecificDice(3, d1, d2, d3, d4, d5));
        System.out.println("Fours Score : " + yatzy.computeSumOfSpecificDice(4, d1, d2, d3, d4, d5));

        // Pair
        System.out.println("Pair Score : " + yatzy.computeOnePairScore(d1, d2, d3, d4, d5));

        // Two Pairs
        System.out.println("Two Pairs Score : " + yatzy.computeTwoPairsScore(d1, d2, d3, d4, d5));

        // Three of a Kind
        System.out.println("Three of a Kind Score : " + yatzy.computeThreeOfAKindScore(d1, d2, d3, d4, d5));

        // Four of a Kind
        System.out.println("Four of a Kind Score : " + yatzy.computefourOfAKindScore(d1, d2, d3, d4, d5));

        // Small Straight
        System.out.println("Small Straight Score : " + yatzy.computeSmallStraight(d1, d2, d3, d4, d5));

        // Large Straight
        System.out.println("Large Straight Score : " + yatzy.computeLargeStraight(d1, d2, d3, d4, d5));

        // Full House
        System.out.println("Full House Score : " + yatzy.computeFullHouseScore(d1, d2, d3, d4, d5));

        scanner.close();
    }
}
