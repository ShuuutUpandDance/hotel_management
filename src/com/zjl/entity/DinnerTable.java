package com.zjl.entity;

import java.sql.Timestamp;

public class DinnerTable {
    private int id;
    private String tableName;
    private int tableStatus;    //0，空闲；1，预定
    private Timestamp orderDate;

    public DinnerTable() {
    }

    public DinnerTable(int id, String tableName, int tableStatus, Timestamp orderDate) {
        this.id = id;
        this.tableName = tableName;
        this.tableStatus = tableStatus;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(int tableStatus) {
        this.tableStatus = tableStatus;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "DinnerTable{" +
                "id=" + id +
                ", tableName='" + tableName + '\'' +
                ", tableStatus=" + tableStatus +
                ", orderDate=" + orderDate +
                '}';
    }
}
