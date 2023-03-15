// package com.taein.springboot.example.domain.order;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// import com.taein.springboot.example.core.AppConfig;
// import com.taein.springboot.example.domain.member.entity.Member;
// import com.taein.springboot.example.domain.member.enums.Grade;
// import com.taein.springboot.example.domain.member.service.MemberService;
// import com.taein.springboot.example.domain.order.service.OrderService;
// import com.taein.springboot.example.domain.order.entity.Order;

// public class OrderApp {
//     public static void main(String[] args) {
//         AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//         MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
//         OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
//         applicationContext.close();

//         long memberId = 1L;
//         Member member = new Member(memberId, "memberA", Grade.VIP);
//         memberService.join(member);

//         Order order = orderService.createOrder(memberId, "itemA", 10000);

//         System.out.println("order = " + order);
//     }
// }
