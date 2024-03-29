import org.junit.*;

import static org.junit.Assert.*;

public class YatzyTest {

    private static Yatzy yatzy;

    @Before
    public void init() {
        yatzy = Yatzy.getInstance();
    }

    @Test
    public void should_ComputeChanceScore_When_CombinationsOfDiceProvided() {
        int expected = 15;
        int actual = yatzy.computeChanceScore(2, 3, 4, 5, 1);
        assertEquals(expected, actual);
        assertEquals(16, yatzy.computeChanceScore(3, 3, 4, 5, 1));
    }

    @Test
    public void  should_ComputeYatzyScore_When_CombinationsOfDiceProvided() {
        int expected = 50;
        int actual = yatzy.computeYatzyScore(4, 4, 4, 4, 4);
        assertEquals(expected, actual);
        assertEquals(50, yatzy.computeYatzyScore(6, 6, 6, 6, 6));
        assertEquals(0, yatzy.computeYatzyScore(6, 6, 6, 6, 3));
    }

    @Test
    public void should_ReturnCorrectSumOfDiceValue_When_DifferentCombinationsOfDiceProvided() {
        // The player scores the sum of the dice that reads one
        assertTrue(yatzy.computeSumOfSpecificDice(1, 1, 2, 3, 4, 5) == 1);
        assertEquals(2, yatzy.computeSumOfSpecificDice(1, 1, 2, 1, 4, 5));
        assertEquals(0, yatzy.computeSumOfSpecificDice(1, 6, 2, 2, 4, 5));
        assertEquals(4, yatzy.computeSumOfSpecificDice(1, 1, 2, 1, 1, 1));
        // The player scores the sum of the dice that reads two
        assertEquals(4, yatzy.computeSumOfSpecificDice(2, 1, 2, 3, 2, 6));
        assertEquals(10, yatzy.computeSumOfSpecificDice(2, 2, 2, 2, 2, 2));
        // The player scores the sum of the dice that reads three
        assertEquals(6, yatzy.computeSumOfSpecificDice(3, 1, 2, 3, 2, 3));
        assertEquals(12, yatzy.computeSumOfSpecificDice(3, 2, 3, 3, 3, 3));
        // The player scores the sum of the dice that reads four
        assertEquals(12, yatzy.computeSumOfSpecificDice(4, 4, 4, 4, 5, 5));
        assertEquals(8, yatzy.computeSumOfSpecificDice(4, 4, 4, 5, 5, 5));
        assertEquals(4, yatzy.computeSumOfSpecificDice(4, 4, 5, 5, 5, 5));
        // The player scores the sum of the dice that reads five
        assertEquals(10, yatzy.computeSumOfSpecificDice(5, 4, 4, 4, 5, 5));
        assertEquals(15, yatzy.computeSumOfSpecificDice(5, 4, 4, 5, 5, 5));
        assertEquals(20, yatzy.computeSumOfSpecificDice(5, 4, 5, 5, 5, 5));
        // The player scores the sum of the dice that reads six
        assertEquals(0, yatzy.computeSumOfSpecificDice(6, 4, 4, 4, 5, 5));
        assertEquals(6, yatzy.computeSumOfSpecificDice(6, 4, 4, 6, 5, 5));
        assertEquals(18, yatzy.computeSumOfSpecificDice(6, 6, 5, 6, 6, 5));
    }

    @Test
    public void should_ReturnCorrectScore_When_ResultOfOnePairOfDices() {
        assertEquals(6, yatzy.computeOnePairScore(3, 4, 3, 5, 6));
        assertEquals(10, yatzy.computeOnePairScore(5, 3, 3, 3, 5));
        assertEquals(12, yatzy.computeOnePairScore(5, 3, 6, 6, 5));
    }

    @Test
    public void should_ReturnCorrectScore_When_ResultOfTwoPairOfDices() {
        assertEquals(16, yatzy.computeTwoPairsScore(3, 3, 5, 4, 5));
        assertEquals(16, yatzy.computeTwoPairsScore(3, 3, 5, 5, 5));
    }

    @Test
    public void should_ReturnCorrectScore_When_ResultOfThreePairOfDices() {
        assertEquals(9, yatzy.computeThreeOfAKindScore(3, 3, 3, 4, 5));
        assertEquals(15, yatzy.computeThreeOfAKindScore(5, 3, 5, 4, 5));
        assertEquals(9, yatzy.computeThreeOfAKindScore(3, 3, 3, 3, 5));
    }

    @Test
    public void should_ReturnCorrectScore_When_ResultOfFourPairOfDices() {
        assertEquals(12, yatzy.computefourOfAKindScore(3, 3, 3, 3, 5));
        assertEquals(20, yatzy.computefourOfAKindScore(5, 5, 5, 4, 5));
        assertEquals(12, yatzy.computefourOfAKindScore(3, 3, 3, 3, 3));
    }

    @Test
    public void should_ComputeSmallStraightScore_When_CombinationsOfDiceProvided() {
        assertEquals(15, yatzy.computeSmallStraight(1, 2, 3, 4, 5));
        assertEquals(15, yatzy.computeSmallStraight(2, 3, 4, 5, 1));
        assertEquals(0, yatzy.computeSmallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void should_ComputeLargeStraightScore_When_CombinationsOfDiceProvided() {
        assertEquals(20, yatzy.computeLargeStraight(6, 2, 3, 4, 5));
        assertEquals(20, yatzy.computeLargeStraight(2, 3, 4, 5, 6));
        assertEquals(0, yatzy.computeLargeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void should_ComputeFullHouseScore_When_CombinationsOfDiceProvided() {
        assertEquals(18, yatzy.computeFullHouseScore(6, 2, 2, 2, 6));
        assertEquals(0, yatzy.computeFullHouseScore(2, 3, 4, 5, 6));
    }
}
