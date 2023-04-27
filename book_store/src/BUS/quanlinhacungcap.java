package BUS;

import java.util.ArrayList;

import DAO.nhacungcapDAO;
import DTO.nhacungcap;

public class quanlinhacungcap {
    nhacungcapDAO nccdao = new nhacungcapDAO();
    ArrayList<nhacungcap> listncc = new ArrayList<nhacungcap>();

    public void initList() {
        this.listncc = nccdao.list();
    }

    public ArrayList<nhacungcap> getList() {
        return this.listncc;
    }

    public ArrayList<nhacungcap> searchNCC(String query) {
        ArrayList<nhacungcap> resultList = new ArrayList<nhacungcap>();
        listncc.forEach((ncc) -> {
            if( String.valueOf(ncc.getMa()).contains(query) || 
                ncc.getTen().toLowerCase().contains(query.toLowerCase()) || 
                ncc.getEmail().toLowerCase().contains(query.toLowerCase()) ||
                ncc.getSDT().contains(query)) {
                    resultList.add(ncc);
                }
        });
        return resultList;
    }

    public nhacungcap getNCC(int ma) {
        for(nhacungcap ncc : listncc) {
            if(ncc.getMa() == ma) {
                return ncc;
            }
        }
        return null;
    }
}
