import dao.AdminDAO;
import pojo.User;
import util.SystemConstants;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class LoginPanel extends JPanel{
    static String dir = LoginPanel.class.getClassLoader().getResource("image").getPath();//取image文件夹路径
    public LoginPanel() {
        //相对于左上角的x、y
        this.setBounds(0, 0, SystemConstants.FRAME_WIDTH, SystemConstants.FRAME_HEIGHT);
        this.setLayout(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.drawImage(new ImageIcon(dir + "/img.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
            }
        };
        panel.setBounds(250, 150, 500, 300);
        this.add(panel);

        Box box =Box.createVerticalBox();//账号主界面
        panel.add(box);
        box.add(Box.createHorizontalStrut(15));

        //用户登录字体文本框
        Box box0 = Box.createHorizontalBox();
        JLabel title = new JLabel("用户登录");
        title.setFont(new Font("微软雅黑",Font.BOLD,25));
        box0.add(title);
        box.add(box0);
        box.add(Box.createVerticalStrut(20));

        //创建一个水平盒子
        //装账号显示、输入文本框
        Box box1 = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("账号：");
        nameLabel.setFont(new Font("微软雅黑",Font.BOLD,20));

        box1.add(nameLabel);
        Border border = BorderFactory.createLoweredBevelBorder();//下凹边框
        JTextField nameField = new JTextField(20);//输入文本框
        nameField.setBorder(border);//增加黑边
        box1.add(nameField);
        box.add(box1);

        //输入密码部分
        box.add(Box.createVerticalStrut(15));//垂直间距
        Box box2 = Box.createHorizontalBox();
        JLabel pwdLabel = new JLabel("密码：");
        pwdLabel.setFont(new Font("微软雅黑",Font.BOLD,20));
        box2.add(pwdLabel);

        JPasswordField pwdfeild = new JPasswordField(20);//添加密码框
        pwdfeild.setBorder(border);
        box2.add(pwdfeild);
        box.add(box2);

        box.add(Box.createVerticalStrut(15));//垂直间距

        //登录按钮部分
        JButton loginButton = new JButton("  ");
        Image login = new ImageIcon(dir + "/LOGIN.png").getImage().getScaledInstance(250,30,Image.SCALE_DEFAULT);
        loginButton.setIcon(new ImageIcon(login));
        loginButton.setBorderPainted(false);
        loginButton.setOpaque(false);
        loginButton.setFocusPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorder(null);
        box.add(loginButton);

        JPanel login_panel=null;
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                String username = nameField.getText();
                String password = new String(pwdfeild.getPassword());

                User user = AdminDAO.getUser(username, password);
                if(user == null || !user.getpassword().equals(password)) {
                    JOptionPane.showMessageDialog(loginButton.getParent(), "账号或密码错误","系统提示",JOptionPane.WARNING_MESSAGE);
                }else {
//                    System.out.println("登录成功");
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(new ImageIcon(dir + "/background.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
    }
}
