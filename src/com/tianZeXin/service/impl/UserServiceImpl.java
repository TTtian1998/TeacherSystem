package com.tianZeXin.service.impl;

import com.tianZeXin.dao.UserDao;
import com.tianZeXin.entity.User;
import com.tianZeXin.service.UserService;

/**
 * @author 田泽鑫
 * @date 2019/5/13
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDao();

    @Override
    public boolean login(String username, String password) {
        String un=userDao.getUser().getUsername();
        String pwd=userDao.getUser().getPassword();
        if(un.equals(username)&&pwd.equals(password)){
            System.out.println("登录成功");
            return true;
        }
        else {
            return false;
        }
    }
}
