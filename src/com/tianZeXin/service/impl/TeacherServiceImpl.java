package com.tianZeXin.service.impl;

import com.tianZeXin.dao.TeacherDao;
import com.tianZeXin.entity.Teacher;
import com.tianZeXin.service.TeacherService;

import java.util.List;

/**
 * @author 田泽鑫
 * @date 2019/5/15
 */
public class TeacherServiceImpl implements TeacherService {
    TeacherDao teacherDao = new TeacherDao();

    @Override
    public int add(Teacher teacher) {
      int result = teacherDao.add(teacher);
      if (result>0){
          return result;
      }
      else {
          return -1;
      }
    }

    @Override
    public int delete(int id) {
        int result =  teacherDao.delete(id);
        if (result>0){
            return result;
        }
        else {
            return -1;
        }

    }

    @Override
    public int update(Teacher teacher,int id) {
       int result= teacherDao.update(teacher,id);
        if (result>0){
            return result;
        }
        else {
            return -1;
        }
    }

    @Override
    public Teacher getTeacher(int id) {

        return teacherDao.getTeacher(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }
}
