package com.zjl.dao;

import com.zjl.entity.Orders;

import java.util.List;

/**
 * 订单dao，功能不多
 * 1. 结账，即更改状态
 * 2. 显示
 * 3. 按id查找
 */
public interface IOrdersDao {
    /**
     * 更改状态
     */
    void changeStatus(int id);

    /**
     * 显示
     */
    List<Orders> getAll();

    /**
     * 按id查找
     */
    Orders findById(int id);
}
