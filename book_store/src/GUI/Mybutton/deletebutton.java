package GUI.Mybutton;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class deletebutton extends JButton {
    public deletebutton() {
        this.setText("Del");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_delete_forever_30px_1.png")));
    }
}
