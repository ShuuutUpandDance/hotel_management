package com.zjl.service;

import com.zjl.entity.DinnerTable;

import java.sql.Timestamp;
import java.util.List;

public interface IDinnerTableService {
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
    void order(int id);

    /**
     * 取消预定
     */
    void cancelOrder(int id);

    /**
     * 查询所有
     */
    List<DinnerTable> getAll();

    /**
     * 条件查询所有
     */
    List<DinnerTable> getAll(String tableName);
}
