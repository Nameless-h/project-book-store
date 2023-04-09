/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author ASUS
 */
public class user_function {
    String matk,administrator,customer,shop_assistant,statistical,import_assistant;

    public user_function() {
    }

    public user_function(String matk, String administrator, String customer, String shop_assistant, String statistical, String import_assistant) {
        this.matk = matk;
        this.administrator = administrator;
        this.customer = customer;
        this.shop_assistant = shop_assistant;
        this.statistical = statistical;
        this.import_assistant = import_assistant;
    }

    public String getMatk() {
        return matk;
    }

    public void setMatk(String matk) {
        this.matk = matk;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String adminnistator) {
        this.administrator = adminnistator;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getShop_assistant() {
        return shop_assistant;
    }

    public void setShop_assistant(String shop_assistant) {
        this.shop_assistant = shop_assistant;
    }

    public String getStatistical() {
        return statistical;
    }

    public void setStatistical(String statistical) {
        this.statistical = statistical;
    }

    public String getImport_assistant() {
        return import_assistant;
    }

    public void setImport_assistant(String import_assistant) {
        this.import_assistant = import_assistant;
    }

    @Override
    public String toString() {
        return "user_function{" + "matk=" + matk + ", adminnistator=" + administrator + ", customer=" + customer + ", shop_assistant=" + shop_assistant + ", statistical=" + statistical + ", import_assistant=" + import_assistant + '}';
    }
    
}
