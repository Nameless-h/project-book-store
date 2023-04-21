package BUS;

import java.util.ArrayList;

import DAO.chucnangDAO;
import DTO.chucnang;

public class quanlichucnang {
    chucnangDAO chucnang=new chucnangDAO();
    ArrayList<chucnang> list=chucnang.selecAll();
    public ArrayList<chucnang> danhsachchucnang(){
        return list;
    }
}
