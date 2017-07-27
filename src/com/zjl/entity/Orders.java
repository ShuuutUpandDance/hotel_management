package com.zjl.entity;

import java.sql.Timestamp;

public class Orders {
    private int id;
    private int table_id;
    private Timestamp orderDate;
    private double totalPrice;
    private int orderStatus;
    private String tableName;

    public Orders() {
    }

    public Orders(int id, int table_id, Timestamp orderDate, double totalPrice, int orderStatus, String tableName) {
        this.id = id;
        this.table_id = table_id;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.tableName = tableName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", table_id=" + table_id +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", orderStatus=" + orderStatus +
                ", tableName='" + tableName + '\'' +
                '}';
    }
}
