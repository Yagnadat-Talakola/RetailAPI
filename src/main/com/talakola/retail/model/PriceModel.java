package com.talakola.retail.model;

import org.springframework.stereotype.Component;

@Component
public class PriceModel {

    private int id;
    private float price;

    public PriceModel(int id, float price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceModel{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
