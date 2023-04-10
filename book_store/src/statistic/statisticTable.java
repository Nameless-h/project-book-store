package statistic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class statisticTable extends JPanel{
    private String[] columnNames = {"ID","Ten","Gioi tinh","Dia chi","Email","So dien thoai","Chuc vu"};
    private DefaultTableModel employeeTableModel;
    public JTable t;
    private JScrollPane scrollpane;
    JLabel labels[] = new JLabel[columnNames.length];
    JTextField inputs[];

    // private JButton
    public statisticTable() {
        this.add(initTable());
    }

    public JScrollPane initTable() {
        t = new JTable();
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollpane = new JScrollPane(t);
        scrollpane.setPreferredSize(new Dimension(700, 500));
        String[] headers = columnNames;
        Object[][] tableData = {
            {"1", "Vineet", "22"},
            {"2", "Archana", "31"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"4", "Krishna", "27"},
        };
        employeeTableModel = new DefaultTableModel(tableData,headers);
        t.setModel(employeeTableModel);
        t.setAutoCreateRowSorter(true);
        t.getTableHeader().setBackground(Color.red);
        t.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 16));
        t.getTableHeader().setForeground(Color.white);
        t.setRowHeight(30);
        t.getColumnModel().getColumn(0).setPreferredWidth(100);
        t.getColumnModel().getColumn(1).setPreferredWidth(120);
        t.getColumnModel().getColumn(2).setPreferredWidth(100);
        t.getColumnModel().getColumn(3).setPreferredWidth(150);
        t.getColumnModel().getColumn(4).setPreferredWidth(150);
        t.getColumnModel().getColumn(5).setPreferredWidth(150);
        t.getColumnModel().getColumn(6).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        t.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        t.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        t.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        return scrollpane;
    }

    public JPanel showLeftForm() {
        JPanel leftForm = new JPanel();
        inputs = new JTextField[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            labels[i] = new JLabel(columnNames[i]);
            labels[i].setPreferredSize(new Dimension(100,50));
            inputs[i] = new JTextField();
            inputs[i].setPreferredSize(new Dimension(150,30));
            leftForm.add(labels[i]);
            leftForm.add(inputs[i]);
        } 
        return leftForm;
    }

    private void tableMouseClicked(MouseEvent evt) {
        int row = t.getSelectedRow();
        String id = (String) t.getValueAt(row, 0);
        inputs[0].setText(id);
        String name = (String) t.getValueAt(row, 1);
        inputs[1].setText(name);
        String age = (String) t.getValueAt(row, 2);
        inputs[2].setText(age);
    }

}
