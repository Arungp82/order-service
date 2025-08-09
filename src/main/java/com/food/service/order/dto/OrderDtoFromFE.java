package com.food.service.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDtoFromFE {

    private List<FoodItemsDto> foodItemsDtoList;
    private Integer userId;
    private Restaurant restaurant;
}
