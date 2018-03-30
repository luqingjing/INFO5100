package ProjectOne;

public class Dealer {

    Hand hand;

    Dealer(){
        this.hand = new Hand();
    }

    public boolean draw(){

        return hand.getHandValue().count < 17;
    }
    // EFFECTS: For dealer The dealer must
    // hit until he either reaches a total greater than or equal to 17
    // (hard or soft), or busts.
}
