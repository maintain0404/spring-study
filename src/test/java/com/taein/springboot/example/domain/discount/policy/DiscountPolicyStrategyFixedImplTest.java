package com.taein.springboot.example.domain.discount.policy;

public class DiscountPolicyStrategyFixedImplTest implements DiscountPolicyStrategyTest<DiscountPolicyStrategyFixedImpl>{

    private final Long amount = 10L;

    @Override
    public DiscountPolicyStrategyFixedImpl getDiscountPolicyStrategy() {
        return new DiscountPolicyStrategyFixedImpl(amount);
    }
}
