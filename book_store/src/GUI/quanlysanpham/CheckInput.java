package GUI.quanlysanpham;

import javax.swing.JCheckBox;

public class CheckInput {
  public boolean checkTenSach(String tenSach) {
    if (tenSach.equalsIgnoreCase("")) {
      return false;
    }
    return true;
  }

  public boolean checkNamXuatBan(String namxb) {
    if (namxb.equalsIgnoreCase("")) {
      return false;
    }
    return true;
  }

  public boolean checkGiaTien(String namXb) {
    if (namXb.equalsIgnoreCase("")) {
      return false;
    }
    return true;
  }

  public boolean checkSelectTacGia(JCheckBox[] list_chkbox) {
    for (JCheckBox chkboxTmp : list_chkbox) {
      if (chkboxTmp.isSelected()) {
        return true;
      }
    }
    return false;
  }
}
