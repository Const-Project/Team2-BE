package com.example.Team2BE.Order.presentation;


import com.example.Team2BE.Member.service.MemberService;
import com.example.Team2BE.Order.dto.request.OrderRequest;
import com.example.Team2BE.Order.dto.response.OrderResponse;
import com.example.Team2BE.Order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    public OrderService orderService;
    public MemberService memberService;

    // 주문 생성
    @PostMapping
    public ResponseEntity<Void> createMemberRequest(@RequestBody OrderRequest request)
    {
        orderService.createOrder(request.getMenu(), request.getCost(), request.getQuantity(), request.getIsPacked(), request.getMemberId());
        return ResponseEntity.ok().build();
    }

    // 주문 삭제
    @DeleteMapping("/{orderId}/delete")
    public ResponseEntity<Void> deleteOrderRequest(@RequestBody OrderRequest request)
    {
        orderService.deleteOrder(request.getMenu(), request.getQuantity(), request.getMemberId());
        return ResponseEntity.ok().build();
    }

    // 주문 조회
    @GetMapping("/{memberId}/list")
    public ResponseEntity<OrderResponse> getOrderListRequest(@RequestBody OrderRequest request)
    {
        OrderResponse orderResponse = new OrderResponse(orderService.getOrderList(request.getMemberId()));
        return ResponseEntity.ok().body(orderResponse);
    }

}
