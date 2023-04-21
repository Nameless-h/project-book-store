package BUS;

import java.security.PublicKey;
import java.util.ArrayList;

import DAO.SanPhamDAO;
import DTO.Sach;

public class SanPhamBUS {
  private ArrayList<Sach> product_list;
  SanPhamDAO spdao = new SanPhamDAO();

  public SanPhamBUS() {

  }

  public ArrayList<Sach> getDanhSachSanPham() {
    return this.product_list;
  }

  public void listSanPham() {
    product_list = new ArrayList<>();
    product_list = spdao.selecAll();
  }

  public void addSanPham(Sach bk) {
    spdao.insert(bk);
    product_list.add(bk);
  }

  public void delSanPham(Sach bk) {
    product_list.remove(bk);
    spdao.delete(bk);
  }

  public void editSanPham(Sach sachTmp) {
    spdao.update(sachTmp);
    for (Sach tmp : this.product_list) {
      if (tmp.getMaSach() == sachTmp.getMaSach()) {
        delSanPham(tmp);
        product_list.add(sachTmp);
        return;
      }
    }
  }

  public Sach timTheLoaiTheoMa(int ma) {
    for (Sach sachtmp : this.product_list) {
      if (sachtmp.getMaTheloai() == ma) {
        return sachtmp;
      }
    }
    return null;
  }

}
