package com.advance.fivehand.validation.rules;

import com.advance.fivehand.domain.Card;
import com.advance.fivehand.domain.ValidationParam;
import com.advance.fivehand.domain.enums.Suit;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FourKindRuleTest {

    FourKindRule fourKindRule = new FourKindRule();

    @Test
    void evaluateSuccess() {
        List<Card> dealt = List.of(Card.builder()
                .rank("7")
                .suit(Suit.DIAMONDS)
                .build(), Card.builder()
                .rank("7")
                .suit(Suit.CLUBS)
                .build(), Card.builder()
                .rank("7")
                .suit(Suit.HEARTS)
                .build(), Card.builder()
                .rank("7")
                .suit(Suit.SPADES)
                .build(), Card.builder()
                .rank("K")
                .suit(Suit.DIAMONDS)
                .build());
        Set<String> simpleRank = Set.of("7","K");
        boolean results = fourKindRule.evaluate(ValidationParam.builder()
                .dealt(dealt)
                .simpleRanks(simpleRank)
                .build());
        assertTrue(results);
    }
    @Test
    void evaluateFailure() {
        List<Card> dealt = List.of(Card.builder()
                .rank("7")
                .suit(Suit.DIAMONDS)
                .build(), Card.builder()
                .rank("7")
                .suit(Suit.CLUBS)
                .build(), Card.builder()
                .rank("9")
                .suit(Suit.HEARTS)
                .build(), Card.builder()
                .rank("6")
                .suit(Suit.SPADES)
                .build(), Card.builder()
                .rank("K")
                .suit(Suit.DIAMONDS)
                .build());
        Set<String> simpleRank = Set.of("7","9","K");
        boolean results = fourKindRule.evaluate(ValidationParam.builder()
                .dealt(dealt)
                .simpleRanks(simpleRank)
                .build());
        assertFalse(results);
    }

}