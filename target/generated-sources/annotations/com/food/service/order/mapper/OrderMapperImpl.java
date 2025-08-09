package com.food.service.order.mapper;

import com.food.service.order.dto.FoodItemsDto;
import com.food.service.order.dto.OrderDto;
import com.food.service.order.entity.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-09T11:52:52+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order mapOrderDtoToOrder(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderId( orderDto.getOrderId() );
        List<FoodItemsDto> list = orderDto.getFoodItemsDtoList();
        if ( list != null ) {
            order.setFoodItemsDtoList( new ArrayList<FoodItemsDto>( list ) );
        }
        order.setRestaurant( orderDto.getRestaurant() );
        order.setUserDto( orderDto.getUserDto() );

        return order;
    }

    @Override
    public OrderDto mapOrderToOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setOrderId( order.getOrderId() );
        List<FoodItemsDto> list = order.getFoodItemsDtoList();
        if ( list != null ) {
            orderDto.setFoodItemsDtoList( new ArrayList<FoodItemsDto>( list ) );
        }
        orderDto.setRestaurant( order.getRestaurant() );
        orderDto.setUserDto( order.getUserDto() );

        return orderDto;
    }
}
