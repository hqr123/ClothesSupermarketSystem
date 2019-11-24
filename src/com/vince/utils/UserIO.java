package com.vince.utils;

import com.vince.bean.User;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

     // 操作文件的工具类

public class UserIO {

    private static List<User> users = new ArrayList<>();  //创建一个存放用户的列表

    private static final String USER_FILE = "user.obj";


    //写入用户列表
    public boolean writeUsers()throws BusinessException {

        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(USER_FILE));//对象流进行写入操作
            out.writeObject(users);
            out.close();

        } catch (IOException e) {
            throw new BusinessException("io.write.error");//对这个IO异常进行友好提示
        }
        return true;

    }

    //读取用户
    public boolean readUsers()throws BusinessException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(USER_FILE));
            users = (List<User>) in.readObject();
            in.close();


        } catch (IOException | ClassNotFoundException e) {
            throw new BusinessException("io.read.error");   //读取数据失败
        }

        return true;

    }

    public void add(User user) {
        user.setId(users.size() + 1);
        users.add(user);
    }

    public User findByUsernameAndPassord(String username,String password){
        for(User u : users){
            if (u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }
}
