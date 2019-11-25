package com.vince.ui;

import com.vince.bean.Clothes;
import com.vince.service.ClothesService;
import com.vince.service.impl.ClothesServiceImpl;
import com.vince.utils.ConsoleTable;

import java.util.List;

public class HomeClass extends BaseClass {

    public void  show(){
        showProduct();
        println("welcome:"+currUser.getUsername());
        boolean flag = true;
        while (flag){
            println(getString("home.function"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch (select){
                case "1"://1、查询全部订单
                    findList();
                    flag = false;
                    break;
                case "2"://2、查询订单
                    findOrderById();
                    flag = false;
                    break;
                case "3"://购买
                    byProducts();
                    flag = false;
                    break;
                case "0":
                    flag = false;
                    default:
                        println(getString("input.error"));
                        break;
            }
        }
    }

    private void byProducts() {
    }

    private void findList() {
    }

    private void findOrderById() {
    }

    private void showProduct() {

        ClothesService clothesService = new ClothesServiceImpl();
        List<Clothes> list = clothesService.list();
        ConsoleTable t = new ConsoleTable(8, true);
        t.appendRow();   //一行
        t.appendColum("id")
                .appendColum("brand")
                .appendColum("style")
                .appendColum("color")
                .appendColum("size")
                .appendColum("num")
                .appendColum("price")
                .appendColum("description");
        for (Clothes c:list){
            t.appendRow();   //一列
            t.appendColum(c.getId())
                    .appendColum(c.getBrand())
                    .appendColum(c.getStyle())
                    .appendColum(c.getColor())
                    .appendColum(c.getSize())
                    .appendColum(c.getNum())
                    .appendColum(c.getPrice())
                    .appendColum(c.getDescription());
        }
        println(t.toString());
    }
}
