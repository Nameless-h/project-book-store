package BUS;

import java.security.PublicKey;
import java.util.ArrayList;

import DAO.ChiTietTacGiaDAO;
import DAO.chitietnhomquyenDAO;
import DTO.ChiTietTacGia;

public class ChiTietTacGiaBUS {
  private ArrayList<ChiTietTacGia> tg_detail;
  ChiTietTacGiaDAO cttgdao = new ChiTietTacGiaDAO();

  public ArrayList<ChiTietTacGia> getDanhSachChiTietTacGia() {
    return this.tg_detail;
  }

  public void listChiTietTacGia() {
    tg_detail = new ArrayList<>();
    tg_detail = cttgdao.selecAll();
  }

  public void addChiTietTacGia(ChiTietTacGia bk) {
    cttgdao.insert(bk);
    tg_detail.add(bk);
  }

  public void delChiTietTacGia(ChiTietTacGia bk) {
    tg_detail.remove(bk);
    cttgdao.delete(bk);
  }

  public void delAllCTTGCoMaSach(int maSach) {
    for (ChiTietTacGia tmp : tg_detail) {
      if (tmp.getMaSach() == maSach) {
        tg_detail.remove(tmp);
      }
    }
    cttgdao.deleteByMaSach(maSach);
  }

  public void delAllCTTGCoMaTg(int maTg) {
    for (ChiTietTacGia tmp : tg_detail) {
      if (tmp.getMaTacgia() == maTg) {
        tg_detail.remove(tmp);
      }
    }
    cttgdao.deleteByMaTacGia(maTg);
  }

  public void editChiTietTacGia(ChiTietTacGia ChiTietTacGiaTmp) {
    cttgdao.update(ChiTietTacGiaTmp);
    for (ChiTietTacGia tmp : this.tg_detail) {
      if (tmp.getMaSach() == ChiTietTacGiaTmp.getMaSach()) {
        delChiTietTacGia(tmp);
        tg_detail.add(ChiTietTacGiaTmp);
        return;
      }
    }
  }

  public ArrayList<Integer> timTacGiaTheoMaSach(int maSach) {
    ArrayList<Integer> dstg = new ArrayList<Integer>();
    for (ChiTietTacGia ChiTietTacGiatmp : this.tg_detail) {
      if (ChiTietTacGiatmp.getMaSach() == maSach) {
        dstg.add(ChiTietTacGiatmp.getMaTacgia());
      }
    }
    return dstg;
  }

  public ArrayList<Integer> timSachTheoMaTacGia(int maTacgia) {
    ArrayList<Integer> dssach = new ArrayList<Integer>();
    for (ChiTietTacGia ChiTietTacGiatmp : this.tg_detail) {
      if (ChiTietTacGiatmp.getMaTacgia() == maTacgia) {
        dssach.add(ChiTietTacGiatmp.getMaTacgia());
      }
    }
    return dssach;
  }

}
