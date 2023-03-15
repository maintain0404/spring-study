package com.taein.springboot.example.domain.order.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.taein.springboot.example.domain.discount.enums.DiscountPolicy;
import com.taein.springboot.example.domain.discount.policy.DiscountPolicyStrategy;
import com.taein.springboot.example.domain.discount.policy.DiscountPolicyStrategyFixedImpl;
import com.taein.springboot.example.domain.discount.policy.DiscountPolicyStrategyNoneImpl;
import com.taein.springboot.example.domain.discount.policy.DiscountPolicyStrategyRateImpl;
import com.taein.springboot.example.domain.member.entity.Member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderedItem> orderedItems = new ArrayList<OrderedItem>();

    private Long discountAmount;

    @Enumerated(EnumType.STRING)
    private DiscountPolicy discountPolicy = DiscountPolicy.NONE;

    @Transient
    @Setter(value = AccessLevel.NONE)
    private DiscountPolicyStrategy discountPolicyStrategy; // 롬북 제외가능한 방법 없나

    public Order(Member member, List<OrderedItem> orderedItems, Long discountAmount, DiscountPolicy discountPolicy) {
        this.member = member;
        this.orderedItems = orderedItems;
        this.discountAmount = discountAmount;
        this.discountPolicy = discountPolicy;
    }

    public DiscountPolicyStrategy getDiscountPolicyStrategy() {
        DiscountPolicy policy = this.getDiscountPolicy();
        if (policy == DiscountPolicy.FIXED) {
            return new DiscountPolicyStrategyFixedImpl(this.getDiscountAmount());
        } else if (policy == DiscountPolicy.RATE) {
            return new DiscountPolicyStrategyRateImpl(this.getDiscountAmount());
        } else {
            return new DiscountPolicyStrategyNoneImpl(discountAmount);
        }
    }

    public Long getDiscountedPrice() {
        Long sum = 0L;
        for (OrderedItem orderedItem : orderedItems) {
            sum = sum + orderedItem.getCount() * orderedItem.getItem().getPrice();
        }
        return this.getDiscountPolicyStrategy().discount(member, sum);
    }
}
