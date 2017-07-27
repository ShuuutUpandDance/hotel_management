package com.zjl.test;

import com.zjl.dao.IDinnerTableDao;
import com.zjl.entity.DinnerTable;
import com.zjl.factory.BeanFactory;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.sql.Timestamp;

public class testTableDao {
    private IDinnerTableDao dinnerTableDao = BeanFactory.getInstance("dinnerTableDao", IDinnerTableDao.class);

    @Test
    public void testSave() {
        DinnerTable dinnerTable = new DinnerTable();
//        dinnerTable.setTableName("纽约");
//        dinnerTable.setTableName("巴黎");
//        dinnerTable.setTableName("丹麦");
        dinnerTable.setTableName("伦敦");

        dinnerTableDao.save(dinnerTable);
    }

    @Test
    public void testGetAll() {
        System.out.println(dinnerTableDao.getAll());
        System.out.println(dinnerTableDao.getAll("巴"));
    }

    @Test
    public void testStatus() {
        dinnerTableDao.updateStatus(1,1);
    }

    @Test
    public void testOrder() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        dinnerTableDao.addOrderDate(1, timestamp);
    }

    @Test
    public void testClear() {
        dinnerTableDao.clearOrderDate(1);
    }
}
