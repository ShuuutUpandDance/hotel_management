package com.zjl.dao;

import com.zjl.entity.DinnerTable;

import java.sql.Timestamp;
import java.util.List;

public interface IDinnerTableDao {
    /**
     * 添加
     */
    void save(DinnerTable dinnerTable);

    /**
     * 删除
     */
    void delete(int id);

    /**
     * 修改状态
     */
    void updateStatus(int id, int status);

    /**
     * 添加预定时间
     */
    void addOrderDate(int id, Timestamp timestamp);

    /**
     * 清空预定时间
     */
    void clearOrderDate(int id);

    /**
     * 查询所有
     */
    List<DinnerTable> getAll();

    /**
     * 条件查询所有
     */
    List<DinnerTable> getAll(String tableName);
}
