/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inCart;
import book_detail.book;
import java.util.ArrayList;
/**
 *
 * @author Vi Hao
 */
public class cart {
    private ArrayList<book> bookArr = new ArrayList<book>();
    private long total;
    
    public long calculateTotal() {
        total = 0;
        for(book b:bookArr) {
            total += b.getGiaTien();
        }
        return total;
    }
    
    public void addToCart(book b) {
        bookArr.add(0,b);
    }
    
    public void delFromCart(book b) {
        bookArr.remove(b);
    }
    
    public void emptyCart() {
        bookArr.removeAll(bookArr);
    }
    
    public void showCart() {
        for(book b:bookArr) {
            System.out.println(b.toString());
        }
    }
}
