package tester;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import BUS.quanlichitietnhomquyen;
import BUS.quanlichucnang;
import DAO.chitietnhomquyenDAO;
import DAO.chucnangDAO;
import DAO.khachhangDAO;
import DAO.nhanvienDAO;
import DAO.nhomquyenDAO;
import DAO.taikhoanDAO;
import DTO.chitietnhomquyen;
import DTO.chucnang;
import DTO.khachhang;
import DTO.nhanvien;
import DTO.nhomquyen;
import DTO.taikhoan;
public class test12 {
    public static void main(String[] args ){
        // nhomquyenDAO chucnang_taikhoan=new nhomquyenDAO();
        // ArrayList<nhomquyen> list=chucnang_taikhoan.selecAll();
        // System.out.println(list);
        // nhanvienDAO chucnang=new nhanvienDAO();
        // ArrayList<nhanvien> list=chucnang.selecAll();
        // System.out.println(list);
        // quanlichucnang chucnang=new quanlichucnang();
        // ArrayList<chucnang> list=chucnang.danhsachchucnang();
        // System.out.println(list.toString());
        // quanlichitietnhomquyen chucnang=new quanlichitietnhomquyen();
        // ArrayList<chitietnhomquyen> list=chucnang.danhsachchitietnhomquyen();
        // System.out.println(list.toString());
        // quanlichitietnhomquyen chucnang=new quanlichitietnhomquyen();
        // ArrayList<chitietnhomquyen> list=chucnang.danhsachchitietnhomquyen();
        // System.out.println(list.toString());
        // chitietnhomquyenDAO chucnang=new chitietnhomquyenDAO();
        // quanlichitietnhomquyen quanlichitietnhomquyen=new quanlichitietnhomquyen();
        // ArrayList<chitietnhomquyen> list = quanlichitietnhomquyen.danhsachchitietnhomquyen_id(2);
        // for(int i=0;i<list.size();i++)
        //     System.out.println(list.get(i));
        khachhangDAO chucnang=new khachhangDAO();
        ArrayList<khachhang> list=chucnang.selecAll();
         for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}
