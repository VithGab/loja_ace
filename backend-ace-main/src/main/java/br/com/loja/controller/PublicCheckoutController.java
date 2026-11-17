package br.com.loja.controller;

import br.com.loja.dto.OrderDtos.OrderView;
import br.com.loja.dto.PublicCheckoutDtos.*;
import br.com.loja.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/public")
@RequiredArgsConstructor
public class PublicCheckoutController {
  private final OrderService orderService;
 
  @GetMapping("/customers/identify")
  public IdentifiedCustomerView identify(@RequestParam String phone) {
    return orderService.identifyCustomer(phone);
  }

  @PostMapping("/orders")
  @ResponseStatus(HttpStatus.CREATED)
  public OrderView createOrder(
      @Valid @RequestBody PublicOrderInput data,
      @RequestHeader(value = "Idempotency-Key", required = false) String idempotencyKey) {
    return orderService.createPublic(data, idempotencyKey);
  }
}