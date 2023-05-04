package GUI.statistic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import GUI.hienThiThongKeNV;

public class statisticTable extends JPanel{
    private DefaultTableModel tableModel;
    public JTable t;
    private JScrollPane scrollpane;
    JTextField inputs[];

    // private JButton
    public statisticTable() {
        this.add(initTable());
    }

    public JScrollPane initTable() {

        t = new JTable();
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableModel = new DefaultTableModel();
        scrollpane = new JScrollPane(t);
        // scrollpane.setPreferredSize(new Dimension(1100, 500));

        t.setAutoCreateRowSorter(true);
        t.getTableHeader().setBackground(Color.red);
        t.getTableHeader().setForeground(Color.white);
        t.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 16));
        t.setRowHeight(30);

        // disable table
        t.setDefaultEditor(Object.class, null);  
        /* t.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = t.getSelectedRow();
    
                TableModel model = t.getModel();
                // chi can lay ma ID de dung query 
                String val1 = model.getValueAt(row, 0).toString();
                String val2 = model.getValueAt(row, 1).toString();
                String val3 = model.getValueAt(row, 2).toString();
                String val4 = model.getValueAt(row, 3).toString();
                String val5 = model.getValueAt(row, 4).toString();
                String val6 = model.getValueAt(row, 5).toString();
    
                jtRowData.setVisible(true);
                jtRowData.pack();
                jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
                jtRowData.idField.setText(val1);
                jtRowData.nameField.setText(val2);
                jtRowData.categoryField.setText(val3);
                jtRowData.ageField.setText(val4);
                jtRowData.anyField.setText(val5);
                jtRowData.any2Field.setText(val6);
    
                
                System.out.print(val1 + " " + val2 + " " + val3 + " " + val4 + " " + val5 + "\n");
            }
        }); */
        return scrollpane;
    }

    public void setHeader(String[] headers) {
        tableModel.setColumnIdentifiers(headers);
        t.setModel(tableModel);
    }

    public JTable getTable() {
        return this.t;
    }

    public void addRow(Object[] data) {
        tableModel.addRow(data);
    }

    public void setAlignment(int column, int align) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(align);
        t.getColumnModel().getColumn(column).setCellRenderer(centerRenderer);
    }

    public void setPreferredWidth(int column , int width){
        t.getColumnModel().getColumn(column).setPreferredWidth(width);
    }
    
    public void setTablesize(int width , int height) {
        scrollpane.setPreferredSize(new Dimension(width,height));
    }

    public void clearTable() {
        tableModel.setRowCount(0);
        t.setModel(tableModel);
    }
}
