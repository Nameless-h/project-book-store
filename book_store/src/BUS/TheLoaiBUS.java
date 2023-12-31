package BUS;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import DAO.TheLoaiDAO;
import DTO.NhaXuatBan;
import DTO.Theloai;

public class TheLoaiBUS {
  TheLoaiDAO tLoaiDAO = new TheLoaiDAO();
  private ArrayList<Theloai> theloai_list;

  public TheLoaiBUS() {
    theloai_list = tLoaiDAO.selecAll();
  }

  public ArrayList<Theloai> getDanhSachTheLoai() {
    return this.theloai_list;
  }

  public void listTheLoai() {
    theloai_list.clear();
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

  public ArrayList<Theloai> searchTheLoai(String maTheloai, String tenTheloai) {
    ArrayList<Theloai> resultList = new ArrayList<Theloai>();
    for (Theloai tmp : theloai_list) {
      if ((maTheloai.equalsIgnoreCase("") || String.valueOf(tmp.getMaTheloai()).contains(maTheloai))
          && (tenTheloai.equalsIgnoreCase("") || tmp.getTenTheloai().contains(tenTheloai.toLowerCase()))) {
        resultList.add(tmp);
      }
    }
    return resultList;
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
