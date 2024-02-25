package com.advance.fivehand.validation.rules;

import com.advance.fivehand.domain.ValidationParam;
import com.advance.fivehand.domain.enums.Suit;
import com.advance.fivehand.TestUtils;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static com.advance.fivehand.domain.enums.Suit.*;
import static org.junit.jupiter.api.Assertions.*;
class ThreeKindRuleTest {
    ThreeKindRule kindRule = new ThreeKindRule();
    TestUtils utils = new TestUtils();

    @Test
    void evaluateSuccess() {
        List<String> ranks = List.of("7","7","7","6","K");
        List<Suit> suits = List.of(DIAMONDS,CLUBS,HEARTS,SPADES,DIAMONDS);
        Set<String> simpleRank = Set.of("7","6","K");
        ValidationParam validationParam = ValidationParam.builder()
                .dealt(utils.deal(ranks,suits))
                .simpleRanks(simpleRank)
                .build();
        boolean results = kindRule.evaluate(validationParam);
        assertTrue(results);
    }
    @Test
    void evaluateFailure() {
        List<String> ranks = List.of("7","7","9","6","K");
        List<Suit> suits = List.of(DIAMONDS,CLUBS,HEARTS,SPADES,DIAMONDS);
        Set<String> simpleRank = Set.of("7","9","6","K");
        boolean results = kindRule.evaluate(ValidationParam.builder()
                .dealt(utils.deal(ranks,suits))
                .simpleRanks(simpleRank)
                .build());
        assertFalse(results);
    }
}