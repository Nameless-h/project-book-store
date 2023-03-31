package form1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import user.user_info;

public class menu extends JFrame{
    JPanel pan_north,pan_west,pan_center,pan_gr_fun,pan_add_gr_fun;

    public menu(user_info user){
        init(user);
    }
    private void init(user_info user){
        this.setSize(1300,700);
        this.setLayout(new BorderLayout());
        this.setLocation(100,50);
        this.setUndecorated(true);



        //them cac panel 
        pan_center=new menu_center(user);
        pan_west=new menu_west(this);
        pan_north=new menu_north(this);
        pan_gr_fun=new group_function();
        pan_add_gr_fun=new add_group_function();
        this.add(pan_north,BorderLayout.NORTH);
        this.add(pan_west,BorderLayout.WEST);
        this.add(pan_center,BorderLayout.CENTER);
        // this.add(pan_gr_fun,BorderLayout.CENTER);
        // this.add(pan_add_gr_fun,BorderLayout.CENTER);
        this.setVisible(true);
    }
    public static void main(String[] agrs ){
        user_info user=new user_info("admin123", "Lam Tuan kiet", "0939643659", "Nam", "20/12/2003", "2634/3 XXX", "Admin");
        new menu(user);
    }
}
