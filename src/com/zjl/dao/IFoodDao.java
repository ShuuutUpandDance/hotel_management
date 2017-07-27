package com.zjl.dao;

import com.zjl.entity.Food;
import com.zjl.utils.PageBean;

/**
 * 菜详细 数据库接口
 */
public interface IFoodDao {
    /**
     * 查询一页的数据
     */
    void getAll(PageBean<Food> pb);

    /**
     * 模糊查询一页数据
     */
    void getAll(PageBean<Food>pb, String foodName);

    /**
     * 查询总记录数，pagebean要用到
     */
    int getTotalCount();

    /**
     * 模糊查询总记录数
     */
    int getTotalCount(String foodName);

    /**
     * 根据id查询，进入更新视图前，需要
     * 先根据id获取更新目标的原数据，然后传给更新视图
     */
    Food findById(int id);

    void save(Food food);

    void delete(int id);

    void update(Food food);
}
