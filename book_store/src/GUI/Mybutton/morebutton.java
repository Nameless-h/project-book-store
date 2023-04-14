package GUI.Mybutton;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class morebutton extends JButton {
    public morebutton() {
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_more_20px.png")));
    }
}
