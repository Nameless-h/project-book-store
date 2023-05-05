package BUS;

import java.util.ArrayList;

import DAO.NhaXuatBanDAO;
import DTO.NhaXuatBan;
import GUI.quanlysanpham.bookFrame;

public class NhaXuatBanBUS {
  private ArrayList<NhaXuatBan> NhaXuatBan_list;
  NhaXuatBanDAO NhaXuatBanDAO = new NhaXuatBanDAO();

  public ArrayList<NhaXuatBan> getDanhSachNhaXuatBan() {
    return this.NhaXuatBan_list;
  }

  public void listNhaXuatBan() {
    NhaXuatBan_list = new ArrayList<NhaXuatBan>();
    NhaXuatBan_list = NhaXuatBanDAO.selecAll();
  }

  public void addNhaXuatBan(NhaXuatBan bk) {
    NhaXuatBanDAO.insert(bk);
    bk.setMaNXB(NhaXuatBanDAO.getLastInsertId());
    NhaXuatBan_list.add(bk);
  }

  public void delNhaXuatBan(NhaXuatBan bk) {
    for (NhaXuatBan tmp : this.NhaXuatBan_list) {
      if (tmp.getMaNXB() == bk.getMaNXB()) {
        NhaXuatBan_list.remove(tmp);
        break;
      }
    }
    NhaXuatBanDAO.delete(bk);
  }

  public void editNhaXuatBan(NhaXuatBan NhaXuatBanTmp) {
    NhaXuatBanDAO.update(NhaXuatBanTmp);
    for (int i = 0; i < NhaXuatBan_list.size(); i++) {
      if (NhaXuatBan_list.get(i).getMaNXB() == NhaXuatBanTmp.getMaNXB()) {
        NhaXuatBan_list.get(i).setTenNXB(NhaXuatBanTmp.getTenNXB());
        NhaXuatBan_list.get(i).setEmail(NhaXuatBanTmp.getEmail());
        NhaXuatBan_list.get(i).setSdt(NhaXuatBanTmp.getSdt());
        NhaXuatBan_list.get(i).setDiaChi(NhaXuatBanTmp.getDiaChi());
        return;
      }
    }
  }

  public NhaXuatBan timNhaXuatBanTheoMa(int ma) {
    for (NhaXuatBan tltmp : this.NhaXuatBan_list) {
      if (tltmp.getMaNXB() == ma) {
        return tltmp;
      }
    }
    NhaXuatBan unknow = new NhaXuatBan();
    unknow.setMaNXB(0);
    return unknow;
  }

  public ArrayList<NhaXuatBan> searchNhaXuatBan(String maNhaXuatBan, String tenNhaXuatBan, String Hotmail,
      String Hotline, String Diachi) {
    ArrayList<NhaXuatBan> resultList = new ArrayList<NhaXuatBan>();
    for (NhaXuatBan tmp : this.NhaXuatBan_list) {
      if ((maNhaXuatBan.equalsIgnoreCase("") || String.valueOf(tmp.getMaNXB()).contains(maNhaXuatBan.toLowerCase()))
          && (tenNhaXuatBan.equalsIgnoreCase("") || tmp.getTenNXB().toLowerCase().contains(tenNhaXuatBan.toLowerCase()))
          && (Hotmail.equalsIgnoreCase("") || tmp.getEmail().toLowerCase().contains(Hotmail.toLowerCase()))
          && (Hotline.equalsIgnoreCase("") || tmp.getSdt().toLowerCase().contains(Hotline.toLowerCase()))
          && (Diachi.equalsIgnoreCase("") || tmp.getDiaChi().toLowerCase().contains(Diachi.toLowerCase()))) {
        resultList.add(tmp);
      }
    }
    return resultList;
  }
}