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
import java.util.Map;

/**
 * @author 田泽鑫
 * @date 2019/5/14
 */
public class TableServlet  extends HttpServlet {
    private static final long serialVersionUID=1L;
    TeacherController teacherController = new TeacherController();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Teacher> list = teacherController.getAllTeachers();

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

//        System.out.println("josn语句前测试");
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append(jsonArray.toString());

//        System.out.println("josn语句后测试");
        System.out.println(jsonArray.toString());


    }
}
