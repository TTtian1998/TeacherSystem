package com.tianZeXin.servlet;

import com.tianZeXin.controller.TeacherController;
import com.tianZeXin.entity.Teacher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * @author 田泽鑫
 * @date 2019/5/13
 */
public class AddServlet  extends HttpServlet {
    TeacherController teacherController = new TeacherController();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Teacher teacher = new Teacher();

        try {
            String name = request.getParameter("name");
            String school = request.getParameter("school");
            String major = request.getParameter("major");
            //时间和薪水字符串获取
            String dateStr = request.getParameter("date");
            String salaryStr = request.getParameter("salary");
            //判断前台传值是否为空
            if (name.equals(null)||school.equals(null)||major.equals(null)||
                    dateStr.equals(null)||salaryStr.equals(null)){
                response.getWriter().append("false");
            }
            else {
                System.out.println("if else测试");
                // 强制转换
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                Double salary = Double.parseDouble(salaryStr);

                teacher.setName(name);
                teacher.setSchool(school);
                teacher.setMajor(major);
                teacher.setDate(date);
                teacher.setSalary(salary);
                int result = teacherController.add(teacher);
                if (result>0){
                    response.getWriter().append("true");
                }else {
                    response.getWriter().append("false");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
