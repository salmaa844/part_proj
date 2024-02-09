package com.example.part_additem_project;

public class item {
    private String name;
    private String discreption;
    private String price;
    private String quantity;
    private String category;

    public item(){

    }
    public item(String name, String discreption, String price,String quantity,String category){
        this.name = name;
        this.discreption = discreption;
        this.price = price;
        this.quantity=quantity;
        this.category=category;
    }
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", discreption='" + discreption + '\'' +
                ", price='" + price + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}
