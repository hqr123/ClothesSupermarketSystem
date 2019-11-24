package com.vince.bean;

public class OrderItem {
    private int itemId;
    private Clothes clothes;//商品
    private int shooppingNum; //购买数量
    private float sum; //购买金额

    public OrderItem(int itemId, Clothes clothes, int shooppingNum, float sum) {
        this.itemId = itemId;
        this.clothes = clothes;
        this.shooppingNum = shooppingNum;
        this.sum = sum;
    }

    public OrderItem() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getShooppingNum() {
        return shooppingNum;
    }

    public void setShooppingNum(int shooppingNum) {
        this.shooppingNum = shooppingNum;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
}
