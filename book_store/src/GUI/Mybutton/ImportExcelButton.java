package GUI.Mybutton;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ImportExcelButton extends JButton {

    public ImportExcelButton() {
        this.setText("Import");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_ms_excel_30px.png")));
    }
}
