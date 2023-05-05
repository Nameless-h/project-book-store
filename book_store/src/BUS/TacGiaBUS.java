package BUS;

import java.util.ArrayList;

import DAO.TacGiaDAO;
import DTO.Sach;
import DTO.tacgia;

public class TacGiaBUS {
  private ArrayList<tacgia> Tacgia_list;
  TacGiaDAO tacgiaDAO = new TacGiaDAO();

  public TacGiaBUS() {

  }

  public ArrayList<tacgia> getDanhSachTacGia() {
    return this.Tacgia_list;
  }

  public void listTacGia() {
    Tacgia_list = new ArrayList<tacgia>();
    Tacgia_list = tacgiaDAO.selecAll();
  }

  public void addTacGia(tacgia bk) {
    tacgiaDAO.insert(bk);
    bk.setMaTacgia(tacgiaDAO.getLastInsertId());
    Tacgia_list.add(bk);
  }

  public void delTacGia(tacgia bk) {
    for (tacgia tmp : this.Tacgia_list) {
      if (tmp.getMaTacgia() == bk.getMaTacgia()) {
        Tacgia_list.remove(tmp);
        break;
      }
    }
    tacgiaDAO.delete(bk);
  }

  public void editTacGia(tacgia tacgiaTmp) {
    tacgiaDAO.update(tacgiaTmp);
    for (int i = 0; i < Tacgia_list.size(); i++) {
      if (Tacgia_list.get(i).getMaTacgia() == tacgiaTmp.getMaTacgia()) {
        Tacgia_list.get(i).setTenTacgia(tacgiaTmp.getTenTacgia());
        return;
      }
    }
  }

  public tacgia timTacgiaTheoMa(int ma) {
    for (tacgia tltmp : this.Tacgia_list) {
      if (tltmp.getMaTacgia() == ma) {
        return tltmp;
      }
    }
    return null;
  }

  public tacgia timTacgiaTheoMaSach(int maSach) {
    tacgia tmp = tacgiaDAO.selectById(maSach);
    return tmp;
  }

  public ArrayList<tacgia> searchtacgia(String matacgia, String tentacgia) {
    ArrayList<tacgia> resultList = new ArrayList<tacgia>();
    for (tacgia tmp : Tacgia_list) {
      if ((matacgia.equalsIgnoreCase("") || String.valueOf(tmp.getMaTacgia()).contains(matacgia))
          && (tentacgia.equalsIgnoreCase("") || tmp.getTenTacgia().contains(tentacgia.toLowerCase()))) {
        resultList.add(tmp);
      }
    }
    return resultList;
  }
}
