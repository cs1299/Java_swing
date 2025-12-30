import util.SystemConstants;
import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel{
    private static JDesktopPane contentPanel = new JDesktopPane();
    public AdminPanel() {
        this.setBounds(0, 0, SystemConstants.FRAME_WIDTH, SystemConstants.FRAME_HEIGHT);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

    }

    public static void setContentPanel(JInternalFrame internalFrame){
        internalFrame.setSize(885,540);
        internalFrame.setVisible(true);
        contentPanel.removeAll();
        contentPanel.repaint();
        contentPanel.add(internalFrame);
    }
}
