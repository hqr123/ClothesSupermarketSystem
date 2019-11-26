package com.vince.ui;

import com.vince.bean.Clothes;
import com.vince.bean.Order;
import com.vince.bean.OrderItem;
import com.vince.service.ClothesService;
import com.vince.service.OrderService;
import com.vince.service.impl.ClothesServiceImpl;
import com.vince.service.impl.OrderServiceImpl;
import com.vince.utils.BusinessException;
import com.vince.utils.ConsoleTable;
import com.vince.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class HomeClass extends BaseClass {

    private OrderService orderService = new OrderServiceImpl() ;
    private ClothesService clothesService = new ClothesServiceImpl();

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
                try {
                    byProducts();
                    flag = false;

                }catch (BusinessException e){
                    println(e.getMessage());
                }
                    break;
                case "0":
                    flag = false;
                    default:
                        println(getString("input.error"));
                        break;
            }
        }
    }

    /**
     * 购买商品的过程
     * @throws BusinessException
     */
    private void byProducts() throws BusinessException {
        //生成订单
        boolean flag = true;
        int count = 0;
        float sum = 0.0f;//订单的总金额
        Order order = new Order();
        while(flag){

            //1、接收用户输入
            println(getString("product.input.id"));
            String id = input.nextLine();
            println(getString("product.input.shoppingNum"));
            String shoppingNum = input.nextLine();
            OrderItem orderItem = new OrderItem();
            Clothes clothes = clothesService.findById(id);

            //2、判断是否有库存
            int num = Integer.parseInt(shoppingNum);
            if (num>clothes.getNum()){
                throw  new BusinessException("product.num.error");
            }

            //3、一条生成订单编号
            clothes.setNum(clothes.getNum()-num); //减去库存
            orderItem.setClothes(clothes);  //商品
            orderItem.setShooppingNum(num);//商品数量
            orderItem.setSum(clothes.getPrice()*num);//每个订单的金额
            sum +=orderItem.getSum();       //总金额
            orderItem.setItemId(count++);   //订单ID
            order.getOrderItemList().add(orderItem);//添加到订单列表

            println(getString("product.buy.continue"));
            String isBuy = input.nextLine();
            switch (isBuy){
                case "1":
                    flag = true;
                    break;
                case "2":
                    flag = false;
                    break;
                default:
                    flag = false;
                    break;
            }
        }
            order.setCreateDate(DateUtils.toDate(new Date()));
            order.setUserId(currUser.getId());
            order.getSum(sum);
            order.setUserId(orderService.list().size()+1);

            orderService.buyProduct(order);
            clothesService.update();//更新一下数据
            showProduct();//重新显示数据


    }

    private void findList() {
    }

    private void findOrderById() {
    }

    private void showProduct() {

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
