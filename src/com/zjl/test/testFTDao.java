package com.zjl.test;

import com.zjl.dao.IFoodTypeDao;
import com.zjl.dao.impl.FoodTypeDao;
import com.zjl.entity.FoodType;
import org.junit.jupiter.api.Test;

import java.util.List;

public class testFTDao {
    private IFoodTypeDao foodTypeDao = new FoodTypeDao();
    @Test
    public void testSave() {
        FoodType foodType = new FoodType(1,"粤菜");
        foodTypeDao.save(foodType);
    }

    @Test
    public void testGetAll() {
        List<FoodType>list = foodTypeDao.getAll();
        System.out.println(list);

        List<FoodType>list1 = foodTypeDao.getAll("菜");
        System.out.println(list1);
    }

    @Test
    public void testUpdate() {
        FoodType foodType = new FoodType(1,"粤菜");
        System.out.println(foodType.getId()+" "+foodType.getTypeName());
        foodTypeDao.update(foodType);
    }

    @Test
    public void testDelete() {
        foodTypeDao.delete(3);
    }
}
