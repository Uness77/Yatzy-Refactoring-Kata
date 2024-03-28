public interface Yatzy {
    static Yatzy getInstance() {
        return YatzyImpl.instance;
    }

    int chance(int d1, int d2, int d3, int d4, int d5);

    int yatzy(int d1, int d2, int d3, int d4, int d5);

    int sumOfSpecificDice(int diceValue, int d1, int d2, int d3, int d4, int d5);

    int onePair(int d1, int d2, int d3, int d4, int d5);

    int threeOfAKind(int d1, int d2, int d3, int d4, int d5);

    int fourOfAKind(int d1, int d2, int d3, int d4, int d5);

    int twoPair(int d1, int d2, int d3, int d4, int d5);

    int smallStraight(int d1, int d2, int d3, int d4, int d5);

    int largeStraight(int d1, int d2, int d3, int d4, int d5);

    int fullHouse(int d1, int d2, int d3, int d4, int d5);
}
