package BUS;

import java.util.ArrayList;

import DAO.chitietnhomquyenDAO;
import DTO.chitietnhomquyen;

public class quanlichitietnhomquyen {
    chitietnhomquyenDAO chucnang = new chitietnhomquyenDAO();
    ArrayList<chitietnhomquyen> list = chucnang.selecAll();

    public ArrayList<chitietnhomquyen> danhsachchitietnhomquyen() {
        return list;
    }
    public ArrayList<chitietnhomquyen> danhsachchitietnhomquyen_id(int id) {
        ArrayList<chitietnhomquyen> list1 = chucnang.select_all_ById(id);
        return list1;
    }
    public void themchitietnhomquyen(int id,ArrayList<chitietnhomquyen> list_them) {
        for(int i=0;i<list_them.size();i++){
            chitietnhomquyen ct=new chitietnhomquyen(id, list_them.get(i).getMachucnang(),list_them.get(i).getHanhdong(), list_them.get(i).getTinhtrang());
            chucnang.insert(ct);
        }
    }
    public void suachitietnhomquyen(ArrayList<chitietnhomquyen> list_them){
        for(int i=0;i<list_them.size();i++){
            chucnang.update(list_them.get(i));
        }
    }
    
}
