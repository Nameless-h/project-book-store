/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.bills;

/**
 *
 * @author ADMIN
 */
public class bill {
    private int bill_id;
    private int emp_id;
    private String date;

    public bill(int bill_id, int emp_id, String date) {
        this.bill_id = bill_id;
        this.emp_id = emp_id;
        this.date = date;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBill_id() {
        return bill_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public String getDate() {
        return date;
    }

}
