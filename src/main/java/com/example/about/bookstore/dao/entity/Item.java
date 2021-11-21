package com.example.about.bookstore.dao.entity;

public class Item {
    private BookEntity bookEntity;
    private int quantity;
    private Item[] item;

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item(BookEntity bookEntity, int quantity) {
        this.bookEntity = bookEntity;
        this.quantity = quantity;
    }
//
//    public Item() {
//    }
//        public Double getTotalPrice() {
//        Double sum = 0.0;
//        for(Item item : this.item) {
//            sum = sum + item.getBookEntity().getBookPrice()*item.getQuantity();
//        }
//        return sum;
//    }
}
