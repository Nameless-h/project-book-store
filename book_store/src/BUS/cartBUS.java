package BUS;

import book_detail.book;
import DTO.cart;
import java.util.ArrayList;


public class cartBUS {
    
    /* public long calculateTotal() {
        total = 0;
        for(book b:bookArr) {
            total += b.getGiaTien();
        }
        return total;
    }
    
   
    
    public void removeProductFromCart(book b) {
        bookArr.remove(b);
    }
    
    public void removeAllProductsInCart() {
        bookArr.removeAll(bookArr);
    } */
    
    public ArrayList<book>getProductsInCart() {
        /* for(book b:bookArr) {
            System.out.println(b.toString());
        } */

        ArrayList<book> booksInCart = new ArrayList<book>();

        return booksInCart;
    }

    /* public void addProductToCart(book b) {
        bookArr.add(0,b);
    } */
    
}
