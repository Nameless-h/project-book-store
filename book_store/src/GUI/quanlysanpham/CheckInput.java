package GUI.quanlysanpham;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;

import DTO.NhaXuatBan;

public class CheckInput {
  public boolean checkTen(String tenSach) {
    if (tenSach.equalsIgnoreCase("")) {
      return false;
    }
    return true;
  }

  public boolean checkNamXuatBan(String namxb) {
    if (namxb.equalsIgnoreCase("")) {
      return false;
    } else if (namxb.length() >= 5) {
      return false;
    } else {
      Pattern pattern = Pattern.compile("\\D");
      Matcher matcher = pattern.matcher(namxb);
      if (matcher.find()) {
        return false;
      } else {
        LocalDate now = LocalDate.now();
        if (Integer.parseInt(namxb) > now.getYear()) {
          return false;
        }
      }
      return true;
    }
  }

  public boolean checkGiaTien(String giaTien) {
    if (giaTien.equalsIgnoreCase("")) {
      return false;
    } else {
      Pattern pattern = Pattern.compile("\\D");
      Matcher matcher = pattern.matcher(giaTien);
      if (matcher.find()) {
        return false;
      }
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

  public boolean checkHotLine(String phone) {
    if (phone.equalsIgnoreCase("")) {
      return false;
    } else {
      String emailRegex = "0+[0-9]{7,9}";
      Pattern pattern = Pattern.compile(emailRegex);

      Matcher matcher = pattern.matcher(phone);
      if (!matcher.matches()) {
        return false;
      }
    }
    return true;
  }

  public boolean checkHotMail(String mail) {
    if (mail.equalsIgnoreCase("")) {
      return false;
    } else {
      String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
      Pattern pattern = Pattern.compile(emailRegex);

      Matcher matcher = pattern.matcher(mail);
      if (!matcher.matches()) {
        return false;
      }
    }
    return true;
  }

  public boolean checkHotMailTrung(String mail, int maNxb) {

    for (NhaXuatBan tmp : bookFrame.nxbBUS.getDanhSachNhaXuatBan()) {
      if (tmp.getEmail().equals(mail) && tmp.getMaNXB() != maNxb) {
        return false;
      }
    }
    return true;
  }

  public boolean checkDiaChi(String diaChi) {
    if (diaChi.equalsIgnoreCase("")) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    CheckInput chk = new CheckInput();
    System.out.println(chk.checkHotLine("09767989"));

  }
}
