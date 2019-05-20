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

/**
 * @author 田泽鑫
 * @date 2019/5/13
 */
public class DeleteServlet  extends HttpServlet {
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
        int result = teacherController.delete(id);
        if (result>0){
            response.getWriter().append("true");
        }else {
            response.getWriter().append("false");
        }

    }
}
