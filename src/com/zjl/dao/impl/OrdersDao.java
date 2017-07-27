package com.zjl.dao.impl;

import com.zjl.dao.IOrdersDao;
import com.zjl.entity.Orders;
import com.zjl.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class OrdersDao implements IOrdersDao {
    /**
     * 订单只有从未结账变为结账，因此只需一个函数即可
     * @param id
     */
    @Override
    public void changeStatus(int id) {
        try {
            String sql = "update orders set orderStatus=1 where id=? ";

            JdbcUtils.getQueryRunner().update(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Orders> getAll() {
        try {
            String sql = "select o.id, o.table_id, o.orderDate, o.totalPrice, o.orderStatus, t.tableName " +
                        "from orders o, dinnertable t where 1=1 and o.table_id=t.id ";
            return JdbcUtils.getQueryRunner().query(sql,
                    new BeanListHandler<Orders>(Orders.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Orders findById(int id) {
        try {
            String sql = "select o.id, o.table_id, o.orderDate, o.totalPrice, o.orderStatus, t.tableName " +
                    "from orders o, dinnertable t where 1=1 and o.table_id=t.id and id=?";
            return JdbcUtils.getQueryRunner().query(sql,
                    new BeanHandler<Orders>(Orders.class), id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
