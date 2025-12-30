import dao.AdminDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class PasswordPanel extends JInternalFrame{
    public PasswordPanel (){
        super("修改密码",true,true,true,true);
        this.setVisible(true);

        JPanel panel =new JPanel();
        panel.setBackground(Color.WHITE);

        this.add(panel);

        Box box = Box.createVerticalBox();
        panel.add(box);
        box.add(Box.createVerticalStrut(50));

        Box box1 = Box.createHorizontalBox();
        box1.add(new JLabel("初始密码："));
        JPasswordField pwdfeild = new JPasswordField(15);
        box1.add(pwdfeild);
        box.add(box1);
        box.add(Box.createVerticalStrut(20));

        Box box2 = Box.createHorizontalBox();
        box2.add(new JLabel("新密码："));
        JPasswordField pwdfeild2 = new JPasswordField(15);
        box2.add(pwdfeild2);
        box.add(box2);
        box.add(Box.createVerticalStrut(20));

        Box box3 = Box.createHorizontalBox();
        box3.add(new JLabel("确认密码："));
        JPasswordField pwdfeild3 = new JPasswordField(15);
        box3.add(pwdfeild3);
        box.add(box3);
        box.add(Box.createVerticalStrut(50));

        Box box4 = Box.createHorizontalBox();
        box4.add(Box.createVerticalStrut(30));
        JButton Button = new JButton("修改密码");
        Button.setContentAreaFilled(false);
        box4.add(Button);
        box.add(box4);

        Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                String password = new String(pwdfeild.getPassword());
                String newpwd = new String(pwdfeild2.getPassword());
                String newpwd2 = new String(pwdfeild3.getPassword());

                if(!newpwd.equals(newpwd2)) {
                    JOptionPane.showMessageDialog(Button.getParent(), "两次输入的密码不一致","系统提示",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(!password.equals(MainFrame.user.getpassword())) {
                    JOptionPane.showMessageDialog(Button.getParent(), "初始密码错误","系统提示",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                AdminDAO.updatePassword(MainFrame.user.getId(), newpwd);//更新密码

                JOptionPane.showMessageDialog(Button.getParent(), "密码修改成功，请重新登录","系统提示",JOptionPane.INFORMATION_MESSAGE);
                MainFrame.frame.setContentPane(new LoginPanel());
            }
        });

    }
}
