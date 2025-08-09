package com.food.service.order.controller;

import com.food.service.order.dto.OrderDto;
import com.food.service.order.dto.OrderDtoFromFE;
import com.food.service.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFromFE orderDtoFromFE) {
        OrderDto orderSavedInDb = orderService.saveOrderInDB(orderDtoFromFE);
        return new ResponseEntity<>(orderSavedInDb, HttpStatus.CREATED);
    }
}
