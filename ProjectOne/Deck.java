package ProjectOne;


class DeckEmptyExecption extends Exception { // An exception type

    @Override
    public String toString() {
        return "The deck is empty!";
    }
}


public class Deck extends GroupOfCards {

    final int DeckSize = 52;
    // A standard Deck of 52 playing card---no jokers


    Deck() {
        super();
        reset();
    }

    // EFFECTS: constructs a "newly opened" Deck of card.  first the
    // spades from 2-A, then the hearts, then the clubs, then the
    // diamonds.  The first Card dealt should be the 2 of Spades.

    void reset() {

        discardAll();
        for (Suit suit : Suit.values()) {

            for (Spot spot : Spot.values()) {

                this.addCard(new Card(spot, suit));
            }
        }
    }

    // EFFECTS: resets the Deck to the state of a "newly opened" Deck
    // of card:

    void shuffleOnce(int n) {

        if (this.getCurrentSize() < 52) {
            this.pasteDeck();
        }

        if (n < 0 || n > DeckSize)
            return;

        int remain = Math.abs(DeckSize - n * 2);

        if (n <= DeckSize / 2) {

            for (int i = n; i > 0; i--) {

                addCard(removeCardByIndex(i));
                addCard(deleteCard());
            }

        } else {

            for (int i = n; i > remain; i--) {

                addCard(removeCardByIndex(i));
                addCard(deleteCard());
            }
        }

        for (int i = remain; i > 0; i--) {

            addCard(deleteCard());
        }

        copyDeck();
    }


    // REQUIRES: n is between 0 and 52, inclusive.

    // EFFECTS: cut the Deck into two segments: the first n card,
    // called the "left", and the rest called the "right".  Note that
    // either right or left might be empty.  Then, rearrange the Deck
    // to be the first Card of the right, then the first Card of the
    // left, the 2nd of right, the 2nd of left, and so on.  Once one
    // side is exhausted, fill in the remainder of the Deck with the
    // card remaining in the other side.  Finally, make the first
    // Card in this shuffled Deck the next Card to deal.  For example,
    // shuffle(26) on a newly-reset() Deck results in: 2-clubs,
    // 2-spades, 3-clubs, 3-spades ... A-diamonds, A-hearts.

    // Note: if shuffle is called on a Deck that has already had some
    // card dealt, those card should first be restored to the Deck
    // in the order in which they were dealt, preserving the most
    // recent post-shuffled/post-reset state.

    void shuffle(int times) {

        System.out.println("Shuffling the deck");
        int i = 0;
        while (i < times) {
            int r = (int)(13 + Math.random() * (39 - 13 + 1));
            System.out.println("cut at " + r);
            shuffleOnce(r);
            i++;
        }
    }
    // REQUIRES: times is the time of using shuffleOnce method to shuffle
    // cards, normally time should be at least 5.

    //EFFECTS: In each time, use Math.random to pick an cut number between
    // 13 - 39, and then call shuffleOnce method with the number;

    Card deal() throws DeckEmptyExecption {

        if (getCurrentSize() == 0) {
            reset();
            throw new DeckEmptyExecption();
        } else {
            return this.deleteCard();
        }
    }

    // EFFECTS: returns the next Card to be dealt.  If no card
    // remain, throws an instance of DeckEmptyException and then
    // reset the deck

    int cardsLeft(){
        return this.getCurrentSize();
    }
    // EFFECTS: returns the number of card in the Deck that have not
    // been dealt since the last reset/shuffle.

}
