package com.taein.springboot.example.domain.discount.policy;

public class DiscountPolicyStrategyRateImplTest implements DiscountPolicyStrategyTest<DiscountPolicyStrategyRateImpl>{

    private final Long amount = 10L;

    @Override
    public DiscountPolicyStrategyRateImpl getDiscountPolicyStrategy() {
        return new DiscountPolicyStrategyRateImpl(amount);
    }
}
