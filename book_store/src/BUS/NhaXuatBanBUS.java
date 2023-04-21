package BUS;

import java.util.ArrayList;

import DAO.NhaXuatBanDAO;
import DTO.NhaXuatBan;

public class NhaXuatBanBUS {
  private ArrayList<NhaXuatBan> NhaXuatBan_list;
  NhaXuatBanDAO NhaXuatBanDAO = new NhaXuatBanDAO();

  public NhaXuatBanBUS() {

  }

  public ArrayList<NhaXuatBan> getDanhSachNhaXuatBan() {
    return this.NhaXuatBan_list;
  }

  public void listNhaXuatBan() {
    NhaXuatBan_list = new ArrayList<NhaXuatBan>();
    NhaXuatBan_list = NhaXuatBanDAO.selecAll();
  }

  public void addNhaXuatBan(NhaXuatBan bk) {
    NhaXuatBanDAO.insert(bk);
    NhaXuatBan_list.add(bk);
  }

  public void delNhaXuatBan(NhaXuatBan bk) {
    NhaXuatBan_list.remove(bk);
    NhaXuatBanDAO.delete(bk);
  }

  public void editNhaXuatBan(NhaXuatBan NhaXuatBanTmp) {
    NhaXuatBanDAO.update(NhaXuatBanTmp);
    for (NhaXuatBan tmp : this.NhaXuatBan_list) {
      if (tmp.getMaNXB() == NhaXuatBanTmp.getMaNXB()) {
        delNhaXuatBan(tmp);
        NhaXuatBan_list.add(NhaXuatBanTmp);
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
    return null;
  }
}
