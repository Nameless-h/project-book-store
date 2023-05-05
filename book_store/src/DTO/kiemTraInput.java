package DTO;

import javax.swing.JOptionPane;

public class kiemTraInput {
    public kiemTraInput() {

    }

    public boolean checkEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            // The input is null, empty, or consists of only white spaces
            JOptionPane.showMessageDialog(null, "Không được để trống!", "Thông báo", 1);
            return false;
        }
        return true;
    }

    // Function for validating a phone number in Vietnam
    public boolean validatePhoneNumber(String phoneNumber) {
            // Regular expression pattern for a Vietnamese phone number
            String pattern = "^(\\+84|0)(3[2-9]|5[689]|7[0|6-9]|8[1-5]|9[0-9])[0-9]{7}$";
            if (!phoneNumber.matches(pattern)) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng!", "Thông báo", 1);
            }
            return phoneNumber.matches(pattern);
    }

    // Function for validating an email address in Vietnam
    public boolean validateEmail(String email) {
            // Regular expression pattern for a Vietnamese email address
            String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (!email.matches(pattern)) {
                JOptionPane.showMessageDialog(null, "Email không đúng định dạng!", "Thông báo", 1);
            }
            return email.matches(pattern);
        
    }

    public boolean checkNumber(String number) {
        try {
            double d = Double.parseDouble(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
