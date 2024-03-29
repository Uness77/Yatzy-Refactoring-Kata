import java.util.Arrays;
import java.util.stream.IntStream;

public class YatzyImpl implements Yatzy {
    public static final int[] SMALL_STRAIGHT_OCCURENCES = new int[]{1, 1, 1, 1, 1, 0};
    public static final int[] LARGE_STRAIGHT_OCCURENCES = new int[]{0, 1, 1, 1, 1, 1};

    protected static YatzyImpl instance = new YatzyImpl();

    private YatzyImpl() {
    }

    @Override
    public int computeChanceScore(int d1, int d2, int d3, int d4, int d5) {
        return IntStream.of(d1, d2, d3, d4, d5).sum();
    }

    @Override
    public int computeYatzyScore(int d1, int d2, int d3, int d4, int d5) {
        return IntStream.of(d2, d3, d4, d5).allMatch(die -> die == d1) ? 50 : 0;
    }

    @Override
    public int computeSumOfSpecificDice(int diceValue, int d1, int d2, int d3, int d4, int d5) {
        return IntStream.of(d1, d2, d3, d4, d5).filter(i -> i == diceValue).sum();
    }

    @Override
    public int computeOnePairScore(int d1, int d2, int d3, int d4, int d5) {
        return computeScoreForNumberOfOccurences(2, d1, d2, d3, d4, d5);
    }

    @Override
    public int computeTwoPairsScore(int d1, int d2, int d3, int d4, int d5) {
        int[] diceOccurences = countDiceOccurences(d1, d2, d3, d4, d5);
        int score = 0;
        int numberOfPairs = 0;
        for (int i = 5; i > 0; i--) {
            if (diceOccurences[i] >= 2) {
                score += (i + 1) * 2;
                numberOfPairs++;
            }
        }
        return (numberOfPairs == 2) ? score : 0;
    }

    @Override
    public int computeThreeOfAKindScore(int d1, int d2, int d3, int d4, int d5) {
        return computeScoreForNumberOfOccurences(3, d1, d2, d3, d4, d5);
    }


    @Override
    public int computefourOfAKindScore(int d1, int d2, int d3, int d4, int d5) {
        return computeScoreForNumberOfOccurences(4, d1, d2, d3, d4, d5);
    }

    private int computeScoreForNumberOfOccurences(int numberOfOccurences, int... dice) {
        int[] counts = countDiceOccurences(dice);
        for (int i = 5; i > 0; i--) {
            if (counts[i] >= numberOfOccurences) {
                return (i + 1) * numberOfOccurences;
            }
        }
        return 0;
    }

    private int[] countDiceOccurences(int... dice) {
        int[] counts = new int[6];
        Arrays.stream(dice).forEach(die -> counts[die - 1]++);
        return counts;
    }

    @Override
    public int computeSmallStraight(int d1, int d2, int d3, int d4, int d5) {
        final int[] diceOccurences = countDiceOccurences(d1,  d2,  d3,  d4, d5);
        return (Arrays.equals(diceOccurences, SMALL_STRAIGHT_OCCURENCES))? 15 : 0;
    }


    @Override
    public int computeLargeStraight(int d1, int d2, int d3, int d4, int d5) {
        final int[] diceOccurences = countDiceOccurences(d1,  d2,  d3,  d4, d5);
        return (Arrays.equals(diceOccurences, LARGE_STRAIGHT_OCCURENCES))? 20 : 0;
    }

    @Override
    public int computeFullHouseScore(int d1, int d2, int d3, int d4, int d5) {
        final int[] diceOccurences = countDiceOccurences(d1, d2, d3, d4, d5);
        boolean contains2 = false;
        boolean contains3 = false;
        int score = 0;
        for (int i = 0; i <=5; i++) {
            if (diceOccurences[i] == 2 ) {
                contains2 = true;
                score += (i + 1) * diceOccurences[i];
            }

            if (diceOccurences[i] == 3) {
                contains3 = true;
                score += (i + 1) * diceOccurences[i];
            }
        }
        return (contains2 && contains3)? score : 0;
    }
}