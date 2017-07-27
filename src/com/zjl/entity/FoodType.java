package com.zjl.entity;

/**
 * 菜系模块实体类
 */
public class FoodType {
    private int id;     //类别主键
    private String typeName;    //类别名称

    public FoodType() {
    }

    public FoodType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
