// package com.taein.springboot.example.domain.order.service;

// import java.util.ArrayList;

// import org.springframework.stereotype.Component;

// import com.taein.springboot.example.domain.discount.enums.DiscountPolicy;
// import com.taein.springboot.example.domain.member.entity.Member;
// import com.taein.springboot.example.domain.member.repository.MemberRepository;
// import com.taein.springboot.example.domain.order.entity.Order;
// import com.taein.springboot.example.domain.order.entity.OrderedItem;

// @Component
// public class OrderServiceDefaultImpl implements OrderService {
//     private MemberRepository memberRepository;

//     public OrderServiceDefaultImpl(MemberRepository memberRepository) {
//         this.memberRepository = memberRepository;
//     }

//     @Override
//     public Order createOrder(Long memberId, Long itemId, DiscountPolicy discountPolicy) {
//         Member member = memberRepository.findById(memberId).get();
//         return new Order(member, new ArrayList<OrderedItem>(), memberId, discountPolicy);
//     }

// }
