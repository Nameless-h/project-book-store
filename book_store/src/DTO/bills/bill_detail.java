/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.bills;

/**
 *
 * @author ADMIN
 */
public class bill_detail {
    private int bill_id;
    private int book_id;
    private int price;
    private int quantity;

    public bill_detail(int bill_id, int book_id, int price, int quantity) {
        this.bill_id = bill_id;
        this.book_id = book_id;
        this.price = price;
        this.quantity = quantity;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
