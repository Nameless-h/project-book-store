package BUS;

import java.security.PublicKey;
import java.util.ArrayList;

import DAO.SanPhamDAO;
import DTO.Sach;

public class SanPhamBUS {
  private ArrayList<Sach> product_list;
  SanPhamDAO spdao = new SanPhamDAO();

  public ArrayList<Sach> getDanhSachSanPham() {
    return this.product_list;
  }

  public void listSanPham() {
    product_list = new ArrayList<Sach>();
    product_list = spdao.selecAll();
  }

  public void addSanPham(Sach bk) {
    spdao.insert(bk);
    bk.setMaSach(spdao.getLastInsertId());
    product_list.add(bk);
  }

  public void delSanPham(Sach bk) {
    for (Sach tmp : this.product_list) {
      if (tmp.getMaSach() == bk.getMaSach()) {
        product_list.remove(tmp);
        break;
      }
    }
    spdao.delete(bk);
  }

  public void editSanPham(Sach sachTmp) {
    spdao.update(sachTmp);
    for (int i = 0; i < product_list.size(); i++) {
      if (product_list.get(i).getMaSach() == sachTmp.getMaSach()) {
        product_list.get(i).setTenSach(sachTmp.getTenSach());
        product_list.get(i).setMaNXB(sachTmp.getMaNXB());
        product_list.get(i).setMaTheloai(sachTmp.getMaTheloai());
        product_list.get(i).setNamXB(sachTmp.getNamXB());
        product_list.get(i).setSoLuong(sachTmp.getSoLuong());
        product_list.get(i).setGiaTien(sachTmp.getGiaTien());
        return;
      }
    }
  }

  public Sach timSachTheoMa(int ma) {
    for (Sach sachtmp : this.product_list) {
      if (sachtmp.getMaSach() == ma) {
        return sachtmp;
      }
    }
    return null;
  }

  public int getLastInsertId() {
    return spdao.getLastInsertId();
  }

  public Sach getBook(int masach) {
    for (Sach b : this.product_list) {
      if (b.getMaSach() == masach) {
        return b;
      }
    }
    return null;
  }

  public ArrayList<Sach> searchBooks(String query) {
    ArrayList<Sach> resultList = new ArrayList<Sach>();
    this.product_list.forEach((book) -> {
      if (String.valueOf(book.getMaSach()).contains(query)
          || book.getTenSach().toLowerCase().contains(query.toLowerCase())) {
        resultList.add(book);
      }
    });
    return resultList;
  }

  public void updateSoLuong(int masach, int soluongdaban) {
    for (Sach s : this.product_list) {
      if (s.getMaSach() == masach) {
        s.setSoLuong(s.getSoLuong() - soluongdaban);
        spdao.update(s);
        break;
      }
    }
  }
}
