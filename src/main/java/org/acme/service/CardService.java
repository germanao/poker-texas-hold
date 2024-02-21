package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Match;
import org.acme.entity.UserTes;
import org.acme.models.MatchParameters;

@ApplicationScoped
public class CardService {
    public Match beginMatch(MatchParameters parameters) {
        return new Match(parameters.amountOfPlayers());
    }
}
