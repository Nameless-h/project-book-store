package BUS;

import java.util.ArrayList;

import DTO.bills.bill;
import DTO.bills.bill_detail;

public class list_game_sold {
    private ArrayList<bill_detail> listGameSold;

    public list_game_sold() {
        this.listGameSold = null;
    }

    public list_game_sold(ArrayList<bill_detail> list) {
        this.listGameSold = list;
    }
    
    public ArrayList<bill_detail> getListGameSold() {
        return this.listGameSold;
    }
}
