/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inCart;
import java.util.ArrayList;

import DTO.bookDTO;
/**
 *
 * @author Vi Hao
 */
public class cart {
    private ArrayList<bookDTO> bookArr = new ArrayList<bookDTO>();
    private long total;
    
    public long calculateTotal() {
        total = 0;
        for(bookDTO b:bookArr) {
            total += b.getGiaTien();
        }
        return total;
    }
    
    public void addToCart(bookDTO b) {
        bookArr.add(0,b);
    }
    
    public void delFromCart(bookDTO b) {
        bookArr.remove(b);
    }
    
    public void emptyCart() {
        bookArr.removeAll(bookArr);
    }
    
    public void showCart() {
        for(bookDTO b:bookArr) {
            System.out.println(b.toString());
        }
    }
}
