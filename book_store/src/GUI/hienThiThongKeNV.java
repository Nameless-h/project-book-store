package GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class hienThiThongKeNV extends JFrame{
    private JLabel idLabel, nameLabel, categoryLabel, ageLabel,anyJLabel,any2JLabel;
    public JTextField idField, nameField, categoryField, ageField,anyField,any2Field;
    
    public hienThiThongKeNV() {
        init();
    }
    
    public void init() {
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        
        idLabel = new JLabel("ID:");
        add(idLabel);
        idField = new JTextField();
        add(idField);
        
        nameLabel = new JLabel("Name:");
        add(nameLabel);
        nameField = new JTextField();
        add(nameField);
        
        categoryLabel = new JLabel("Category:");
        add(categoryLabel);
        categoryField = new JTextField();
        add(categoryField);
        
        ageLabel = new JLabel("Age:");
        add(ageLabel);
        ageField = new JTextField();
        add(ageField);

        anyJLabel = new JLabel("Any:");
        add(anyJLabel);
        anyField = new JTextField();
        add(anyField);

        any2JLabel = new JLabel("Any2:");
        add(any2JLabel);
        any2Field = new JTextField();
        add(any2Field);
    }

    public static void main(String[] args) {
        new hienThiThongKeNV();
    }
}
