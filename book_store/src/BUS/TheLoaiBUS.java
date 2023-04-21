package BUS;

import java.util.ArrayList;

import DAO.TheLoaiDAO;
import DTO.Theloai;

public class TheLoaiBUS {
  private ArrayList<Theloai> theloai_list;
  TheLoaiDAO tLoaiDAO = new TheLoaiDAO();

  public TheLoaiBUS() {

  }

  public ArrayList<Theloai> getDanhTheloaiTheLoai() {
    return this.theloai_list;
  }

  public void listTheLoai() {
    theloai_list = new ArrayList<Theloai>();
    theloai_list = tLoaiDAO.selecAll();
  }

  public void addTheLoai(Theloai bk) {
    tLoaiDAO.insert(bk);
    theloai_list.add(bk);
  }

  public void delTheLoai(Theloai bk) {
    theloai_list.remove(bk);
    tLoaiDAO.delete(bk);
  }

  public void editTheLoai(Theloai TheloaiTmp) {
    tLoaiDAO.update(TheloaiTmp);
    for (Theloai tmp : this.theloai_list) {
      if (tmp.getMaTheloai() == TheloaiTmp.getMaTheloai()) {
        delTheLoai(tmp);
        theloai_list.add(TheloaiTmp);
        return;
      }
    }
  }

  public Theloai timTheLoaiTheoMa(int ma) {
    for (Theloai tltmp : this.theloai_list) {
      if (tltmp.getMaTheloai() == ma) {
        return tltmp;
      }
    }
    return null;
  }
}
