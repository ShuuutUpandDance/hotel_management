package com.zjl.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

public class JdbcUtils {
    //初始化连接池
    private static DataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource();
    }

    /**
     * 返回数据源
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 创建dbutils常用工具类对象
     */
    public static QueryRunner getQueryRunner() {
        return new QueryRunner(dataSource);
    }
}
