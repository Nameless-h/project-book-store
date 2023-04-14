package BUS;

import java.util.ArrayList;

import DAO.bookDAO;
import DTO.bookDTO;

public class bookBUS {
    private ArrayList<bookDTO> booklist;
    public bookBUS() {

    }
    public void initbookList() {
        bookDAO bookdao = new bookDAO();
        this.booklist = new ArrayList<bookDTO>();
        this.booklist = bookdao.list();
    }
    public ArrayList<bookDTO> getbookList() {
        return this.booklist;
    }
}
