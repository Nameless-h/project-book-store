package GUI.Mybutton;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import com.github.lgooddatepicker.components.DatePicker;

public class DateButton extends JButton {
    
    public DateButton(DatePicker dp) {
        ImageIcon dPickerIcon = new ImageIcon(getClass().getResource("../../icon/icons8_calendar_31_30px.png"));
        JButton datePickerButton = dp.getComponentToggleCalendarButton();
        datePickerButton.setText("");
        datePickerButton.setIcon(dPickerIcon);
    }
    
}
