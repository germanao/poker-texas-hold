package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.BadRequestException;
import org.acme.entity.Match;
import org.acme.entity.UserTes;
import org.acme.models.MatchParameters;

@ApplicationScoped
public class CardService {
    public Match beginMatch(MatchParameters parameters) {
        try {
            return new Match(parameters.amountOfPlayers());
        } catch (final Exception e) {
            throw new BadRequestException("Error creating the match", e);
        }

    }
}
