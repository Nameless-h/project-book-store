package tester;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import DAO.taikhoanDAO;
import nameclass.taikhoan;
public class test12 {
    public static void main(String[] args ){
        taikhoanDAO chucnang_taikhoan=new taikhoanDAO();
        ArrayList<taikhoan> list=chucnang_taikhoan.selecAll();
        System.out.println(list);
    }
}
