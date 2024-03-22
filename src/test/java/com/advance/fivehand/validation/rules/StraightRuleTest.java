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

class StraightRuleTest {
    StraightRule rule = new StraightRule();
    TestUtils utils = new TestUtils();

    @Test
    void evaluateSuccess() {
        List<String> ranks = List.of("1","2","3","4","5");
        List<Suit> suits = List.of(DIAMONDS,CLUBS,HEARTS,SPADES,DIAMONDS);

        ValidationParam validationParam = ValidationParam.builder()
                .dealt(utils.deal(ranks,suits))
                .build();
        boolean results = rule.evaluate(validationParam);
        assertTrue(results);
    }
    @Test
    void evaluateFailure() {
        List<String> ranks = List.of("7","7","9","6","10");
        List<Suit> suits = List.of(DIAMONDS,CLUBS,HEARTS,SPADES,DIAMONDS);
        boolean results = rule.evaluate(ValidationParam.builder()
                .dealt(utils.deal(ranks,suits))
                .build());
        assertFalse(results);
    }

}