package com.advance.fivehand.validation.rules;

import com.advance.fivehand.domain.ValidationParam;

import java.util.Set;

public class FlushRule implements IRule {
    @Override
    public boolean evaluate(ValidationParam validationParam) {
        Set<Integer> weight = validationParam.getSimpleSuits();
        if(weight.size() == 1){
            return true;
        }
        return false;
    }


}
