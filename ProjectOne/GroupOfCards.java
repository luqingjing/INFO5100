package ProjectOne;

import java.util.ArrayList;
import java.util.List;

public class GroupOfCards {

    private List<Card> cards = new ArrayList<Card>();
    private List<Card> temp;

    GroupOfCards(){}

    void addCard(Card c) {
        cards.add(c);
    }
    // EFFECTS: adds the card "c" to those presently held.

    void discardAll() {
        cards.clear();
    }
    // EFFECTS: discards any cards presently held , restoring the state
    // of the cards to empty.

    int getCurrentSize() {
        return cards.size();
    }
    // EFFECTS: return the length of cards;

    void display() {
        for (Card c : cards) {
            System.out.println(c.toString());
        }
    }
    //EFFECTS: display every card in cards;

    Card deleteCard() {
        if (cards.size() == 0) {
            System.out.println("No card!");
            return null;
        }
        Card c = cards.get(0);
        cards.remove(0);
        return c;
    }
    // EFFECTS: delete the top card from the group of cards and return the
    // deleted card value;

    Card getCard(int i) {
        return cards.get(i);
    }

    Card removeCardByIndex(int index) {

        if (cards.size() == 0) {
            System.out.println("No card!");
            return null;
        }

        if (index >= cards.size() || index < 0) {
            System.out.println("Index wrong!");
            return null;
        }

        Card c = cards.get(index);
        cards.remove(index);
        return c;
    }

    List<Card> copyDeck() {
        temp = new ArrayList<>(cards);
        return temp;
    }

    List<Card> pasteDeck() {
        cards = new ArrayList<>(temp);
        return cards;
    }
}
