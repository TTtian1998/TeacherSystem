package com.tianZeXin.controller;

import com.tianZeXin.service.UserService;
import com.tianZeXin.service.impl.UserServiceImpl;

/**
 * @author 田泽鑫
 * @date 2019/5/13
 * controller层不应该包含业务逻辑，controller的功能应该有以下五点：
 * 1.参数校验
 * 2.调用service层接口实现业务逻辑
 * 3.转换业务／数据对象
 * 4.组装返回对象
 * 5.异常处理
 */
public class UserController {
     UserService userServiceImpl =new UserServiceImpl();

    public void test() {
        System.out.println("controller注册成功");
    }
    //登录
    public boolean login(String username,String password){
        return userServiceImpl.login(username,password);
    }
}
