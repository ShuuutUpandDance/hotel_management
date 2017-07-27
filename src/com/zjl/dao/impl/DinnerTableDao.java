package com.zjl.dao.impl;

import com.zjl.dao.IDinnerTableDao;
import com.zjl.entity.DinnerTable;
import com.zjl.utils.JdbcUtils;
import jdk.nashorn.internal.scripts.JD;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Timestamp;
import java.util.List;

public class DinnerTableDao implements IDinnerTableDao {
    @Override
    public void save(DinnerTable dinnerTable) {
        String sql = "insert into dinnertable(tableName) values (?) ";
        try{
            JdbcUtils.getQueryRunner().update(sql, dinnerTable.getTableName());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from dinnertable where id=? ";
        try{
            JdbcUtils.getQueryRunner().update(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStatus(int id, int status) {
        String sql = "update dinnertable set tableStatus=? where id=? ";
        try{
            JdbcUtils.getQueryRunner().update(sql, status, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addOrderDate(int id, Timestamp timestamp) {
        String sql = "update dinnertable set orderDate=? where id=? ";
        try{
            JdbcUtils.getQueryRunner().update(sql, timestamp, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clearOrderDate(int id) {
        String sql = "update dinnertable set orderDate=null where id=? ";
        try{
            JdbcUtils.getQueryRunner().update(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DinnerTable> getAll() {
        String sql = "select * from dinnertable";
        try{
            return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<>(DinnerTable.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DinnerTable> getAll(String tableName) {
        String sql = "select * from dinnertable where tableName like ? ";
        try{
            return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<>(DinnerTable.class),
                    "%"+tableName+"%");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
