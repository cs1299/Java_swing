import pojo.User;
import util.SystemConstants;

import javax.swing.*;

public class MainFrame {
    public static final JFrame frame =new JFrame("题库管理系统");
    static User user;
    public static void main(String[] args) {
        frame.setSize(SystemConstants.FRAME_WIDTH, SystemConstants.FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);//居中
        frame.setContentPane(new LoginPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void setContent(JPanel panel){
        frame.setContentPane(panel);
    }
}
