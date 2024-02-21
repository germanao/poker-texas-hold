package org.acme.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    private static final String[] SUITS = {"S", "H", "G", "B"};
    private static final String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private static final String[] DECK;

    static {
        DECK = new String[SUITS.length * RANKS.length];
        int index = 0;
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                DECK[index++] = rank + suit;
            }
        }
    }

    public static List<String> shuffle() {
        for (int i = DECK.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            String temp = DECK[i];
            DECK[i] = DECK[j];
            DECK[j] = temp;
        }
        return new LinkedList<String>(Arrays.asList(DECK));
    }

    public List<String> currentDeck;

    public void discardCard(){
        currentDeck.remove(0);
    }

    public String drawCard(){
        return currentDeck.remove(0);
    }

    public void flop(List<String> board){
        discardCard();
        discardCard();
        discardCard();

        board.add(drawCard());
        board.add(drawCard());
        board.add(drawCard());
    }

    public List<String> givePlayerCards(){
        List<String> playerCards = new ArrayList<>(2);

        playerCards.add(drawCard());
        playerCards.add(drawCard());

        return playerCards;
    }
     public Deck(){
        currentDeck = shuffle();
     }

}
