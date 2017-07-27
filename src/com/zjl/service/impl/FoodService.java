package com.zjl.service.impl;

import com.zjl.dao.IFoodDao;
import com.zjl.entity.Food;
import com.zjl.factory.BeanFactory;
import com.zjl.service.IFoodService;
import com.zjl.utils.PageBean;


public class FoodService implements IFoodService {
    private IFoodDao foodDao = BeanFactory.getInstance("foodDao", IFoodDao.class);

    @Override
    public void getAll(PageBean<Food> pb) {
        try {
            foodDao.getAll(pb);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getAll(PageBean<Food> pb, String foodName) {
        try {
            foodDao.getAll(pb, foodName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Food findById(int id) {
        try {
            return foodDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Food food) {
        try {
            foodDao.save(food);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            foodDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Food food) {
        try {
            foodDao.update(food);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
