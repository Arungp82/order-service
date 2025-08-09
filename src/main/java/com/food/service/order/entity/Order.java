package com.food.service.order.entity;

import com.food.service.order.dto.FoodItemsDto;
import com.food.service.order.dto.Restaurant;
import com.food.service.order.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {

    private Integer orderId;
    private List<FoodItemsDto> foodItemsDtoList;
    private Restaurant restaurant;
    private UserDto userDto;
}
