package BUS;

import java.security.PublicKey;
import java.util.ArrayList;

import DAO.SanPhamDAO;
import DTO.ChiTietTacGia;
import DTO.Sach;

public class SanPhamBUS {
  SanPhamDAO spdao = new SanPhamDAO();
  private ArrayList<Sach> product_list;

  public SanPhamBUS() {
    product_list = spdao.selecAll();
  }

  public ArrayList<Sach> getDanhSachSanPham() {
    return this.product_list;
  }

  public void listSanPham() {
    product_list.clear();
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

  public ArrayList<Sach> searchBooks(String maSach, String tenSach, int maTacgia, int maTheloai, int maNhaXuatBan) {
    ArrayList<Sach> resultList = new ArrayList<Sach>();
    ChiTietTacGiaBUS cttg = new ChiTietTacGiaBUS();
    cttg.listChiTietTacGia();
    for (Sach tmp : this.product_list) {
      if (maTacgia == 0 && maTheloai == 0 && maNhaXuatBan == 0
          && (tenSach.equalsIgnoreCase("") || tmp.getTenSach().toLowerCase().contains(tenSach.toLowerCase()))
          && (maSach.equalsIgnoreCase("") || String.valueOf(tmp.getMaSach()).matches(maSach))) {
        resultList.add(tmp);
        continue;
      }
      if ((tenSach.equalsIgnoreCase("") || tmp.getTenSach().toLowerCase().contains(tenSach.toLowerCase()))
          && (maSach.equalsIgnoreCase("") || String.valueOf(tmp.getMaSach()).contains(maSach.toLowerCase()))
          && (maTheloai == 0 || tmp.getMaTheloai() == maTheloai)
          && (maNhaXuatBan == 0 || tmp.getMaNXB() == maNhaXuatBan)) {
        if (maTacgia != 0) {
          for (ChiTietTacGia cttgTmp : cttg.getDanhSachChiTietTacGia()) {
            if ((cttgTmp.getMaTacgia() == maTacgia) && (tmp.getMaSach() == cttgTmp.getMaSach())) {
              resultList.add(tmp);
            }
          }
        } else {
          resultList.add(tmp);
        }
      }
    }
    return resultList;
  }

  public void updateSoLuongBanHang(int masach, int soluongdaban) {
    for (Sach s : this.product_list) {
      if (s.getMaSach() == masach) {
        s.setSoLuong(s.getSoLuong() - soluongdaban);
        spdao.update(s);
        break;
      }
    }
  }

  public void updateSoLuongNhapHang(int masach, int soluongdanhap) {
    for (Sach s : this.product_list) {
      if (s.getMaSach() == masach) {
        s.setSoLuong(s.getSoLuong() + soluongdanhap);
        spdao.update(s);
        break;
      }
    }
  }
}
