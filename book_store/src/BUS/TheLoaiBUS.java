package BUS;

import java.util.ArrayList;

import DAO.TheLoaiDAO;
import DTO.Theloai;

public class TheLoaiBUS {
  private ArrayList<Theloai> theloai_list;
  TheLoaiDAO tLoaiDAO = new TheLoaiDAO();

  public TheLoaiBUS() {

  }

  public ArrayList<Theloai> getDanhSachTheLoai() {
    return this.theloai_list;
  }

  public void listTheLoai() {
    theloai_list = new ArrayList<Theloai>();
    theloai_list = tLoaiDAO.selecAll();
  }

  public void addTheLoai(Theloai bk) {
    tLoaiDAO.insert(bk);
    bk.setMaTheloai(tLoaiDAO.getLastInsertId());
    theloai_list.add(bk);
  }

  public void delTheLoai(Theloai bk) {
    for (Theloai tmp : this.theloai_list) {
      if (tmp.getMaTheloai() == bk.getMaTheloai()) {
        theloai_list.remove(tmp);
        break;
      }
    }
    tLoaiDAO.delete(bk);
  }

  public void editTheLoai(Theloai TheloaiTmp) {
    tLoaiDAO.update(TheloaiTmp);
    for (int i = 0; i < theloai_list.size(); i++) {
      if (theloai_list.get(i).getMaTheloai() == TheloaiTmp.getMaTheloai()) {
        theloai_list.get(i).setTenTheloai(TheloaiTmp.getTenTheloai());
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
    return new Theloai(0, "Không thuộc thể loại cụ thể");
  }
}
