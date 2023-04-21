package DTO;

public class bookSold {
    private int bookID;
    private String bookName;
    private String bookCategory;
    private int bookPrice;
    private int bookSoldQuantity;

    // constructor
    public bookSold() {
        this.bookID = 0;
        this.bookName = null;
        this.bookCategory = null;
        this.bookPrice = 0;
        this.bookSoldQuantity = 0;
    }

    public bookSold(int id,String name,String category,int price,int quantity) {
        this.bookID = id;
        this.bookName = name;
        this.bookCategory = category;
        this.bookPrice = price;
        this.bookSoldQuantity = quantity;
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

    public int getBookPrice() {
        return this.bookPrice;
    }

    public int getBookSoldQuantity() {
        return this.bookSoldQuantity;
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

    public void setBookPrice(int price) {
        this.bookPrice = price;
    }

    public void setBookSoldQuantity(int quantity) {
        this.bookSoldQuantity = quantity;
    }

    @Override
    public String toString() {
        return this.bookID + "," + this.bookName + "," + this.bookCategory + "," +  this.bookPrice + "," + this.bookSoldQuantity;
    }
} 
