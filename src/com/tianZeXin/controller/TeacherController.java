package com.tianZeXin.controller;

import com.tianZeXin.entity.Teacher;
import com.tianZeXin.service.TeacherService;
import com.tianZeXin.service.impl.TeacherServiceImpl;

import java.util.List;

/**
 * @author 田泽鑫
 * @date 2019/5/13
 */
public class TeacherController {
    TeacherService teacherServiceimpl = new TeacherServiceImpl();

    public int add(Teacher teacher){

       return teacherServiceimpl.add(teacher);
    }
    public int delete(int id){

        return teacherServiceimpl.delete(id);
    }
    public int update(Teacher teacher,int id){
      return   teacherServiceimpl.update(teacher,id);
    }
    public Teacher getTeacher(int id){

        return teacherServiceimpl.getTeacher(id);
    }
    public List<Teacher> getAllTeachers(){
       return teacherServiceimpl.getAllTeachers();
    }
}
