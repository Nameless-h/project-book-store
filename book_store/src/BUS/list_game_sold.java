package BUS;

import java.util.ArrayList;

import DTO.bill;
import DTO.chitiethoadon;

public class list_game_sold {
    private ArrayList<chitiethoadon> listGameSold;

    public list_game_sold() {
        this.listGameSold = null;
    }

    public list_game_sold(ArrayList<chitiethoadon> list) {
        this.listGameSold = list;
    }
    
    public ArrayList<chitiethoadon> getListGameSold() {
        return this.listGameSold;
    }
}
