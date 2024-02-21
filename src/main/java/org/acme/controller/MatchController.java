package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.entity.Match;
import org.acme.models.MatchParameters;
import org.acme.service.CardService;

@Path("/api/match")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MatchController {
    @Inject
    CardService cardService;

    @POST
    public Match startMatch(MatchParameters parameters){
        if(parameters.amountOfPlayers() == 0 || parameters.amountOfPlayers() > 8)
            throw new BadRequestException("Amount of players is required");

        return cardService.beginMatch(parameters);
    }
}


