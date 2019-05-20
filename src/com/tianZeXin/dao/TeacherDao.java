package com.tianZeXin.dao;

import com.tianZeXin.DBconnect.DBconnect;
import com.tianZeXin.entity.Teacher;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author 田泽鑫
 * @date 2019/5/14
 */
public class TeacherDao {
    //获取数据库的连接对象
    private Connection connection= DBconnect.getConnection();
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    //新增教师
    public int add(Teacher teacher){
        int result = 0;
        String sql = "insert into teacher (name,school,major,date,salary) values(?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            //时期转换
            Date sqlDate = teacher.getDate();

            preparedStatement.setString(1,teacher.getName());
            preparedStatement.setString(2,teacher.getSchool());
            preparedStatement.setString(3,teacher.getMajor());
            preparedStatement.setDate(4,new java.sql.Date(sqlDate.getTime()) );
            preparedStatement.setDouble(5,teacher.getSalary());
//            System.out.println(sql);
           result = preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        closeResource();
        return result;
    }
    //删除教师
    public int delete(int id){
        int result = 0;
        String sql = "delete from teacher where id =?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            result = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        closeResource();
        return result;
    }
    //更改信息
    public int update(Teacher teacher,int id){
        int result=0;
        String sql="update teacher set name=?,school=?,major=?,date=?,salary=? where id=?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            //时期转换
            Date sqlDate = teacher.getDate();
            preparedStatement.setString(1,teacher.getName());
            preparedStatement.setString(2,teacher.getSchool());
            preparedStatement.setString(3,teacher.getMajor());
            preparedStatement.setDate(4, new java.sql.Date(sqlDate.getTime()));
            preparedStatement.setDouble(5,teacher.getSalary());
            preparedStatement.setInt(6,id);

            result=preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        closeResource();
        return result;
    }
    //查看指定教师信息
    public Teacher getTeacher(int id){
        String sql ="select * from teacher where id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {
                Teacher teacher = new Teacher();

                teacher.setId(resultSet.getInt("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setSchool(resultSet.getString("school"));
                teacher.setMajor(resultSet.getString("major"));
                teacher.setDate(resultSet.getDate("date"));
                teacher.setSalary(resultSet.getDouble("salary"));
                return teacher;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        closeResource();
        return null;
    }

    public List<Teacher> getAllTeachers(){
        List<Teacher> list = new ArrayList<>();
        String sql = "select * from teacher";
        try{
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setSchool(resultSet.getString("school"));
                teacher.setMajor(resultSet.getString("major"));
                teacher.setDate(resultSet.getDate("date"));
                teacher.setSalary(resultSet.getDouble("salary"));

                list.add(teacher);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        closeResource();
        return list;
    }

//    public List<Map<String,Object>> getTeachers(){
//        List<Teacher> teachers = getAllTeachers();
//        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
//        if (teachers == null) {
//            return null;
//        }
//
//        for (Teacher teacher1: teachers) {
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("id", teacher1.getId());
//            map.put("name", teacher1.getName());
//            map.put("school", teacher1.getSchool());
//            map.put("major", teacher1.getMajor());
//            map.put("date", teacher1.getDate());
//            map.put("salary", teacher1.getSalary());
//            result.add(map);
//        }
//        return result;
//    }

    // 关闭连接
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
