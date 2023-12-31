package BUS;

import java.util.ArrayList;

import DAO.TacGiaDAO;
import DTO.ChiTietTacGia;
import DTO.ChiTietTacGia;
import DTO.Sach;
import DTO.tacgia;

public class TacGiaBUS {
  TacGiaDAO tacgiaDAO = new TacGiaDAO();
  private ArrayList<tacgia> Tacgia_list;
  ChiTietTacGiaBUS qlcttg = new ChiTietTacGiaBUS();

  public TacGiaBUS() {
    Tacgia_list = tacgiaDAO.selecAll();
  }

  public ArrayList<tacgia> getDanhSachTacGia() {
    return this.Tacgia_list;
  }

  public void listTacGia() {
    Tacgia_list.clear();
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

  public String timTacgiaTheoMaSach(int maSach) {
    /*
     * tacgia tmp = tacgiaDAO.selectById(maSach);
     * return tmp;
     */
    String names = "";
    tacgia t;
    qlcttg.listChiTietTacGia();
    for (ChiTietTacGia cttg : qlcttg.getDanhSachChiTietTacGia()) {
      if (cttg.getMaSach() == maSach) {
        t = timTacgiaTheoMa(cttg.getMaTacgia());
        names += t.getTenTacgia() + ",";
      }
    }
    return names;
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
