package com.zjl.test;

import com.zjl.dao.IFoodDao;
import com.zjl.dao.impl.FoodDao;
import com.zjl.entity.Food;
import com.zjl.utils.PageBean;
import org.junit.jupiter.api.Test;

import java.util.List;

public class testFoodDao {
    private IFoodDao foodDao = new FoodDao();
    @Test
    public void testSave() {
//        Food food = new Food(1, "白灼虾", 1, 36.0, 23.0, "这是白灼虾", "img");
//        Food food = new Food(1, "白斩鸡", 1, 68.0, 50.0, "这是白斩鸡", "img");
//        Food food = new Food(3, "烤乳猪", 1, 68.0, 50.0, "烤乳猪啊很肥的", "img");
//        Food food = new Food(4, "烧鹅", 1, 68.0, 50.0, "鹅也有了就差鸭了", "img");
//        Food food = new Food(5, "猪肉荷兰豆", 1, 68.0, 50.0, "荷兰豆是什么高大上的东西", "img");
//        Food food = new Food(6, "黄埔炒蛋", 1, 40, 30, "来自黄埔烹饪学校", "img");
//        Food food = new Food(7, "狗肉煲", 1, 68.0, 50.0, "怎么能吃狗狗？！", "img");
//        Food food = new Food(8, "鲫鱼汤", 1, 68.0, 50.0, "营养滋补好味道", "img");
//        Food food = new Food(9, "酱猪蹄", 2, 68.0, 50.0, "终于到了川菜", "img");
//        Food food = new Food(10, "饶汁豆腐", 2, 68.0, 50.0, "清淡一点吧", "img");
//        Food food = new Food(11, "水煮鱼", 2, 68.0, 50.0, "辣不死你", "img");
//        Food food = new Food(12, "鱼香肉丝", 2, 68.0, 50.0, "经典", "img");
//        Food food = new Food(13, "冰糖湘莲", 3, 68.0, 50.0, "文艺青年", "img");
//        Food food = new Food(14, "东安子鸡", 3, 68.0, 50.0, "文艺青年", "img");
//        Food food = new Food(15, "剁椒鱼头", 3, 68.0, 50.0, "喜欢！", "img");
//        Food food = new Food(16, "烧鸭蛋", 3, 68.0, 50.0, "奇怪吃法", "img");
//        Food food = new Food(17, "锅包肉", 4, 45, 35, "终于到东北了", "img");
//        Food food = new Food(1, "火腿白菜", 4, 68.0, 50.0, "简简单单", "img");
//        Food food = new Food(19, "青椒鸡丁", 4, 68.0, 50.0, "辣鸡", "img");
        Food food = new Food(20, "香锅肉丸", 4, 68.0, 50.0, "大肉大肉", "img");
        foodDao.save(food);
    }

    @Test
    public void testFind() {
        Food food = foodDao.findById(2);
        System.out.println(food);
    }

    @Test
    public void testUpdate() {
        Food food = new Food(1, "白灼虾", 1, 60.0, 45.0, "白灼虾test", "abc");
        foodDao.update(food);
    }

    @Test
    public void testTotalCount() {
        System.out.println(foodDao.getTotalCount());
    }

    @Test
    public void testGetAll() {
        PageBean<Food>pb = new PageBean<>();
        pb.setCurrentPage(2);
        foodDao.getAll(pb);
        System.out.println(pb.getPageData());
    }

    @Test
    public void testGetAll2() {
        PageBean<Food>pb = new PageBean<>();
        pb.setCurrentPage(1);
        foodDao.getAll(pb, "白");
        System.out.println(pb.getPageData());
    }
}
