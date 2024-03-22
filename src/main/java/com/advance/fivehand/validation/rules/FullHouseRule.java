package com.advance.fivehand.validation.rules;

import com.advance.fivehand.domain.Card;
import com.advance.fivehand.domain.ValidationParam;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
public class FullHouseRule implements IRule{
    @Override
    public boolean evaluate(ValidationParam validationParam) {
        Set<String> simple = validationParam.getSimpleRanks();
        if(simple.size() == 2) {
            List<Card> dealt = validationParam.getDealt();
            List<Long> frequencyList = simple.stream()
                    .map(sign -> dealt.stream().filter(card -> card.getRank().equals(sign)).count())
                    .sorted()
                    .collect(Collectors.toList());

            return frequencyList.equals(List.of(2L,3L));
        }
        return false;
    }

}
