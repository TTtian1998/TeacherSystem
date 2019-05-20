package com.tianZeXin.servlet;

import com.tianZeXin.controller.TeacherController;
import com.tianZeXin.entity.Teacher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 田泽鑫
 * @date 2019/5/13
 */
public class ModifyServlet extends HttpServlet {
    TeacherController teacherController = new TeacherController();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Teacher teacher = new Teacher();

        try {
            String strId = request.getParameter("id");
            int id = Integer.parseInt(strId);
            String name = request.getParameter("name");
            String school = request.getParameter("school");
            String major = request.getParameter("major");
            //时间和薪水字符串获取
            String dateStr = request.getParameter("date");
            String salaryStr = request.getParameter("salary");

            // 强制转换
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            Double salary = Double.parseDouble(salaryStr);

            teacher.setName(name);
            teacher.setSchool(school);
            teacher.setMajor(major);
            teacher.setDate(date);
            teacher.setSalary(salary);
            int result = teacherController.update(teacher,id);
            if (result>0){
                response.getWriter().append("true");
            }else {
                response.getWriter().append("false");
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
