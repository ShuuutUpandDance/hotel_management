package com.zjl.dao.impl;

import com.zjl.dao.IFoodDao;
import com.zjl.entity.Food;
import com.zjl.utils.JdbcUtils;
import com.zjl.utils.PageBean;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.ArrayList;
import java.util.List;

public class FoodDao implements IFoodDao {
    @Override
    public void getAll(PageBean<Food> pb) {
        StringBuffer sb = new StringBuffer();
        sb.append("select");
        sb.append("		f.id,");
        sb.append("		f.foodName,");
        sb.append("		f.price,");
        sb.append("		f.mprice,");
        sb.append("		f.remark,");
        sb.append("		f.img,");
        sb.append("		f.foodType_id,");
        sb.append("		t.typeName ");
        sb.append("from ");
        sb.append("		food f, ");
        sb.append("		foodtype t ");
        sb.append("where 1=1");
        sb.append("		and f.foodType_id=t.id ");
        sb.append(" LIMIT ?,?");

        int totalCount = getTotalCount();
        pb.setTotalCount(totalCount);

        if (pb.getCurrentPage() < 1) {
            pb.setCurrentPage(1);
        } else if (pb.getCurrentPage() > pb.getTotalPage()) {
            pb.setCurrentPage(pb.getTotalPage());
        }

        int index = (pb.getCurrentPage() - 1) * pb.getPageCount();
        int count = pb.getPageCount();

        try {
            List<Food>pageData = JdbcUtils.getQueryRunner().query(
                    sb.toString(), new BeanListHandler<Food>(Food.class),
                    index, count);

            pb.setPageData(pageData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getAll(PageBean<Food> pb, String foodName) {
        StringBuffer sb = new StringBuffer();
        sb.append("select");
        sb.append("		f.id,");
        sb.append("		f.foodName,");
        sb.append("		f.price,");
        sb.append("		f.mprice,");
        sb.append("		f.remark,");
        sb.append("		f.img,");
        sb.append("		f.foodType_id,");
        sb.append("		t.typeName ");
        sb.append("from ");
        sb.append("		food f, ");
        sb.append("		foodtype t ");
        sb.append("where 1=1");
        sb.append("		and f.foodType_id=t.id ");
        sb.append("		and f.foodName like ? ");
        sb.append("     LIMIT ?,?");

        int totalCount = getTotalCount(foodName);
        pb.setTotalCount(totalCount);

        if (pb.getCurrentPage() < 1) {
            pb.setCurrentPage(1);
        } else if (pb.getCurrentPage() > pb.getTotalPage()) {
            pb.setCurrentPage(pb.getTotalPage());
        }

        int index = (pb.getCurrentPage() - 1) * pb.getPageCount();
        int count = pb.getPageCount();

        try {
            List<Food>pageData = JdbcUtils.getQueryRunner().query(
                    sb.toString(), new BeanListHandler<Food>(Food.class),
                    "%"+foodName+"%",index, count);

            pb.setPageData(pageData);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getTotalCount() {
        StringBuffer sb = new StringBuffer();
        sb.append("select");
        sb.append("		count(*) ");
        sb.append("from ");
        sb.append("		food f, ");
        sb.append("		foodtype t");
        sb.append("     where 1=1");
        sb.append("		and f.foodType_id=t.id ");

        try {
            Long count = JdbcUtils.getQueryRunner().query(sb.toString(),new ScalarHandler<>());
            return count.intValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getTotalCount(String foodName) {
        StringBuffer sb = new StringBuffer();
        sb.append("select");
        sb.append("		count(*) ");
        sb.append("from ");
        sb.append("		food f, ");
        sb.append("		foodtype t");
        sb.append("     where 1=1");
        sb.append("		and f.foodType_id=t.id ");
        sb.append("		and f.foodName like ? ");
        try {
            Long count = JdbcUtils.getQueryRunner().query(sb.toString(),new ScalarHandler<>(), foodName);
            return count.intValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Food findById(int id) {
        StringBuilder sb = new StringBuilder();
        sb.append("select");
        sb.append("      f.id,");
        sb.append("      f.foodName,");
        sb.append("		 f.foodType_id,");
        sb.append("      f.price,");
        sb.append("      f.mprice,");
        sb.append("		 f.remark,");
        sb.append("		 f.img,");
        sb.append("		 t.typeName ");
        sb.append("from");
        sb.append("		 food f,");
        sb.append("		 foodtype t");
        sb.append("      where f.id=?");
        sb.append("		 and f.foodType_id=t.id");

        try {
            return JdbcUtils.getQueryRunner().query(sb.toString(),
                    new BeanHandler<>(Food.class),id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Food food) {
        String sql = "insert into food(foodName, foodType_id, price, mprice, remark, img) "
                + "values(?,?,?,?,?,?)";
        try {
            JdbcUtils.getQueryRunner().update(sql,
                    food.getFoodName(),food.getFoodType_id(),food.getPrice(),
                    food.getMprice(),food.getRemark(),food.getImg());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from food where id=?";
        try {
            JdbcUtils.getQueryRunner().update(sql,id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Food food) {
        StringBuilder sb = new StringBuilder();
        sb.append("update food set ");
        sb.append("foodName=?, foodType_id=?, price=?, mprice=?, remark=?, img=? ");
        sb.append("where id=?");
        try {
            JdbcUtils.getQueryRunner().update(sb.toString(),
                    food.getFoodName(),food.getFoodType_id(),food.getPrice(),
                    food.getMprice(),food.getRemark(),food.getImg(), food.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
