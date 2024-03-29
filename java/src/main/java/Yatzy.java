public interface Yatzy {
    static Yatzy getInstance() {
        return YatzyImpl.instance;
    }

    /**
     * The player scores the sum of all dice, no matter what they read. For example:
     * 1,1,3,3,6 placed on “chance” scores 14 (1+1+3+3+6)
     * 4,5,5,6,1 placed on “chance” scores 21 (4+5+5+6+1)
     * @param * @param d1 value of dice1, d2 value of dice2, d3 value of dice3,
     * d4 value of dice4, and d5 value of dice5.
     * the individual values of a dices, ranging from 1 to 6.
     * @return The total score for "Chance", which is the sum of the values of the five dice.
     */
    int computeChanceScore(int d1, int d2, int d3, int d4, int d5);

    /**
     * If all dice have the same number, the player scores 50 points. For example:
     * 1,1,1,1,1 placed on “yatzy” scores 50
     * 1,1,1,2,1 placed on “yatzy” scores 0
     * @param * @param d1 value of dice1, d2 value of dice2, d3 value of dice3,
     * d4 value of dice4, and d5 value of dice5.
     * the individual values of a dices, ranging from 1 to 6.
     * @return Yatzy score 50 points if all dice have the same number otherwise the score is 0
     */
    int computeYatzyScore(int d1, int d2, int d3, int d4, int d5);

    /**
     * The player scores the sum of the dice that reads one, two, three, four, five or six, respectively. For example:
     * 1,1,2,4,4 placed on “fours” scores 8 (4+4)
     * 2,3,2,5,1 placed on “twos” scores 4 (2+2)
     * 3,3,3,4,5 placed on “ones” scores 0
     * @param * @param d1 value of dice1, d2 value of dice2, d3 value of dice3,
     * d4 value of dice4, and d5 value of dice5.
     * the individual values of a dices, ranging from 1 to 6.
     * @return score of the sum of the dice that reads one, two, three, four, five or six, respectively otherwise the score is 0
     */
    int computeSumOfSpecificDice(int diceValue, int d1, int d2, int d3, int d4, int d5);

    /**
     * The player scores the sum of the two highest matching dice. For example, when placed on “pair”:
     * 1,2,3,4,5 scores 0
     * 3,3,3,4,4 scores 8 (4+4)
     * 1,1,6,2,6 scores 12 (6+6)
     * 3,3,3,4,1 scores 6 (3+3)
     * 3,3,3,3,1 scores 6 (3+3)
     * @param * @param d1 value of dice1, d2 value of dice2, d3 value of dice3,
     * d4 value of dice4, and d5 value of dice5.
     * the individual values of a dices, ranging from 1 to 6.
     * @return the sum of the two highest matching dice. otherwise the score is 0
     */
    int computeOnePairScore(int d1, int d2, int d3, int d4, int d5);


    /**
     * If there are two pairs of dice with the same number, the player scores the sum of these dice. For example, when placed on “two pairs”:
     * 1,1,2,3,3 scores 8 (1+1+3+3)
     * 1,1,2,3,4 scores 0
     * 1,1,2,2,2 scores 6 (1+1+2+2)
     * 3,3,3,3,1 scores 0
     * @param * @param d1 value of dice1, d2 value of dice2, d3 value of dice3,
     * d4 value of dice4, and d5 value of dice5.
     * the individual values of a dices, ranging from 1 to 6.
     * @return the sum of the dices forming two pairs otherwise the score is 0.
     */
    int computeTwoPairsScore(int d1, int d2, int d3, int d4, int d5);

    /**
     * If there are three dice with the same number, the player scores the sum of these dice. For example, when placed on “three of a kind”:
     3,3,3,4,5 scores 9 (3+3+3)
     3,3,4,5,6 scores 0
     3,3,3,3,1 scores 9 (3+3+3)
     * @param * @param d1 value of dice1, d2 value of dice2, d3 value of dice3,
     * d4 value of dice4, and d5 value of dice5.
     * the individual values of a dices, ranging from 1 to 6.
     * @return the sum of the dices forming three pairs otherwise the score is 0.
     */
    int computeThreeOfAKindScore(int d1, int d2, int d3, int d4, int d5);

    /**
     * If there are four dice with the same number, the player scores the sum of these dice. For example, when placed on “four of a kind”:
     * 2,2,2,2,5 scores 8 (2+2+2+2)
     * 2,2,2,5,5 scores 0
     * 2,2,2,2,2 scores 8 (2+2+2+2)
     * @param * @param d1 value of dice1, d2 value of dice2, d3 value of dice3,
     * d4 value of dice4, and d5 value of dice5.
     * the individual values of a dices, ranging from 1 to 6.
     * @return the sum of the dices forming four pairs otherwise the score is 0.
     */
    int computefourOfAKindScore(int d1, int d2, int d3, int d4, int d5);


    /**
     * When placed on “small straight”, if the dice read
     * 1,2,3,4,5,
     * the player scores 15 (the sum of all the dice).
     * @param * @param d1 value of dice1, d2 value of dice2, d3 value of dice3,
     * d4 value of dice4, and d5 value of dice5.
     * the individual values of a dices, ranging from 1 to 6.
     * @return 15 when we have a small Straight (sum of dices) otherwise the score is 0.
     */
    int computeSmallStraight(int d1, int d2, int d3, int d4, int d5);

    /**
     * When placed on “large straight”, if the dice read
     * 2,3,4,5,6,
     * the player scores 20 (the sum of all the dice).
     * @param * @param d1 value of dice1, d2 value of dice2, d3 value of dice3,
     * d4 value of dice4, and d5 value of dice5.
     * the individual values of a dices, ranging from 1 to 6.
     * @return 20 when we have a small Straight (sum of dices) otherwise the score is 0.
     */
    int computeLargeStraight(int d1, int d2, int d3, int d4, int d5);

    /**
     * If the dice are two of a kind and three of a kind, the player scores the sum of all the dice. For example, when placed on “full house”:
     * 1,1,2,2,2 scores 8 (1+1+2+2+2)
     * 2,2,3,3,4 scores 0
     * 4,4,4,4,4 scores 0
     * @param * @param d1 value of dice1, d2 value of dice2, d3 value of dice3,
     * d4 value of dice4, and d5 value of dice5.
     * the individual values of a dices, ranging from 1 to 6.
     * @return The total score =  sum of all the dice on fullhouse otherwise the score is 0.
     */
    int computeFullHouseScore(int d1, int d2, int d3, int d4, int d5);
}
