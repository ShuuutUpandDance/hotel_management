package com.zjl.entity;

/**
 * 菜品实体
 */
public class Food {
    private int id;     //自身主键
    private String foodName;    //菜名
    private int foodType_id;    //引用外键
    private double price;   //价格
    private double mprice;  //会员价格
    private String remark;  //描述
    private String img;     //图片uri
    private String typeName;

    public Food() {
    }

    public Food(int id, String foodName, int foodType_id, double price, double mprice, String remark, String img) {
        this.id = id;
        this.foodName = foodName;
        this.foodType_id = foodType_id;
        this.price = price;
        this.mprice = mprice;
        this.remark = remark;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodType_id() {
        return foodType_id;
    }

    public void setFoodType_id(int foodType_id) {
        this.foodType_id = foodType_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMprice() {
        return mprice;
    }

    public void setMprice(double mprice) {
        this.mprice = mprice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", foodType_id=" + foodType_id +
                ", price=" + price +
                ", mprice=" + mprice +
                ", remark='" + remark + '\'' +
                ", img='" + img + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
