package com.tianZeXin.dao;

import com.tianZeXin.DBconnect.DBconnect;
import com.tianZeXin.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 田泽鑫
 * @date 2019/5/15
 */
public class UserDao {
    //获取数据库的连接对象
    private Connection connection= DBconnect.getConnection();
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public User getUser(){
        User user = new User();
        try {
            String sql="select * from user";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                user.setId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("pass_word"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        //测试是否查询到数据库中的user
        System.out.println(user.getId());
        closeResource();
        return user;
    }

    private void closeResource() {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("PreparedStatement关闭失败");
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("ResultSet关闭失败");
            }
        }
    }
}
