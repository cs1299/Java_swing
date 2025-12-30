import util.SystemConstants;

import javax.swing.*;

public class MainFrame {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame = new JFrame("题库系统");
            frame.setSize(SystemConstants.FRAME_WIDTH, SystemConstants.FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);//居中
        frame.setContentPane(new LoginPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
