import dao.DataDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static dao.DataDAO.maxId;

public class DataEditPanel extends JInternalFrame{
    public DataEditPanel(Object id) {
        super("数据编辑", true, true, true, true);
        this.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        this.add(panel);

        Box box = Box.createVerticalBox();
        panel.add(box);
        box.add(Box.createVerticalStrut(55));

        Box box1 = Box.createHorizontalBox();
        box1.add(new JLabel("题目内容："));
        JTextField field1 = new JTextField(50);
        box1.add(field1);
        box.add(box1);
        box.add(Box.createVerticalStrut(5));

        Box box2 = Box.createHorizontalBox();
        box2.add(new JLabel("选项A："));
        JTextField field2 = new JTextField(50);
        box2.add(field2);
        box.add(box2);
        box.add(Box.createVerticalStrut(5));

        Box box3 = Box.createHorizontalBox();
        box3.add(new JLabel("选项B："));
        JTextField field3 = new JTextField(50);
        box3.add(field3);
        box.add(box3);
        box.add(Box.createVerticalStrut(5));

        Box box4 = Box.createHorizontalBox();
        box4.add(new JLabel("选项C："));
        JTextField field4 = new JTextField(50);
        box4.add(field4);
        box.add(box4);
        box.add(Box.createVerticalStrut(5));

        Box box5 = Box.createHorizontalBox();
        box5.add(new JLabel("选项D："));
        JTextField field5 = new JTextField(50);
        box5.add(field5);
        box.add(box5);
        box.add(Box.createVerticalStrut(5));

        Box box6 = Box.createHorizontalBox();
        box6.add(new JLabel("答案："));
        JTextField field6 = new JTextField(10);
        box6.add(field6);
        box.add(box6);
        if(id!=null){
            Object[] data = DataDAO.findById(id);
            field1.setText(data[1].toString());
            field2.setText(data[2].toString());
            field3.setText(data[3].toString());
            field4.setText(data[4].toString());
            field5.setText(data[5].toString());
            field6.setText(data[6].toString());
        }
        JButton button = new JButton("提交");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object[] data = new Object[] {id,field1.getText(),field2.getText(),field3.getText(),field4.getText(),field5.getText(),field6.getText()};
                if(id==null)
                {
                    DataDAO.add(data);
                    JOptionPane.showMessageDialog(button.getParent(), "题目添加成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
                    AdminPanel.setContent(new DataTablePanel());
                }
                else {
                    DataDAO.update(data,id);
                    AdminPanel.setContent(new DataTablePanel());
                }


            }
        });
        box.add(button);

    }
}
