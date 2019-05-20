package com.tianZeXin.servlet;

import com.tianZeXin.controller.TeacherController;
import com.tianZeXin.entity.Teacher;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author 田泽鑫
 * @date 2019/5/13
 * 前台点击查看，获取到某一行数据的id，id传值到servlet，通过id查询到对象，将对象属性展示在前台页面。
 */
public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    TeacherController teacherController = new TeacherController();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String strId = request.getParameter("id");
        int id = Integer.parseInt(strId);
        //通过获取到学生信息
        Teacher teacher = teacherController.getTeacher(id);

        //日期转换器
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class,new JsonValueProcessor() {
            private SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            @Override
            public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
                return  value == null ?"" : sd.format(value);
            }
            @Override
            public Object processArrayValue(Object value, JsonConfig jsonConfig) {
                return null;
            }
        });

        JSONArray jsonArray = JSONArray.fromObject(teacher,jsonConfig);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append(jsonArray.toString());
//        response.getWriter().append("true");
        System.out.println(jsonArray.toString());


    }
}
