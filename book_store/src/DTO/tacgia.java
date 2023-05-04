package DTO;

import java.net.PortUnreachableException;

public class tacgia {
  private int maTacgia;
  private String tenTacgia;
  private int trangThai;

  public int getMaTacgia() {
    return maTacgia;
  }

  public void setMaTacgia(int maTacgia) {
    this.maTacgia = maTacgia;
  }

  public String getTenTacgia() {
    return tenTacgia;
  }

  public void setTenTacgia(String tenTacgia) {
    this.tenTacgia = tenTacgia;
  }

  public int getTrangThai() {
    return trangThai;
  }

  public void setTrangThai(int trangthai) {
    this.trangThai = trangthai;
  }

  public String toString() {
    return this.maTacgia + "-" + this.tenTacgia;
  }

}
