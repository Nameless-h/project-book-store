package support;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import BUS.PriceFormatter;
import BUS.SanPhamBUS;
import BUS.quanlichitiethoadonbanhang;
import BUS.quanlichitiethoadonnhaphang;
import BUS.quanlihoadonbanhang;
import BUS.quanlihoadonnhaphang;
import BUS.quanlikhachhang;
import BUS.quanlinhacungcap;
import BUS.quanlinhanvien;
import DTO.chitiethoadon;
import DTO.hoadonbanhang;
import DTO.hoadonnhaphang;

import java.awt.FileDialog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WritePDF {
    Document document;
    Font fontData;
    Font fontTitle;
    Font fontHeader;
    FileOutputStream file;
    FileDialog fd = new FileDialog(new JFrame(), "Xuất PDF", FileDialog.SAVE);

    public WritePDF() {
        try {
            fontData = new Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
            fontTitle = new Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontHeader = new Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 13, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
//            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
            ex.printStackTrace();
        }
    }

    private String getFile(int mahd,int bool) {
        if(bool==1) {
            fd.setFile("hoadonbanhang"+mahd+".pdf");
        } else if(bool==0) {
            fd.setFile("hoadonnhaphang"+mahd+".pdf");
        }
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("nullnull")) {
            return null;
        }
        return url;
    }

    public void writeHoaDonBanHang(int mahd) {
        String url = "";
        try {
            fd.setTitle("In hóa đơn");
            url = getFile(mahd,1);
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
            
            setTitle("Thông tin hóa đơn");
            //Hien thong tin cua hoa don hien tai
            quanlihoadonbanhang qlhdbd = new quanlihoadonbanhang();
            quanlikhachhang qlkh = new quanlikhachhang();
            quanlinhanvien qlnv = new quanlinhanvien();
            SanPhamBUS qlsp = new SanPhamBUS();
            quanlichitiethoadonbanhang qlcthdbh = new quanlichitiethoadonbanhang();

            qlhdbd.initList();
            hoadonbanhang hd = qlhdbd.getHDBH(mahd);

            Chunk glue = new Chunk(new VerticalPositionMark());// Khoang trong giua hang
            Paragraph paraMaHoaDon = new Paragraph(new Phrase("Hóa đơn: " + String.valueOf(hd.getmahd()), fontData));

            Paragraph para1 = new Paragraph();
            para1.setFont(fontData);
            para1.add(String.valueOf("Mã khách hàng: " +hd.getMakh()));
            para1.add(glue);
            para1.add("Ngày lập: " + String.valueOf(hd.getngay()));

            Paragraph para2 = new Paragraph();
            para2.setPaddingTop(30);
            para2.setFont(fontData);
            para2.add(String.valueOf("Tên khách hàng: " + qlkh.getKhachHang(hd.getMakh()).getTen()));
            
            Paragraph para3 = new Paragraph();
            para3.setPaddingTop(30);
            para3.setFont(fontData);
            para3.add(String.valueOf("Mã nhân viên: " + hd.getmanv()));

            Paragraph para4 = new Paragraph();
            para4.setPaddingTop(30);
            para4.setFont(fontData);
            para4.add(String.valueOf("Tên nhân viên: " + qlnv.getNhanVien(hd.getmanv()).getTen()));

            Paragraph paraGiamgia = new Paragraph();
            paraGiamgia.setPaddingTop(30);
            paraGiamgia.setFont(fontData);
            paraGiamgia.add("Giảm giá: " + hd.getGiamgia()+"%");

            document.add(paraMaHoaDon);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(para4);
            document.add(paraGiamgia);
            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

            //Tao table cho cac chi tiet cua hoa don
            PdfPTable pdfTable = new PdfPTable(6);
            pdfTable.setTotalWidth(new float[] {
                30,50,250,100,30,100
            });
            pdfTable.setLockedWidth(true);
            double tongGiamgia = 0;
            double tongThanhTien = 0;
            double tongThanhtien = 0;

            //Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("STT", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Mã SP", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên sách", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("SL", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));

            for (int i = 0; i < 6; i++) {
                pdfTable.addCell(new PdfPCell(new Phrase("")));
            }

            //Truyen thong tin tung chi tiet vao table
            qlcthdbh.initList();
            qlsp.listSanPham();
            int stt=1;
            for (chitiethoadon cthd : qlcthdbh.getList()) {
                if(cthd.getmahd() == mahd) {
                    String ma = String.valueOf(cthd.getmasach());
                    String ten = qlsp.getBook(cthd.getmasach()).getTenSach();
                    String gia = PriceFormatter.format(cthd.getdongia());
                    String soluong = String.valueOf(cthd.getsoluong());
                    String thanhtien = PriceFormatter.format(cthd.getdongia() * cthd.getsoluong());
    
                    pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(stt), fontData)));
                    pdfTable.addCell(new PdfPCell(new Phrase(ma, fontData)));
                    pdfTable.addCell(new PdfPCell(new Phrase(ten, fontData)));
                    pdfTable.addCell(new PdfPCell(new Phrase(gia, fontData)));
                    pdfTable.addCell(new PdfPCell(new Phrase(soluong, fontData)));
                    pdfTable.addCell(new PdfPCell(new Phrase(thanhtien, fontData)));
    
                    tongThanhTien += cthd.getdongia() * cthd.getsoluong();
                    stt++;
                }
            }

            document.add(pdfTable);
            document.add(Chunk.NEWLINE);

            tongGiamgia = Math.floor((hd.getTongtien() * (Math.ceil(hd.getGiamgia()) / 100))/1000)*1000;
            tongThanhtien = Math.ceil((hd.getTongtien() - tongGiamgia)/1000)*1000 ;
            Paragraph paraTongThanhTien = new Paragraph(new Phrase("Tổng cộng: " + PriceFormatter.format(tongThanhTien), fontData));
            paraTongThanhTien.setIndentationLeft(380);
            document.add(paraTongThanhTien);
            Paragraph paraTongGiamgia = new Paragraph(new Phrase("Tổng giảm giá: " + PriceFormatter.format(tongGiamgia), fontData));
            paraTongGiamgia.setIndentationLeft(380);
            document.add(paraTongGiamgia);
            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Thành tiền: " + PriceFormatter.format(tongThanhtien), fontData));
            paraTongThanhToan.setIndentationLeft(380);
            document.add(paraTongThanhToan);
            document.close();
            
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }
    }

    public void writeHoaDonNhapHang(int mahd) {
        String url = "";
        try {
            fd.setTitle("In hóa đơn");
            url = getFile(mahd,0);
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
            
            setTitle("Thông tin hóa đơn");
            //Hien thong tin cua hoa don hien tai
            quanlihoadonnhaphang qlhdnh = new quanlihoadonnhaphang();
            quanlinhanvien qlnv = new quanlinhanvien();
            quanlinhacungcap qlncc = new quanlinhacungcap();
            SanPhamBUS qlsp = new SanPhamBUS();
            quanlichitiethoadonnhaphang qlcthdnh = new quanlichitiethoadonnhaphang();

            qlhdnh.initList();
            qlncc.initList();
            hoadonnhaphang hd = qlhdnh.getHDNH(mahd);

            Chunk glue = new Chunk(new VerticalPositionMark());// Khoang trong giua hang
            Paragraph paraMaHoaDon = new Paragraph(new Phrase("Hóa đơn: " + String.valueOf(hd.getmahd()), fontData));

            Paragraph para1 = new Paragraph();
            para1.setFont(fontData);
            para1.add(String.valueOf("Mã nhà cung cấp: " +hd.getMancc()));
            para1.add(glue);
            para1.add("Ngày lập: " + String.valueOf(hd.getngay()));

            Paragraph para2 = new Paragraph();
            para2.setPaddingTop(30);
            para2.setFont(fontData);
            para2.add(String.valueOf("Tên nhà cung cấp: " + qlncc.getNCC(hd.getMancc()).getTen()));
            
            Paragraph para3 = new Paragraph();
            para3.setPaddingTop(30);
            para3.setFont(fontData);
            para3.add(String.valueOf("Mã nhân viên: " + hd.getmanv()));

            Paragraph para4 = new Paragraph();
            para4.setPaddingTop(30);
            para4.setFont(fontData);
            para4.add(String.valueOf("Tên nhân viên: " + qlnv.getNhanVien(hd.getmanv()).getTen()));

            document.add(paraMaHoaDon);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(para4);
            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

            //Tao table cho cac chi tiet cua hoa don
            PdfPTable pdfTable = new PdfPTable(6);
            pdfTable.setTotalWidth(new float[] {
                30,50,250,100,30,100
            });
            pdfTable.setLockedWidth(true);
            double tongThanhtien = 0;

            //Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("STT", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Mã SP", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên sách", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("SL", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));

            for (int i = 0; i < 6; i++) {
                pdfTable.addCell(new PdfPCell(new Phrase("")));
            }

            //Truyen thong tin tung chi tiet vao table
            qlcthdnh.initList();
            qlsp.listSanPham();
            int stt=1;
            for (chitiethoadon cthd : qlcthdnh.getList()) {
                if(cthd.getmahd() == mahd) {
                    String ma = String.valueOf(cthd.getmasach());
                    String ten = qlsp.getBook(cthd.getmasach()).getTenSach();
                    String gia = PriceFormatter.format(cthd.getdongia());
                    String soluong = String.valueOf(cthd.getsoluong());
                    String thanhtien = PriceFormatter.format(cthd.getdongia() * cthd.getsoluong());
    
                    pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(stt), fontData)));
                    pdfTable.addCell(new PdfPCell(new Phrase(ma, fontData)));
                    pdfTable.addCell(new PdfPCell(new Phrase(ten, fontData)));
                    pdfTable.addCell(new PdfPCell(new Phrase(gia, fontData)));
                    pdfTable.addCell(new PdfPCell(new Phrase(soluong, fontData)));
                    pdfTable.addCell(new PdfPCell(new Phrase(thanhtien, fontData)));
    
                    tongThanhtien += cthd.getdongia() * cthd.getsoluong();
                    stt++;
                }
            }

            document.add(pdfTable);
            document.add(Chunk.NEWLINE);

            tongThanhtien = hd.getTongtien();
            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Thành tiền: " + PriceFormatter.format(tongThanhtien), fontData));
            paraTongThanhToan.setIndentationLeft(380);
            document.add(paraTongThanhToan);
            document.close();
            
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }
    }

}
