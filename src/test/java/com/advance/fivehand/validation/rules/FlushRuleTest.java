package com.advance.fivehand.validation.rules;

import com.advance.fivehand.TestUtils;
import com.advance.fivehand.domain.ValidationParam;
import com.advance.fivehand.domain.enums.Suit;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static com.advance.fivehand.domain.enums.Suit.*;
import static com.advance.fivehand.domain.enums.Suit.DIAMONDS;
import static org.junit.jupiter.api.Assertions.*;

class FlushRuleTest {
    FlushRule rule = new FlushRule();
    TestUtils utils = new TestUtils();

    @Test
    void evaluateSuccess() {
        List<String> ranks = List.of("7","8","9","2","6");
        List<Suit> suits = List.of(DIAMONDS,DIAMONDS,DIAMONDS,DIAMONDS,DIAMONDS);
        Set<Integer> simpleSuit = Set.of(DIAMONDS.weight);
        ValidationParam validationParam = ValidationParam.builder()
                .dealt(utils.deal(ranks,suits))
                .simpleSuits(simpleSuit)
                .build();
        boolean results = rule.evaluate(validationParam);
        assertTrue(results);
    }
    @Test
    void evaluateFailure() {
        List<String> ranks = List.of("7","7","9","6","K");
        List<Suit> suits = List.of(DIAMONDS,CLUBS,HEARTS,SPADES,DIAMONDS);
        Set<Integer> simpleSuit = Set.of(1,3,2);
        boolean results = rule.evaluate(ValidationParam.builder()
                .dealt(utils.deal(ranks,suits))
                .simpleSuits(simpleSuit)
                .build());
        assertFalse(results);
    }

}