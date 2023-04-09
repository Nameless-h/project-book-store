/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
import user.user_login;
import DAO.user_loginDAO;
import java.awt.List;
import java.util.ArrayList;
import user.user_function;
public class user_model {
    user_loginDAO chucnang_user_login=new user_loginDAO();
    
    
    
    
    
    
//kiem tra co tai khoan dang nhap hay ko (tra ve tai khoan neu co)
    public user_login check_login(user_login user){
        ArrayList<user_login> list=chucnang_user_login.selecAll();
        for(int i=0;i<list.size();i++)
            if((user.getUsername().equalsIgnoreCase(list.get(i).getUsername()))&&
                (user.getPassword().equalsIgnoreCase(list.get(i).getPassword())))
            return list.get(i);
        return null;
    }
//ham sinh ma khach hang ngau nhien
    public String spawn_matk(){
        //lay toan bo tai khoan tring database
        ArrayList<user_login> list=chucnang_user_login.selecAll();
        int code;
        String s = null;
        //ham tao so ngau nhien tu 1000 toi 8999
        code = (int) Math.floor(((Math.random() * 8999) + 1000));
        //kiem tra matk co ton tai hay chua
        for(int i=0;i<list.size();i++)
            {
                s = "kh"+String.valueOf(code);
                if(list.get(i).getMatk().equals(s))
                {
                    code = (int) Math.floor(((Math.random() * 8999) + 1000));
                    i=0;
                }
            }
        return s;
    }
//them tai khoan vao database
    public void add_user(user_login user){
        chucnang_user_login.insert(user);
    }
//kiem tra username co ton tai hay ko
    public boolean check_username(String username){
        ArrayList<user_login> list=chucnang_user_login.selecAll();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getUsername().equalsIgnoreCase(username))
                return false;
        }
        return true;
    }
//kiem tra email da ton tai hay chua
    public boolean check_email(String email){
         ArrayList<user_login> list=chucnang_user_login.selecAll();
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).getEmail().equalsIgnoreCase(email))
                    return false;
            }
            return true;
    }
//tra ve chuc nang cua tk
    public ArrayList<String> user_fun(user_function user){
        ArrayList<String> list = new ArrayList<String>();
        if(user.getAdministrator().equalsIgnoreCase("1"))
            list.add("Quản lí tài khoản");
        if(user.getCustomer().equalsIgnoreCase("1"))
        {
            list.add("Mua hàng");
            list.add("Giỏ hàng");
            list.add("Lịch sử mua hàng");
        }
        if(user.getStatistical().equalsIgnoreCase("1"))
            list.add("Thống kê");
        if(user.getImport_assistant().equalsIgnoreCase("1"))
            list.add("Nhập hàng");
        if(user.getShop_assistant().equalsIgnoreCase("1"))
            list.add("Bán hàng");
//        list.add("Thông tin cá nhân");
        return list;
    }
}
