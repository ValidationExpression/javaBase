package com.example.text01;

public class Car {
    private String broad;
    private int price;
    private String color;

    public Car() {
    }

    public Car(String broad, int price, String color) {
        this.broad = broad;
        this.price = price;
        this.color = color;
    }

    public String getBroad() {
        return broad;
    }

    public void setBroad(String broad) {
        this.broad = broad;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
