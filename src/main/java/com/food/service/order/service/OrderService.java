package com.food.service.order.service;

import com.food.service.order.dto.OrderDto;
import com.food.service.order.dto.OrderDtoFromFE;
import com.food.service.order.dto.UserDto;
import com.food.service.order.entity.Order;
import com.food.service.order.mapper.OrderMapper;
import com.food.service.order.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDto saveOrderInDB(OrderDtoFromFE orderDtoFromFE) {
        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDto userDto = fetUserDetailsFromUserId(orderDtoFromFE.getUserId());
        Order orderToBeSaved = new Order(newOrderId, orderDtoFromFE.getFoodItemsDtoList(), orderDtoFromFE.getRestaurant(), userDto);
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDto(orderToBeSaved);
    }

    private UserDto fetUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDto.class);
    }
}

