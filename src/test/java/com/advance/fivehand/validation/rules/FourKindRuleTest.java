package com.advance.fivehand.validation.rules;

import com.advance.fivehand.TestDataGenerator;
import com.advance.fivehand.TestUtils;
import com.advance.fivehand.domain.Card;
import com.advance.fivehand.domain.ValidationParam;
import com.advance.fivehand.domain.enums.Suit;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FourKindRuleTest {

    FourKindRule fourKindRule = new FourKindRule();
    TestDataGenerator dataGenerator = new TestDataGenerator();

    @Test
    void evaluateSuccess() {
        List<Card> dealt = dataGenerator.FourKindHand();
        Set<String> simpleRank = Set.of("7","K");
        boolean results = fourKindRule.evaluate(ValidationParam.builder()
                .dealt(dealt)
                .simpleRanks(simpleRank)
                .build());
        assertTrue(results);
    }
    @Test
    void evaluateFailure() {
        List<Card> dealt = dataGenerator.OnePairHand();
        Set<String> simpleRank = Set.of("7","1","6","4");
        boolean results = fourKindRule.evaluate(ValidationParam.builder()
                .dealt(dealt)
                .simpleRanks(simpleRank)
                .build());
        assertFalse(results);
    }

}