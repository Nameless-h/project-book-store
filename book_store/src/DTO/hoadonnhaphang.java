/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class hoadonnhaphang extends hoadon {
    private int publisher_id;

    public hoadonnhaphang(int publisher_id, int bill_id, int emp_id, String date ,double tongtien) {
        super(bill_id, emp_id, date,tongtien);
        this.publisher_id = publisher_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

}
