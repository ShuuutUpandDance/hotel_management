package com.zjl.test;

import com.zjl.entity.FoodType;
import com.zjl.service.IFoodTypeService;
import com.zjl.service.impl.FoodTypeService;
import org.junit.jupiter.api.Test;

import java.util.List;

public class testFTService {
    private IFoodTypeService foodTypeService = new FoodTypeService();

    @Test
    public void testGetAll() {
        List<FoodType>list = foodTypeService.getAll();
        System.out.println(list);
    }
}
