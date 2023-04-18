/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class import_bill extends bill {
    private int publisher_id;

    public import_bill(int publisher_id, int bill_id, int emp_id, String date) {
        super(bill_id, emp_id, date);
        this.publisher_id = publisher_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

}
