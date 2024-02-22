package org.acme;

import jakarta.ws.rs.BadRequestException;
import org.acme.controller.MatchController;
import org.acme.entity.Match;
import org.acme.models.MatchParameters;
import org.acme.service.CardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MatchControllerTest {

    @InjectMocks
    MatchController matchController;
    @Mock
    CardService cardService;

    MatchParameters validParameters;
    MatchParameters invalidParameters;
    Match expectedMatch;

    @BeforeEach
    public void setup() {
        invalidParameters = new MatchParameters(9);

        validParameters = new MatchParameters(4);
        expectedMatch = new Match(validParameters.amountOfPlayers());
    }

    @Test
    void testStartMatchSuccessful() {
        when(cardService.beginMatch(validParameters)).thenReturn(expectedMatch);

        Match actualMatch = cardService.beginMatch(validParameters);

        assertEquals(expectedMatch, actualMatch);
        verify(cardService).beginMatch(validParameters);
        verifyNoMoreInteractions(cardService);
    }

    @Test
    void testStartMatchInvalidPlayerCount() {
        final BadRequestException e = assertThrows(BadRequestException.class, () -> {
            matchController.startMatch(invalidParameters);
        });

        assertThat(e, notNullValue());
        assertThat(e.getMessage(), is("Amount of players is required"));
        verifyNoInteractions(cardService);

    }

    @Test
    void testShouldThrowExceptionWhenFailToStartMatch() {
        when(cardService.beginMatch(validParameters)).thenThrow(new BadRequestException("Error creating the match"));

        final BadRequestException e = assertThrows(BadRequestException.class, () -> {
            matchController.startMatch(validParameters);
        });

        assertThat(e.getMessage(), is("Error creating the match"));
        assertThat(e.getClass(), is(BadRequestException.class));
        verify(cardService).beginMatch(validParameters);
        verifyNoMoreInteractions(cardService);
    }
}
