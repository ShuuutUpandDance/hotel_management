package com.zjl.service.impl;

import com.zjl.dao.IDinnerTableDao;
import com.zjl.entity.DinnerTable;
import com.zjl.factory.BeanFactory;
import com.zjl.service.IDinnerTableService;

import java.sql.Timestamp;
import java.util.List;

public class DinnerTableService implements IDinnerTableService {
    private IDinnerTableDao dinnerTableDao = BeanFactory.getInstance("dinnerTableDao", IDinnerTableDao.class);
    @Override
    public void save(DinnerTable dinnerTable) {
        try {
            dinnerTableDao.save(dinnerTable);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            dinnerTableDao.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 预定：改状态为1+添加时间
     * @param id
     */
    @Override
    public void order(int id) {
        try {
            //改状态
            dinnerTableDao.updateStatus(id, 1);
            //添加时间
            dinnerTableDao.addOrderDate(id, new Timestamp(System.currentTimeMillis()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 取消预定：改状态为0，删除时间
     * @param id
     */
    @Override
    public void cancelOrder(int id) {
        try {
            //改状态
            dinnerTableDao.updateStatus(id, 0);
            //删除时间
            dinnerTableDao.clearOrderDate(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<DinnerTable> getAll() {
        try {
            return dinnerTableDao.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DinnerTable> getAll(String tableName) {
        try {
            return dinnerTableDao.getAll(tableName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
