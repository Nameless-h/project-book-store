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
    Tacgia_list.add(bk);
  }

  public void delTacGia(tacgia bk) {
    Tacgia_list.remove(bk);
    tacgiaDAO.delete(bk);
  }

  public void editTacGia(tacgia TacgiaTmp) {
    tacgiaDAO.update(TacgiaTmp);
    for (tacgia tmp : this.Tacgia_list) {
      if (tmp.getMaTacgia() == TacgiaTmp.getMaTacgia()) {
        delTacGia(tmp);
        Tacgia_list.add(TacgiaTmp);
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
}
