package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import user.user_info;

public class menu1 extends JFrame{
    JPanel pan_north,pan_west,pan_center,pan_gr_fun,pan_add_gr_fun;
    int wd_center,hih_center,wd_nort,hih_nort,wd_west,hih_west;
    public menu1(user_info user){
        init(user);
    }
    private void init(user_info user){
        this.setSize(1300,700);
        this.setLayout(new BorderLayout());
        this.setLocation(100,50);
        this.setUndecorated(true);
                //set do rong ,chieu cao cac panel
        //phia bac
        wd_nort=0;
        hih_nort=30;
        //phia tay
        wd_west=200;
        hih_west=630;
        //o giua(man hinh chinh)
        wd_center=1100;
        hih_center=630;
        //them cac panel 
        // pan_center=new menu_center(user,wd_center,hih_center);
        // pan_west=new menu_west(this,wd_west,hih_west);
        // pan_north=new header(this,wd_nort,hih_nort);
        this.add(pan_north,BorderLayout.NORTH);
        this.add(pan_west,BorderLayout.WEST);
        this.add(pan_center,BorderLayout.CENTER);
        // this.add(pan_gr_fun,BorderLayout.CENTER);
        // this.add(pan_add_gr_fun,BorderLayout.CENTER);
        this.setVisible(true);
    }
    public static void main(String[] agrs ){
        user_info user=new user_info("admin123", "Lam Tuan kiet", "0939643659", "Nam", "20/12/2003", "2634/3 XXX", "Admin");
        new menu1(user);

    }
    
}
