package GUI.Mybutton;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ExportExcelButton extends JButton {

    public ExportExcelButton() {
        this.setText("Xuất");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_ms_excel_30px.png")));
    }
}
