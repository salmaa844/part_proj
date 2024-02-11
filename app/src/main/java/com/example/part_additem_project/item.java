package com.example.part_additem_project;

public class item {
    private String name;
    private String discreption;
    private String price;
    private String quantity;
    private String category;

    public item(){
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscreption() {
        return discreption;
    }

    public void setDiscreption(String discreption) {
        this.discreption = discreption;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public item(String name, String discreption, String price, String quantity, String category){
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
