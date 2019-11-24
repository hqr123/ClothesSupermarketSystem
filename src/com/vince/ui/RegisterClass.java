package com.vince.ui;

import com.vince.bean.User;
import com.vince.service.UserService;
import com.vince.service.impl.UserServiceImpl;
import com.vince.utils.BusinessException;

public class RegisterClass extends BaseClass{

    public void  register()throws BusinessException{
        println(getString("input.username")); //输入用户名
        String username = input.nextLine();

        println(getString("input.password"));  //输入密码
        String password = input.nextLine();

        User user = new User(username,password);   //把User对象往后传到service层处理

        UserService userService = new UserServiceImpl();

        userService.register(user);
    }
}
