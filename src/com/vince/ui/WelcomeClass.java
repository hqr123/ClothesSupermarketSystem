package com.vince.ui;

import com.vince.utils.BusinessException;
import com.vince.utils.BusinessException;
import com.vince.utils.UserIO;

import java.util.Base64;

public class WelcomeClass extends BaseClass {


    public void start(){
        println(getString("info.welcome"));
        UserIO userIO = new UserIO();
        userIO.readUsers();
        boolean flag = true;
        while (flag){
            println(getString("info.login.reg"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch (select){
                case "1":

                   // System.out.println("登录");
                    try {
                        new LoginClass().login();
                        flag = false;
                        println(getString("login.success"));
                    }catch(BusinessException e){
                        println(getString(e.getMessage()));
                    }
                    break;
                case "2":
                    flag = false;
                    //System.out.println("注册");
                    try {
                        new RegisterClass().register();

                        println(getString("reg.success"));

                    }catch(BusinessException e){

                        println(getString( e.getMessage()));
                    }
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }

        }

    }

}
