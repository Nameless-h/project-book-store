package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;    

import DTO.SachBan;
import DTO.khachhang;
import DTO.nhanvien;
import DTO.sachNhap;

import java.sql.Statement;

public class thongKeSachDAO implements DAOinterface<SachBan> {
    public thongKeSachDAO() {
       
    }

    @Override
    public int delete_all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete_all'");
    }

    @Override
    public ArrayList<SachBan> selecAll() {
        // TODO Auto-generated method stub
         // TODO Auto-generated method stub
         ArrayList<SachBan> bsList = new ArrayList<SachBan>();

         java.sql.Connection conn = JDBCUtil.getConnection();
         Statement statement = null;
         try {
            String sql = "SELECT maSach,tenSach,giaTien,soLuong,tenTheLoai FROM book JOIN theloai ON book.maTheloai = theloai.maTheloai ORDER BY maSach";
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next() == false) { 
                System.out.println("ResultSet in empty in Java"); 
            } else { 
                do { 
                    SachBan bs = new SachBan(
                        result.getInt("maSach"),
                        result.getString("tenSach"), 
                        result.getString("tenTheLoai"), 
                        result.getInt("giaTien"),
                        result.getInt("soLuong")
                    ); 
                    bsList.add(bs);
                } while (result.next()); 
            }
 
         } catch (SQLException ex) {
            //Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
             if (statement != null) {
                 try {
                     statement.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         return bsList;
    }

    public ArrayList<SachBan> selectBookSold(String dateStart,String dateEnd,String category,int top) {
        // TODO Auto-generated method stub
         // TODO Auto-generated method stub
         ArrayList<SachBan> bsList = new ArrayList<SachBan>();

         java.sql.Connection conn = JDBCUtil.getConnection();
         Statement statement = null;
         try {
            String sql = "";
            Date date1;
            Date date2;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);
                if(date1.after(date2)) {
                    return null;
                } 
            } catch (ParseException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            
            
            if (dateStart.isEmpty() || dateEnd.isEmpty()) {
                dateStart = "2000-01-01";
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dateEnd = currentDate.format(formatter);
            }

            if (top > 0) {
                if (category == "Tất cả") {
                    sql = "SELECT phieuxuat_chitiet.maSach,book.tenSach,theloai.tenTheloai,donGia,SUM(phieuxuat_chitiet.soLuong) as tongSL,SUM(phieuxuat_chitiet.soLuong*donGia) as tongGia FROM phieuxuat JOIN phieuxuat_chitiet ON phieuxuat.maPx = phieuxuat_chitiet.maPx JOIN book ON phieuxuat_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai WHERE phieuxuat.ngayXuat BETWEEN '" + dateStart +"' AND '" + dateEnd +"' GROUP BY book.maSach ORDER BY tongSL DESC LIMIT " + top;
                    
                } else {
                    sql = "SELECT phieuxuat_chitiet.maSach,book.tenSach,theloai.tenTheloai,donGia,SUM(phieuxuat_chitiet.soLuong) as tongSL,SUM(phieuxuat_chitiet.soLuong*donGia) as tongGia FROM phieuxuat JOIN phieuxuat_chitiet ON phieuxuat.maPx = phieuxuat_chitiet.maPx JOIN book ON phieuxuat_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai WHERE phieuxuat.ngayXuat BETWEEN '" + dateStart +"' AND '" + dateEnd +"' AND tenTheLoai = '" + category +"' GROUP BY book.maSach ORDER BY tongSL DESC LIMIT " + top;
                }
            } else {
                if (category == "Tất cả") {
                    sql = "SELECT phieuxuat_chitiet.maSach,book.tenSach,theloai.tenTheloai,donGia,SUM(phieuxuat_chitiet.soLuong) as tongSL,SUM(phieuxuat_chitiet.soLuong*donGia) as tongGia FROM phieuxuat JOIN phieuxuat_chitiet ON phieuxuat.maPx = phieuxuat_chitiet.maPx JOIN book ON phieuxuat_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai WHERE phieuxuat.ngayXuat BETWEEN '" + dateStart +"' AND '" + dateEnd +"' GROUP BY book.maSach ORDER BY phieuxuat_chitiet.maSach";
                    
                } else {
                    sql = "SELECT phieuxuat_chitiet.maSach,book.tenSach,theloai.tenTheloai,donGia,SUM(phieuxuat_chitiet.soLuong) as tongSL,SUM(phieuxuat_chitiet.soLuong*donGia) as tongGia FROM phieuxuat JOIN phieuxuat_chitiet ON phieuxuat.maPx = phieuxuat_chitiet.maPx JOIN book ON phieuxuat_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai WHERE phieuxuat.ngayXuat BETWEEN '" + dateStart +"' AND '" + dateEnd +"' AND tenTheLoai = '" + category +"' GROUP BY book.maSach ORDER BY phieuxuat_chitiet.maSach";
                }
            }

            // System.out.println(sql);
            // String sql = "SELECT phieuxuat_chitiet.maSach,book.tenSach,theloai.tenTheloai,donGia,SUM(phieuxuat_chitiet.soLuong) as tongSL,SUM(phieuxuat_chitiet.soLuong*donGia) as tongGia FROM phieuxuat JOIN phieuxuat_chitiet ON phieuxuat.maPx = phieuxuat_chitiet.maPx JOIN book ON phieuxuat_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai WHERE phieuxuat.ngayXuat BETWEEN '2000-01-01' AND '2024-01-01' GROUP BY book.maSach ORDER BY tongSL DESC LIMIT 10";
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next() == false) { 
                System.out.println("ResultSet in empty in Java"); 
            } else { 
                do { 
                    SachBan bs = new SachBan(
                        result.getInt("maSach"),
                        result.getString("tenSach"), 
                        result.getString("tenTheLoai"), 
                        result.getInt("donGia"),
                        result.getInt("tongSL")
                    ); 
                    bsList.add(bs);
                } while (result.next()); 
            }
 
         } catch (SQLException ex) {
            //Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
             if (statement != null) {
                 try {
                     statement.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         return bsList;   
    }

    public ArrayList<sachNhap> selectBookImport(String dateStart,String dateEnd,String category,String supID,int top) {
        // TODO Auto-generated method stub
         // TODO Auto-generated method stub
         ArrayList<sachNhap> bsList = new ArrayList<sachNhap>();

         java.sql.Connection conn = JDBCUtil.getConnection();
         Statement statement = null;
         try {
            String sql = "";
            Date date1;
            Date date2;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);
                if(date1.after(date2)) {
                    return null;
                } 
            } catch (ParseException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            
            
            if (dateStart.isEmpty() || dateEnd.isEmpty()) {
                dateStart = "2000-01-01";
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dateEnd = currentDate.format(formatter);
            }

            if(supID.isEmpty() || supID.equals("")) {
                if (top > 0) {
                    if (category == "Tất cả") {
                        sql = "SELECT phieunhap_chitiet.maSach,book.tenSach,theloai.tenTheloai,ncc.tenNCC,donGia,SUM(phieunhap_chitiet.soLuong) as tongSL,SUM(phieunhap_chitiet.soLuong*donGia) as tongGia FROM phieunhap JOIN phieunhap_chitiet ON phieunhap.maPn = phieunhap_chitiet.maPn JOIN book ON phieunhap_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai JOIN ncc ON ncc.maNCC = phieunhap.maNCC WHERE phieunhap.ngayNhap BETWEEN '" + dateStart +"' AND '" + dateEnd +"' GROUP BY book.maSach ORDER BY tongSL DESC LIMIT " + top;
                        
                    } else {
                        sql = "SELECT phieunhap_chitiet.maSach,book.tenSach,theloai.tenTheloai,ncc.tenNCC,donGia,SUM(phieunhap_chitiet.soLuong) as tongSL,SUM(phieunhap_chitiet.soLuong*donGia) as tongGia FROM phieunhap JOIN phieunhap_chitiet ON phieunhap.maPn = phieunhap_chitiet.maPn JOIN book ON phieunhap_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai JOIN ncc ON ncc.maNCC = phieunhap.maNCC WHERE phieunhap.ngayNhap BETWEEN '" + dateStart +"' AND '" + dateEnd +"' AND tenTheLoai = '" + category +"' GROUP BY book.maSach ORDER BY tongSL DESC LIMIT " + top;
                    }
                } else {
                    if (category == "Tất cả") {
                        sql = "SELECT phieunhap_chitiet.maSach,book.tenSach,theloai.tenTheloai,ncc.tenNCC,donGia,SUM(phieunhap_chitiet.soLuong) as tongSL,SUM(phieunhap_chitiet.soLuong*donGia) as tongGia FROM phieunhap JOIN phieunhap_chitiet ON phieunhap.maPn = phieunhap_chitiet.maPn JOIN book ON phieunhap_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai JOIN ncc ON ncc.maNCC = phieunhap.maNCC WHERE phieunhap.ngayNhap BETWEEN '" + dateStart +"' AND '" + dateEnd +"' GROUP BY book.maSach ORDER BY phieunhap_chitiet.maSach";
                        
                    } else {
                        sql = "SELECT phieunhap_chitiet.maSach,book.tenSach,theloai.tenTheloai,ncc.tenNCC,donGia,SUM(phieunhap_chitiet.soLuong) as tongSL,SUM(phieunhap_chitiet.soLuong*donGia) as tongGia FROM phieunhap JOIN phieunhap_chitiet ON phieunhap.maPn = phieunhap_chitiet.maPn JOIN book ON phieunhap_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai JOIN ncc ON ncc.maNCC = phieunhap.maNCC WHERE phieunhap.ngayNhap BETWEEN '" + dateStart +"' AND '" + dateEnd +"' AND tenTheLoai = '" + category +"' GROUP BY book.maSach ORDER BY phieunhap_chitiet.maSach";
                    }
                }
            } else if (top > 0) {
                if (category == "Tất cả") {
                    sql = "SELECT phieunhap_chitiet.maSach,book.tenSach,theloai.tenTheloai,ncc.tenNCC,donGia,SUM(phieunhap_chitiet.soLuong) as tongSL,SUM(phieunhap_chitiet.soLuong*donGia) as tongGia FROM phieunhap JOIN phieunhap_chitiet ON phieunhap.maPn = phieunhap_chitiet.maPn JOIN book ON phieunhap_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai JOIN ncc ON ncc.maNCC = phieunhap.maNCC WHERE phieunhap.ngayNhap BETWEEN '" + dateStart +"' AND '" + dateEnd +"' AND phieunhap.maNCC = '" + supID + "' GROUP BY book.maSach ORDER BY tongSL DESC LIMIT " + top;
                    
                } else {
                    sql = "SELECT phieunhap_chitiet.maSach,book.tenSach,theloai.tenTheloai,ncc.tenNCC,donGia,SUM(phieunhap_chitiet.soLuong) as tongSL,SUM(phieunhap_chitiet.soLuong*donGia) as tongGia FROM phieunhap JOIN phieunhap_chitiet ON phieunhap.maPn = phieunhap_chitiet.maPn JOIN book ON phieunhap_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai JOIN ncc ON ncc.maNCC = phieunhap.maNCC WHERE phieunhap.ngayNhap BETWEEN '" + dateStart +"' AND '" + dateEnd +"' AND tenTheLoai = '" + category +"' AND phieunhap.maNCC = '" + supID + "' GROUP BY book.maSach ORDER BY tongSL DESC LIMIT " + top;
                }
            } else {
                if (category == "Tất cả") {
                    sql = "SELECT phieunhap_chitiet.maSach,book.tenSach,theloai.tenTheloai,ncc.tenNCC,donGia,SUM(phieunhap_chitiet.soLuong) as tongSL,SUM(phieunhap_chitiet.soLuong*donGia) as tongGia FROM phieunhap JOIN phieunhap_chitiet ON phieunhap.maPn = phieunhap_chitiet.maPn JOIN book ON phieunhap_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai JOIN ncc ON ncc.maNCC = phieunhap.maNCC WHERE phieunhap.ngayNhap BETWEEN '" + dateStart +"' AND '" + dateEnd +"' AND phieunhap.maNCC = '" + supID + "' GROUP BY book.maSach ORDER BY phieunhap_chitiet.maSach";
                    
                } else {
                    sql = "SELECT phieunhap_chitiet.maSach,book.tenSach,theloai.tenTheloai,ncc.tenNCC,donGia,SUM(phieunhap_chitiet.soLuong) as tongSL,SUM(phieunhap_chitiet.soLuong*donGia) as tongGia FROM phieunhap JOIN phieunhap_chitiet ON phieunhap.maPn = phieunhap_chitiet.maPn JOIN book ON phieunhap_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai JOIN ncc ON ncc.maNCC = phieunhap.maNCC WHERE phieunhap.ngayNhap BETWEEN '" + dateStart +"' AND '" + dateEnd +"' AND tenTheLoai = '" + category +"' AND phieunhap.maNCC = '" + supID + "' GROUP BY book.maSach ORDER BY phieunhap_chitiet.maSach";
                }
            }

            // System.out.println(sql);
            
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next() == false) { 
                System.out.println("ResultSet in empty in Java"); 
            } else { 
                do { 
                    sachNhap bs = new sachNhap(
                        result.getInt("maSach"),
                        result.getString("tenSach"), 
                        result.getString("tenTheLoai"), 
                        result.getString("tenNCC"), 
                        result.getInt("donGia"),
                        result.getInt("tongSL")
                    ); 
                    bsList.add(bs);
                } while (result.next()); 
            }
 
         } catch (SQLException ex) {
            //Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
             if (statement != null) {
                 try {
                     statement.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         return bsList;
    }

    public ArrayList<nhanvien> selectThongKeNV() {
        ArrayList<nhanvien> list = new ArrayList<nhanvien>();
        java.sql.Connection conn = JDBCUtil.getConnection();
        Statement statement = null;
        try {
            String sql = "SELECT phieuxuat.maNhanVien,SUM(tongGia) as doanhThuNV,nhanvien.tenNhanVien,nhanvien.chucvu FROM phieuxuat JOIN nhanvien ON phieuxuat.maNhanVien = nhanvien.maNhanVien GROUP BY maNhanVien";
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next() == false) { 
                System.out.println("ResultSet in empty in Java"); 
            } else { 
                do { 
                    nhanvien nv = new nhanvien(
                        result.getInt("maNhanVien"),
                        result.getString("tenNhanVien"), 
                        result.getInt("doanhThuNV"),
                        "", 
                        "",
                        "",
                        result.getString("chucvu"),
                        0 
                    ); 
                    list.add(nv);
                } while (result.next()); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(quanlihoadonbanhangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public ArrayList<khachhang> selectThongKeKH() {
        ArrayList<khachhang> list = new ArrayList<khachhang>();
        java.sql.Connection conn = JDBCUtil.getConnection();
        Statement statement = null;
        try {
            String sql = "SELECT phieuxuat.maKhachhang,SUM(tongGia) as doanhThuKH,khachhang.tenKhachhang,khachhang.email FROM phieuxuat JOIN khachhang ON phieuxuat.maKhachhang = khachhang.maKhachhang GROUP BY maKhachhang";
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next() == false) { 
                System.out.println("ResultSet in empty in Java"); 
            } else { 
                do { 
                    khachhang nv = new khachhang(
                        result.getInt("maKhachhang"),
                        result.getString("tenKhachhang"), 
                        result.getInt("doanhThuKH"),
                        "", 
                        result.getString("email"),
                        "",
                        0,
                        0
                    ); 
                    list.add(nv);
                } while (result.next()); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(quanlihoadonbanhangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public ArrayList<SachBan> chiTietThongKeKH(String dateStart,String dateEnd,int cusID) {
        ArrayList<SachBan> bsList = new ArrayList<SachBan>();

        java.sql.Connection conn = JDBCUtil.getConnection();
        Statement statement = null;
        try {
            String sql = "";
            Date date1;
            Date date2;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);
                if(date1.after(date2)) {
                    return null;
                } 
            } catch (ParseException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            
            
            if (dateStart.isEmpty() || dateEnd.isEmpty()) {
                dateStart = "2000-01-01";
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dateEnd = currentDate.format(formatter);
            }
            sql = "SELECT phieuxuat.maKhachhang,SUM(phieuxuat_chitiet.soLuong) as tongSL,book.tenSach,donGia,SUM(phieuxuat_chitiet.soLuong*donGia) as thanhTien FROM phieuxuat JOIN phieuxuat_chitiet ON phieuxuat.maPx = phieuxuat_chitiet.maPx JOIN khachhang ON khachhang.maKhachhang = phieuxuat.maKhachhang JOIN book ON book.maSach = phieuxuat_chitiet.maSach WHERE phieuxuat.ngayXuat BETWEEN '" + dateStart +"' AND '" + dateEnd +"' AND phieuxuat.maKhachhang = '" + cusID +"' GROUP BY phieuxuat_chitiet.maSach";
            System.out.println(sql);
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next() == false) { 
                System.out.println("ResultSet in empty in Java"); 
            } else { 
                do { 
                    SachBan bs = new SachBan(
                        result.getInt("maKhachhang"),
                        result.getString("tenSach"), 
                        result.getString("tongSL"), 
                        result.getInt("donGia"),
                        result.getInt("thanhTien")
                    ); 
                    bsList.add(bs);
                } while (result.next()); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(quanlihoadonbanhangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return bsList;
    }

    public ArrayList<SachBan> chiTietThongKeNV(String dateStart,String dateEnd,int emID) {
        ArrayList<SachBan> bsList = new ArrayList<SachBan>();

        java.sql.Connection conn = JDBCUtil.getConnection();
        Statement statement = null;
        try {
            String sql = "";
            Date date1;
            Date date2;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);
                if(date1.after(date2)) {
                    return null;
                } 
            } catch (ParseException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            
            
            if (dateStart.isEmpty() || dateEnd.isEmpty()) {
                dateStart = "2000-01-01";
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dateEnd = currentDate.format(formatter);
            }
            sql = "SELECT phieuxuat.maNhanVien,SUM(phieuxuat_chitiet.soLuong) as tongSL,book.tenSach,donGia,SUM(phieuxuat_chitiet.soLuong*donGia) as thanhTien FROM phieuxuat JOIN phieuxuat_chitiet ON phieuxuat.maPx = phieuxuat_chitiet.maPx JOIN nhanvien ON nhanvien.maNhanVien = phieuxuat.maNhanVien JOIN book ON book.maSach = phieuxuat_chitiet.maSach WHERE phieuxuat.ngayXuat BETWEEN '" + dateStart +"' AND '" + dateEnd +"' AND phieuxuat.maNhanVien = '" + emID +"' GROUP BY phieuxuat_chitiet.maSach";
            System.out.println(sql);
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next() == false) { 
                System.out.println("ResultSet in empty in Java"); 
            } else { 
                do { 
                    SachBan bs = new SachBan(
                        result.getInt("maNhanVien"),
                        result.getString("tenSach"), 
                        result.getString("tongSL"), 
                        result.getInt("donGia"),
                        result.getInt("thanhTien")
                    ); 
                    bsList.add(bs);
                } while (result.next()); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(quanlihoadonbanhangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return bsList;
    }

    public ArrayList<SachBan> selectCategory(String dateStart,String dateEnd,String category,int top) {
        // TODO Auto-generated method stub
         // TODO Auto-generated method stub
         ArrayList<SachBan> bsList = new ArrayList<SachBan>();

         java.sql.Connection conn = JDBCUtil.getConnection();
         Statement statement = null;
         try {
            String sql = "";
            Date date1;
            Date date2;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);
                if(date1.after(date2)) {
                    return null;
                } 
            } catch (ParseException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            
            
            if (dateStart.isEmpty() || dateEnd.isEmpty()) {
                dateStart = "2000-01-01";
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dateEnd = currentDate.format(formatter);
            }

            if (top > 0) {
                if (category == "Tất cả") {
                    sql = "SELECT theloai.maTheloai,phieuxuat_chitiet.maSach,book.tenSach,theloai.tenTheloai,donGia,SUM(phieuxuat_chitiet.soLuong) as tongSL,SUM(phieuxuat_chitiet.soLuong*donGia) as tongGia FROM phieuxuat JOIN phieuxuat_chitiet ON phieuxuat.maPx = phieuxuat_chitiet.maPx JOIN book ON phieuxuat_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai WHERE phieuxuat.ngayXuat BETWEEN '" + dateStart +"' AND '" + dateEnd +"' GROUP BY book.maTheloai ORDER BY tongSL DESC LIMIT " + top;
                    
                } else {
                    sql = "SELECT theloai.maTheloai,phieuxuat_chitiet.maSach,book.tenSach,theloai.tenTheloai,donGia,SUM(phieuxuat_chitiet.soLuong) as tongSL,SUM(phieuxuat_chitiet.soLuong*donGia) as tongGia FROM phieuxuat JOIN phieuxuat_chitiet ON phieuxuat.maPx = phieuxuat_chitiet.maPx JOIN book ON phieuxuat_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai WHERE phieuxuat.ngayXuat BETWEEN '" + dateStart +"' AND '" + dateEnd +"' AND tenTheLoai = '" + category +"' GROUP BY book.maTheloai ORDER BY tongSL DESC LIMIT " + top;
                }
            } else {
                if (category == "Tất cả") {
                    sql = "SELECT theloai.maTheloai,phieuxuat_chitiet.maSach,book.tenSach,theloai.tenTheloai,donGia,SUM(phieuxuat_chitiet.soLuong) as tongSL,SUM(phieuxuat_chitiet.soLuong*donGia) as tongGia FROM phieuxuat JOIN phieuxuat_chitiet ON phieuxuat.maPx = phieuxuat_chitiet.maPx JOIN book ON phieuxuat_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai WHERE phieuxuat.ngayXuat BETWEEN '" + dateStart +"' AND '" + dateEnd +"' GROUP BY book.maTheloai ORDER BY phieuxuat_chitiet.maSach";
                    
                } else {
                    sql = "SELECT theloai.maTheloai,phieuxuat_chitiet.maSach,book.tenSach,theloai.tenTheloai,donGia,SUM(phieuxuat_chitiet.soLuong) as tongSL,SUM(phieuxuat_chitiet.soLuong*donGia) as tongGia FROM phieuxuat JOIN phieuxuat_chitiet ON phieuxuat.maPx = phieuxuat_chitiet.maPx JOIN book ON phieuxuat_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai WHERE phieuxuat.ngayXuat BETWEEN '" + dateStart +"' AND '" + dateEnd +"' AND tenTheLoai = '" + category +"' GROUP BY book.maTheloai ORDER BY phieuxuat_chitiet.maSach";
                }
            }

            // System.out.println(sql);
            // String sql = "SELECT phieuxuat_chitiet.maSach,book.tenSach,theloai.tenTheloai,donGia,SUM(phieuxuat_chitiet.soLuong) as tongSL,SUM(phieuxuat_chitiet.soLuong*donGia) as tongGia FROM phieuxuat JOIN phieuxuat_chitiet ON phieuxuat.maPx = phieuxuat_chitiet.maPx JOIN book ON phieuxuat_chitiet.maSach = book.maSach JOIN theloai ON book.maTheloai = theloai.maTheloai WHERE phieuxuat.ngayXuat BETWEEN '2000-01-01' AND '2024-01-01' GROUP BY book.maSach ORDER BY tongSL DESC LIMIT 10";
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next() == false) { 
                System.out.println("ResultSet in empty in Java"); 
            } else { 
                do { 
                    SachBan bs = new SachBan(
                        result.getInt("maTheloai"),
                        "", 
                        result.getString("tenTheLoai"), 
                        result.getInt("tongGia"),
                        result.getInt("tongSL")
                    ); 
                    bsList.add(bs);
                } while (result.next()); 
            }
 
         } catch (SQLException ex) {
            //Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
             if (statement != null) {
                 try {
                     statement.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         return bsList;   
    }

    @Override
    public SachBan selectById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public ArrayList<SachBan> selecByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
    }

    @Override
    public int insert(SachBan t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(SachBan t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(SachBan t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    @Override
    public ArrayList<SachBan> select_all_ById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select_all_ById'");
    }
}
