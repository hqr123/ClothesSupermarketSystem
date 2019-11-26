package com.vince.bean;

import com.vince.utils.OrderStatusType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
   private int orderId;
   private List<OrderItem> orderItemList = new ArrayList<> ();
   private String createDate;  //创建的时间
   private float sum;
   private OrderStatusType status = OrderStatusType.UNPAID;//狀態
   private int userId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public float getSum(float sum) {
        return this.sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Order(int orderId, List<OrderItem> orderItemList, String createDate, float sum, OrderStatusType status, int userId) {
        this.orderId = orderId;
        this.orderItemList = orderItemList;
        this.createDate = createDate;
        this.sum = sum;
        this.status = status;
        this.userId = userId;
    }

    public Order() {
    }
}
