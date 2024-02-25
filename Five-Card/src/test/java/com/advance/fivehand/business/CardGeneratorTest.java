package com.advance.fivehand.business;

import com.advance.fivehand.domain.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardGeneratorTest {

    CardGenerator generator = new CardGenerator();

    @Test
    void testCreateDeck(){
        List<Card> deck = generator.createDeck();
        assertEquals(52,deck.size());
    }

}