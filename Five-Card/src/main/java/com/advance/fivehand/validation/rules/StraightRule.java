package com.advance.fivehand.validation.rules;

import com.advance.fivehand.domain.ValidationParam;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor

public class StraightRule implements IRule {
    @Override
    public boolean evaluate(ValidationParam validationParam) {
        List<Integer> numbers = validationParam.getDealt().stream()
                .map(card -> Integer.parseInt(card.getRank()))
                .sorted()
                .collect(Collectors.toList());

        for(int i=1;i<numbers.size();i++)
        {
            if(numbers.get(i)!=numbers.get(i-1)+1)
            {
                return false;
            }
        }

        return true;
    }
}
