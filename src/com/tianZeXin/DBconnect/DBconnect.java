package com.tianZeXin.DBconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 田泽鑫
 * @date 2019/5/14
 */
public class DBconnect {
    private static Connection connection = null;

    public static Connection getConnection(){
        if (connection != null) {
            return connection;
        }
        try {
            // 加载数据库的驱动
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功");
            // 建立链接
            String userName = "root";
            String passWord = "410520";
            String url = "jdbc:mysql://localhost:3306/teacher?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
            /**
             * test?useUnicode=true&characterEncoding=UTF-8
             * 解决数据库乱码的问题*/
            // 连数据库
            connection = DriverManager.getConnection(url,userName,passWord);
            System.out.println("数据库连接成功");

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException异常");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQLException异常");
            e.printStackTrace();
        }
        return connection;
    }
}
