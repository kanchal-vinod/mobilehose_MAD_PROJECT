package com.example.mobilehousecard;

public class Item {

    String itemName;
    String itemPrice;
    String itemNote;
    String image;

    public Item() {
    }

    public Item(String itemName, String itemPrice, String itemNote,String image) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemNote = itemNote;
        this.image=image;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemNote() {
        return itemNote;
    }

    public void setItemNote(String itemNote) {
        this.itemNote = itemNote;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
