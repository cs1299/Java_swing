import dao.DataDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class DataTablePanel extends JInternalFrame {
    private JTextField field1 =new JTextField(20);
    public DataTablePanel() {
        super("题目列表", true, true, true, true);
        this.setVisible(true);

        JPanel topPanel = new JPanel();
        this.add(topPanel, BorderLayout.NORTH);

        topPanel.add(new JLabel ("题目关键词"));
        topPanel.add(field1);

        JButton searchbtn = new JButton("搜索");
        JButton editBtn = new JButton("修改");
        JButton deleteBtn = new JButton("删除");
        JButton addBtn = new JButton("添加");
        topPanel.add(searchbtn);
        topPanel.add(editBtn);
        topPanel.add(deleteBtn);
        topPanel.add(addBtn);
        addBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                AdminPanel.setContent(new DataEditPanel(null));
            }
        });
        searchbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                search();
            }
        });
        editBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = table.getSelectedRow();
                if(row<=-1){
                    return;
                }
                AdminPanel.setContent(new DataEditPanel(table.getValueAt(row,0)));
            }
        });
        deleteBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = table.getSelectedRow();
                if(row<=-1){
                    return;
                }
                DataDAO.delete(table.getValueAt(row,0));
                JOptionPane.showMessageDialog(deleteBtn.getParent(), "题目删除成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
                search();
            }
        });


        JPanel panel = new JPanel(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
        panel.add(table, BorderLayout.CENTER);
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        search();
    }
    private JTable table = new JTable(){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void search(){
        TableModel tableModel =new DefaultTableModel(DataDAO.search(1,field1.getText()),DataDAO.columnNames);
        table.setModel(tableModel);
    }
}
