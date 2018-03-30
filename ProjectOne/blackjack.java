package ProjectOne;


import java.util.Scanner;

public class blackjack {

    public static void main(String[] args) throws DeckEmptyExecption {

        // write your code here first you need to use system in to ask four parameter from
        // console. Then run the game and print the relevant game step.

        Dealer dealer = new Dealer();
        Player player;
        Deck deck = new Deck();

        Scanner s = new Scanner(System.in);
        System.out.println("Please enter: <bankroll> <tricks> <minimum-wager> [simple|counting]");
        String input = s.nextLine();
        String[] split = input.split(" ");

        int bankroll = Integer.parseInt(split[0]);
        int tricks = Integer.parseInt(split[1]);
        int minimum = Integer.parseInt(split[2]);
        if (split[3].equals("simple")) {
            player = new SimplePlayer(bankroll, minimum);
        } else if (split[3].equals("counting")){
            player = new CountingPlayer(bankroll, minimum);
        } else {
            System.out.println("No such players!");
            return;
        }
        deck.shuffle(7);

        int trickCount = 0;
        while (player.bankroll >= player.minimum && trickCount < tricks) {

            trickCount++;
            System.out.println("Trick " + trickCount + " bankroll " + player.bankroll);
            if (deck.cardsLeft() < 20) {
                player.shuffled();
                deck.shuffle(7);
            }
            Trick trick = new Trick(player, dealer, deck);
            trick.play();
            System.out.println();
        }
        System.out.println("Player has " + player.bankroll + " after " + trickCount + " tricks");
    }
}
