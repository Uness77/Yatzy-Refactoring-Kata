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
        int actual = yatzy.chance(2, 3, 4, 5, 1);
        assertEquals(expected, actual);
        assertEquals(16, yatzy.chance(3, 3, 4, 5, 1));
    }

    @Test
    public void  should_ComputeYatzyScore_When_CombinationsOfDiceProvided() {
        int expected = 50;
        int actual = yatzy.yatzy(4, 4, 4, 4, 4);
        assertEquals(expected, actual);
        assertEquals(50, yatzy.yatzy(6, 6, 6, 6, 6));
        assertEquals(0, yatzy.yatzy(6, 6, 6, 6, 3));
    }

    @Test
    public void should_ReturnCorrectSumOfDiceValue_When_DifferentCombinationsOfDiceProvided() {
        // The player scores the sum of the dice that reads one
        assertTrue(yatzy.sumOfSpecificDice(1, 1, 2, 3, 4, 5) == 1);
        assertEquals(2, yatzy.sumOfSpecificDice(1, 1, 2, 1, 4, 5));
        assertEquals(0, yatzy.sumOfSpecificDice(1, 6, 2, 2, 4, 5));
        assertEquals(4, yatzy.sumOfSpecificDice(1, 1, 2, 1, 1, 1));
        // The player scores the sum of the dice that reads two
        assertEquals(4, yatzy.sumOfSpecificDice(2, 1, 2, 3, 2, 6));
        assertEquals(10, yatzy.sumOfSpecificDice(2, 2, 2, 2, 2, 2));
        // The player scores the sum of the dice that reads three
        assertEquals(6, yatzy.sumOfSpecificDice(3, 1, 2, 3, 2, 3));
        assertEquals(12, yatzy.sumOfSpecificDice(3, 2, 3, 3, 3, 3));
        // The player scores the sum of the dice that reads four
        assertEquals(12, yatzy.sumOfSpecificDice(4, 4, 4, 4, 5, 5));
        assertEquals(8, yatzy.sumOfSpecificDice(4, 4, 4, 5, 5, 5));
        assertEquals(4, yatzy.sumOfSpecificDice(4, 4, 5, 5, 5, 5));
        // The player scores the sum of the dice that reads five
        assertEquals(10, yatzy.sumOfSpecificDice(5, 4, 4, 4, 5, 5));
        assertEquals(15, yatzy.sumOfSpecificDice(5, 4, 4, 5, 5, 5));
        assertEquals(20, yatzy.sumOfSpecificDice(5, 4, 5, 5, 5, 5));
        // The player scores the sum of the dice that reads six
        assertEquals(0, yatzy.sumOfSpecificDice(6, 4, 4, 4, 5, 5));
        assertEquals(6, yatzy.sumOfSpecificDice(6, 4, 4, 6, 5, 5));
        assertEquals(18, yatzy.sumOfSpecificDice(6, 6, 5, 6, 6, 5));
    }

    @Test
    public void should_ReturnCorrectScore_When_ResultOfOnePairOfDices() {
        assertEquals(6, yatzy.onePair(3, 4, 3, 5, 6));
        assertEquals(10, yatzy.onePair(5, 3, 3, 3, 5));
        assertEquals(12, yatzy.onePair(5, 3, 6, 6, 5));
    }

    @Test
    public void should_ReturnCorrectScore_When_ResultOfTwoPairOfDices() {
        assertEquals(16, yatzy.twoPair(3, 3, 5, 4, 5));
        assertEquals(16, yatzy.twoPair(3, 3, 5, 5, 5));
    }

    @Test
    public void should_ReturnCorrectScore_When_ResultOfThreePairOfDices() {
        assertEquals(9, yatzy.threeOfAKind(3, 3, 3, 4, 5));
        assertEquals(15, yatzy.threeOfAKind(5, 3, 5, 4, 5));
        assertEquals(9, yatzy.threeOfAKind(3, 3, 3, 3, 5));
    }

    @Test
    public void should_ReturnCorrectScore_When_ResultOfFourPairOfDices() {
        assertEquals(12, yatzy.fourOfAKind(3, 3, 3, 3, 5));
        assertEquals(20, yatzy.fourOfAKind(5, 5, 5, 4, 5));
        assertEquals(12, yatzy.fourOfAKind(3, 3, 3, 3, 3));
    }

    @Test
    public void should_ComputeSmallStraightScore_When_CombinationsOfDiceProvided() {
        assertEquals(15, yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, yatzy.smallStraight(2, 3, 4, 5, 1));
        assertEquals(0, yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void should_ComputeLargeStraightScore_When_CombinationsOfDiceProvided() {
        assertEquals(20, yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void should_ComputeFullHouseScore_When_CombinationsOfDiceProvided() {
        assertEquals(18, yatzy.fullHouse(6, 2, 2, 2, 6));
        assertEquals(0, yatzy.fullHouse(2, 3, 4, 5, 6));
    }
}
