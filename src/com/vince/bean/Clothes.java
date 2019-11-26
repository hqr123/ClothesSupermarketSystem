package com.vince.bean;

import java.io.Serializable;

public class Clothes implements Serializable{

    private String id;    //商品编号
    private String brand; //品牌
    private  String style;//款式
    private  String color;//颜色
    private  String size; //尺寸
    private int num;      //库存数量
    private float price;  //价格
    private String description; //描述

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getStyle() {
        return style;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public int getNum() {
        return num;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Clothes(String id, String brand, String style, String color, String size, int num, float price, String description) {
        this.id = id;
        this.brand = brand;
        this.style = style;
        this.color = color;
        this.size = size;
        this.num = num;
        this.price = price;
        this.description = description;
    }

    public Clothes() {
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", style='" + style + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
