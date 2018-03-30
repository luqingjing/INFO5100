package ProjectOne;

public class CountingPlayer extends Player {

    int memoryCard;

    CountingPlayer(int bankroll, int minimum){
        super(bankroll, minimum);
        memoryCard = 0;
    }

    @Override
    public int bet() {

        if (bankroll < minimum) {
            throw new RuntimeException();
        }
        if (memoryCard >= 2 && bankroll >= minimum * 2)
            return minimum * 2;
        else
            return minimum;
    }

    @Override
    public void expose(Card c) {

        if (c.getSpot().getValue() == 10 || c.getSpot().getValue() == 1) {
            memoryCard--;
        } else if (c.getSpot().getValue() >= 2 && c.getSpot().getValue() <= 6) {
            memoryCard++;
        }
    }

    @Override
    public void shuffled() {
        memoryCard = 0;
    }
}
