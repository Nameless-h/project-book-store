package GUI.Mybutton;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class searchbutton extends JButton{
    public searchbutton() {
        this.setText("Search");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8-search-30.png")));
    }
}
