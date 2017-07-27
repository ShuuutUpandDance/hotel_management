package com.zjl.service.impl;

import com.zjl.dao.IFoodTypeDao;
import com.zjl.entity.FoodType;
import com.zjl.factory.BeanFactory;
import com.zjl.service.IFoodTypeService;

import java.util.List;

public class FoodTypeService implements IFoodTypeService {
    //调用dao
//    private IFoodTypeDao foodTypeDao = new FoodTypeDao(); //dao对象的创建不能写死
    //使用工厂创建对象
    private IFoodTypeDao foodTypeDao = BeanFactory.getInstance("foodtypeDao", IFoodTypeDao.class);

    @Override
    public void save(FoodType foodType) {
        try {
            foodTypeDao.save(foodType);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(FoodType foodType) {
        try {
            foodTypeDao.update(foodType);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            foodTypeDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public FoodType findById(int id) {
        try {
            return foodTypeDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FoodType> getAll() {
        try {
            return foodTypeDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FoodType> getAll(String typeName) {
        try {
           return foodTypeDao.getAll(typeName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
