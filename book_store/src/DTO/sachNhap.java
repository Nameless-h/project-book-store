package DTO;

public class sachNhap {
    private int bookID;
    private String bookName;
    private String bookCategory;
    private String supplierName;
    private int bookPrice;
    private int bookImportQuantity;

    // constructor
    public sachNhap() {
        this.bookID = 0;
        this.bookName = null;
        this.bookCategory = null;
        this.supplierName = null;
        this.bookPrice = 0;
        this.bookImportQuantity = 0;
    }

    public sachNhap(int id,String name,String category,String supplierName,int price,int quantity) {
        this.bookID = id;
        this.bookName = name;
        this.bookCategory = category;
        this.supplierName = supplierName;
        this.bookPrice = price;
        this.bookImportQuantity = quantity;
    }

    // get
    public int getBookID() {
        return this.bookID;
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getBookCategory() {
        return this.bookCategory;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public int getBookPrice() {
        return this.bookPrice;
    }

    public int getBookImportQuantity() {
        return this.bookImportQuantity;
    }

    // set
    public void setBookID(int id) {
        this.bookID = id;
    }

    public void setBookName(String name) {
        this.bookName = name;
    }

    public void setBookCategory(String category) {
        this.bookCategory = category;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setBookPrice(int price) {
        this.bookPrice = price;
    }

    public void setBookImportQuantity(int quantity) {
        this.bookImportQuantity = quantity;
    }

    @Override
    public String toString() {
        return this.bookID + "," + this.bookName + "," + this.bookCategory + "," + this.supplierName  + "," + this.bookPrice + "," + this.bookImportQuantity;
    }
}
