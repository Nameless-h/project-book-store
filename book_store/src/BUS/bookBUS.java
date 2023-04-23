package BUS;

import java.util.ArrayList;
import java.util.List;

import DAO.bookDAO;
import DTO.book;

public class bookBUS {
    private ArrayList<book> booklist;
    public bookBUS() {

    }
    public void initbookList() {
        bookDAO bookdao = new bookDAO();
        this.booklist = new ArrayList<book>();
        this.booklist = bookdao.list();
    }
    public ArrayList<book> getbookList() {
        return this.booklist;
    }

    public book getBook(int masach){
        for(book b : booklist) {
            if(b.getMaSach() == masach){
                return b;
            }
        }
        return null;
    }

    public ArrayList<book> searchBooks(String query) {
        ArrayList<book> resultList = new ArrayList<book>();
        booklist.forEach((book)->{
            if(String.valueOf(book.getMaSach()).contains(query) || book.getTenSach().toLowerCase().contains(query.toLowerCase()) ){
                resultList.add(book);
            }
        });
        return resultList;
    }

}
