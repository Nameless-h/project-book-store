package GUI;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class suataikhoan extends JPanel {
    main obj;
    Color color_211=new Color(211,211,211);
    String name_font1="Times Roman";
    //----------------------------
    JPanel pan_info,pan_tinhtrang;
    String[] list_combox={"q1","q2"};
    String[] list_lab={"Ma tai khoan:","Username:","Password:","Ma nhan vien:","Nhom quyen:"};
    JLabel[] lab=new JLabel[list_lab.length];
    JTextField[] txt=new JTextField[list_lab.length-1];
    JComboBox com;
    JButton bun_them;
    JCheckBox chk_chophep,chk_khong;
    CheckboxGroup cbg = new CheckboxGroup();
    public suataikhoan(main obj){
        this.obj=obj;
        init(obj);
    }
    private void init(main obj){
        this.setPreferredSize(new Dimension(obj.w_center,obj.h_center));
        this.setLayout(null);
        this.setBackground(color_211);
        //--
        pan_info=new JPanel();
        pan_info.setBounds(300,10,obj.w_center-600,obj.h_center-100);
        pan_info.setBackground(color_211);
        pan_info.setLayout(new FlowLayout(FlowLayout.LEFT));
        pan_info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                                                        "Sua tai khoan",
                                                            TitledBorder.LEFT,
                                                            TitledBorder.TOP));;
        this.add(pan_info);
        for(int i=0;i<list_lab.length-1;i++)
        {
            lab[i]=new JLabel(list_lab[i]);
            lab[i].setPreferredSize(new Dimension(250,30));
            lab[i].setFont(new Font(name_font1,1,25));
            pan_info.add(lab[i]);
            txt[i]=new JTextField();
            txt[i].setPreferredSize(new Dimension(300,40));
            txt[i].setFont(new Font(name_font1,1,25));
            txt[i].setForeground(Color.black);
            if(i==0)
                txt[i].setEnabled(false);
            pan_info.add(txt[i]);
        }
        int temp=list_lab.length-1;
        lab[temp]=new JLabel(list_lab[temp]);
        lab[temp].setPreferredSize(new Dimension(250,50));
        lab[temp].setFont(new Font(name_font1,1,25));
        pan_info.add(lab[temp]);
        com=new JComboBox(list_combox);
        com.setPreferredSize(new Dimension(250,50));
        com.setForeground(Color.black);
        com.setFont(new Font(name_font1,1,25));
        pan_info.add(com);
        pan_tinhtrang=new JPanel();
        pan_tinhtrang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                                                        "Cho phep",
                                                            TitledBorder.LEFT,
                                                            TitledBorder.TOP));;
        pan_tinhtrang.setPreferredSize(new Dimension(480,100));
        pan_tinhtrang.setBackground(color_211);
        pan_tinhtrang.setLayout(new FlowLayout(FlowLayout.LEFT));
        pan_info.add(pan_tinhtrang);
        chk_chophep=new JCheckBox("Cho phep",true);
        chk_chophep.setPreferredSize(new Dimension(150,50));
        chk_chophep.setFont(new Font(name_font1,1,25));
        chk_khong=new JCheckBox("Khong cho phep",false);
        chk_khong.setPreferredSize(new Dimension(250,50));
        chk_khong.setFont(new Font(name_font1,1,22));
        pan_tinhtrang.add(chk_chophep);
        pan_tinhtrang.add(chk_khong);






        bun_them=new JButton("Sua");
        bun_them.setBounds(400,590,300,50);
        bun_them.setBackground(Color.red);
        bun_them.setFont(new Font(name_font1,1,25));
        bun_them.setHorizontalAlignment(SwingConstants.CENTER);
        bun_them.setForeground(Color.white);
        this.add(bun_them);
    }
}
