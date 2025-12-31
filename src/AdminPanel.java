import util.SystemConstants;
import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel{
    private static JDesktopPane contentPanel = new JDesktopPane();
    public AdminPanel() {

        this.setBounds(0, 0, SystemConstants.FRAME_WIDTH, SystemConstants.FRAME_HEIGHT);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        JMenuBar menuBar = new JMenuBar();//菜单栏容器
        menuBar.setBounds(0, 0, SystemConstants.FRAME_WIDTH, 30);
        this.add(menuBar,BorderLayout.NORTH);

        contentPanel.removeAll();
        contentPanel.repaint();
        this.add(contentPanel,BorderLayout.CENTER);

        JMenu menu1 = new JMenu("题库管理");
        menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                setContent(new DataTablePanel());
            }
        });


        JMenu menu2 = new JMenu("个人中心");

        JMenuItem logout = new JMenuItem("退出登录");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                MainFrame.frame.setContentPane(new LoginPanel());
                JOptionPane.showMessageDialog(MainFrame.frame, "退出成功，欢迎下次再来。","系统提示",JOptionPane.INFORMATION_MESSAGE);
                }
            });

        JMenuItem psdchange = new JMenuItem("修改密码");
        psdchange.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                setContent(new PasswordPanel());
                System.out.println("修改密码");
            }
        });
        menu2.add(psdchange);
        menu2.add(logout);
        menuBar.add(menu1);
        menuBar.add(menu2);
    }

    public static void setContent(JInternalFrame internalFrame){
        internalFrame.setSize(SystemConstants.FRAME_WIDTH-15, SystemConstants.FRAME_HEIGHT-60);
        internalFrame.setVisible(true);
        contentPanel.removeAll();
        contentPanel.repaint();
        contentPanel.add(internalFrame);
    }
    public static void setContentPanel(JInternalFrame internalFrame){
        internalFrame.setSize(885,540);
        internalFrame.setVisible(true);
        contentPanel.removeAll();
        contentPanel.repaint();
        contentPanel.add(internalFrame);
    }
}
