package org.acme.entity;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

public class Player {

    @Getter
    private final UUID id;

    public List<String> currentCards;

    public boolean isPlaying = true;

    public Player(List<String> cards){
        id = UUID.randomUUID();
        currentCards = cards;
    }
}
