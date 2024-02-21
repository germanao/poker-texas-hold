package org.acme.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Match {

    @Getter
    private final UUID id = UUID.randomUUID();
    public Deck deck =  new Deck();
    public List<String> board = new ArrayList<>(5);

    public List<Player> players;

    public Match() {}

    public Match(int amountOfPlayers){
        distributePlayersCards(amountOfPlayers);

        deck.flop(board);
    }

    private void distributePlayersCards(int amountOfPlayers){
        players = new ArrayList<>(amountOfPlayers);

        for (int i = 0; i < amountOfPlayers; i++) {
            players.add(new Player(deck.givePlayerCards()));
        }
    }
}
