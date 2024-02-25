package com.advance.fivehand.validation.engine;

import com.advance.fivehand.business.Utils;
import com.advance.fivehand.domain.Card;
import com.advance.fivehand.domain.ValidationParam;
import com.advance.fivehand.domain.enums.Hand;
import com.advance.fivehand.validation.rules.*;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static com.advance.fivehand.domain.enums.Hand.*;

public interface RuleEngine extends Function<ValidationParam, Hand> {
    StraightRule straightRule = new StraightRule();
    FlushRule flushRule = new FlushRule();
    FullHouseRule houseRule = new FullHouseRule();
    FourKindRule fourKindRule = new FourKindRule();
    ThreeKindRule threeKindRule = new ThreeKindRule();
    TwoPairRule twoPairRule = new TwoPairRule();
    OnePairRule onePairRule = new OnePairRule();
    Utils utils = new Utils();
    static RuleEngine isStraightHand() {
        return validationParam ->
             straightRule.evaluate(createParams(validationParam.getDealt())) ? STRAIGHT : HIGH_CARDS;
    }
    static RuleEngine isStraightFlushHand() {
        return validationParam ->
                straightRule.evaluate(createParams(validationParam.getDealt())) &&
                        flushRule.evaluate(createParams(validationParam.getDealt()))? STRAIGHT_FLUSH : HIGH_CARDS;
    }
    static RuleEngine isFlushHand() {
        return validationParam ->
                flushRule.evaluate(createParams(validationParam.getDealt())) ? FLUSH : HIGH_CARDS;
    }
    static RuleEngine isFullHouseHand() {
        return validationParam ->
                houseRule.evaluate(createParams(validationParam.getDealt())) ? FULL_HOUSE : HIGH_CARDS;
    }
    static RuleEngine isFourKindHand() {
        return validationParam ->
                fourKindRule.evaluate(createParams(validationParam.getDealt())) ? FOUR_KIND : HIGH_CARDS;
    }
    static RuleEngine isThreeKindHand() {
        return validationParam ->
                threeKindRule.evaluate(createParams(validationParam.getDealt())) ? THREE_KIND : HIGH_CARDS;
    }
    static RuleEngine isTwoPairHand() {
        return validationParam ->
                twoPairRule.evaluate(createParams(validationParam.getDealt())) ? TWO_PAIR : HIGH_CARDS;
    }
    static RuleEngine isOnePairHand() {
        return validationParam ->
                onePairRule.evaluate(createParams(validationParam.getDealt())) ? ONE_PAIR : HIGH_CARDS;
    }


    default RuleEngine and(RuleEngine other) {
        return validationParam -> {
            Hand results = this.apply(validationParam);
            return results.equals(HIGH_CARDS) ? other.apply(validationParam) : results;
        };
    }
    static ValidationParam createParams(List<Card> dealt){
        Set<String> simpleRank = utils.simplifyRank(dealt);
        Set<Integer> simpleSuit = utils.simplifySuits(dealt);
        return ValidationParam.builder()
                .dealt(dealt)
                .simpleSuits(simpleSuit)
                .simpleRanks(simpleRank)
                .build();
    }
}
