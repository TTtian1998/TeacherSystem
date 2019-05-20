package com.tianZeXin.service;

import com.tianZeXin.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @author 田泽鑫
 * @date 2019/5/14
 */
public interface TeacherService {
    public int add(Teacher teacher);
    public int delete(int id);
    public int update(Teacher teacher,int id);
    public Teacher getTeacher(int id);
    public List<Teacher> getAllTeachers();
//    public List<Map<String,Object>> getTeachers();
}
