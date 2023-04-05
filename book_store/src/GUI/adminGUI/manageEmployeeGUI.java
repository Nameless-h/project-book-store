package GUI.adminGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.SwingConstants;
import javax.xml.namespace.QName;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class manageEmployeeGUI extends JFrame implements ActionListener{
    // private employeeTable employ_table;
    JTextField headerSearchInput;
    JButton headerSearchBtn;
    public manageEmployeeGUI() {

        // header
        JPanel header = new JPanel();
        header.setBackground(Color.red);
        header.setLayout(new FlowLayout());

        // header title
        JLabel headerTitle = new JLabel("THE EMPLOYEE MANGAGEMENT", SwingConstants.CENTER);
        headerTitle.setFont(new Font("Arial", Font.PLAIN, 24));
        headerTitle.setPreferredSize(new Dimension(500, 40));
        headerTitle.setForeground(Color.white);
        header.add(headerTitle);

        // header search
        JPanel headerSearch = new JPanel();
        headerSearch.setPreferredSize(new Dimension(600, 40));
        headerSearch.setLayout(new BorderLayout());
        headerSearch.setFocusable( true );
        header.add(headerSearch);

        // header search input
        headerSearchInput = new JTextField("Type to search...");
        headerSearchInput.setPreferredSize(new Dimension(500, 0));
        headerSearchInput.setFont(new Font("Arial", Font.PLAIN, 20));
        headerSearchInput.setBorder(BorderFactory.createEmptyBorder());
        inputSearchFocus(headerSearchInput);
        
        // header search button
        headerSearchBtn = new JButton("Search");
        headerSearchBtn.setForeground(Color.white);
        headerSearchBtn.setBackground(Color.black);
        headerSearchBtn.setPreferredSize(new Dimension(100, 0));
        headerSearchBtn.setFocusable(false);
        headerSearchBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        headerSearchBtn.setBorder(BorderFactory.createEmptyBorder());
        headerSearchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        headerSearchBtn.addActionListener(this);
        hoverBtn(headerSearchBtn);

        headerSearch.add(headerSearchInput,BorderLayout.WEST);
        headerSearch.add(headerSearchBtn,BorderLayout.EAST);

        // form
        JPanel leftFormEmployee = new JPanel();
        leftFormEmployee.setBackground(Color.white);
        // leftFormEmployee.setLayout(new FlowLayout());
        String arrLabelInfo[] = {"ID","Name","Age"};

        JLabel labels[] = new JLabel[arrLabelInfo.length];
        JTextField inputs[] = new JTextField[arrLabelInfo.length];

        
        for (int i = 0; i < arrLabelInfo.length; i++) {
            labels[i] = new JLabel(arrLabelInfo[i]);
            labels[i].setPreferredSize(new Dimension(100,50));
            inputs[i] = new JTextField();
            inputs[i].setPreferredSize(new Dimension(150,30));
            leftFormEmployee.add(labels[i]);
            leftFormEmployee.add(inputs[i]);
        } 

        // list
        JPanel rightListEmployee = new employeeTable();
        // rightListEmployee.setBackground(Color.pink);
        // employ_table = new employeeTable();
        // rightListEmployee.add(employ_table);


        // CRUD bar
        JPanel crudBar = new JPanel();
        crudBar.setBackground(Color.green);

        // set size for borderLayout
        header.setPreferredSize(new Dimension(0, 100));
        leftFormEmployee.setPreferredSize(new Dimension(335, 0));
        rightListEmployee.setPreferredSize(new Dimension(650, 0));
        crudBar.setPreferredSize(new Dimension(0, 100));

        add(header, BorderLayout.NORTH);
        add(leftFormEmployee, BorderLayout.WEST);
        add(rightListEmployee, BorderLayout.EAST);
        add(crudBar, BorderLayout.SOUTH);

        // this.setUndecorated(true);
        setSize(1000, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void inputSearchFocus(JTextField input) {
        input.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (input.getText().equals("Type to search...")) {
                    input.setText("");
                }           
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (input.getText().isEmpty() || input.getText() == "") {
                    input.setText("Type to search...");
                }
            }
        });
    }

    public void hoverBtn(JButton button) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.darkGray);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.black);
            }
        });
    }

    public static void main(String[] args) {

        new manageEmployeeGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            if(e.getSource() == headerSearchBtn) {
                System.out.print("Search");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }    
    }
}
