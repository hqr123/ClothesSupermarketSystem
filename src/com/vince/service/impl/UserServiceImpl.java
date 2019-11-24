package com.vince.service.impl;

import com.vince.bean.User;
import com.vince.service.UserService;
import com.vince.utils.BusinessException;
import com.vince.utils.EmptyUtils;
import com.vince.utils.UserIO;

 public class UserServiceImpl implements UserService {

    @Override
    public User register(User user) throws BusinessException {

        UserIO userIo = new UserIO();

        userIo.add(user);//把user添加进来，然后进行写操作

        userIo.writeUsers();

        return user;
    }

     @Override
     public User login(String username, String password) throws BusinessException {
        if (EmptyUtils.isEmpty(username)){
            throw new BusinessException("username.notnull");
        }
        if(EmptyUtils.isEmpty(password)){
            throw new BusinessException("password.notnull");
        }

        UserIO userIo = new UserIO();
        User user= userIo.findByUsernameAndPassord(username,password);


         return user;
     }
 }
