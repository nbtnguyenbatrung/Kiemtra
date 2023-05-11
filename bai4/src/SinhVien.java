import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class SinhVien extends JFrame {
    private JPanel sinhvienPanel;
    private JTextField txtmasv;
    private JTextField txtdienthoai;
    private JTextField txtten;
    private JTextField txttuoi;
    private JButton btnsua;
    private JButton btnxoa;
    private JComboBox cmbgt;
    private JTable table1;


    Connection con;
    Statement stmt;
    private static String DB_URL = "jdbc:mysql://localhost:3306/bai4";

    public void connect()
    {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection(DB_URL, "root","");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    private void table_load()
    {
        try
        {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from sinhvien ");
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public SinhVien (){

        connect();
        table_load();
        cmbgt.addItem("Nam");
        cmbgt.addItem("Nữ");
        cmbgt.addItem("Khác");

        table1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtmasv.setEnabled(false);
                int row = table1.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                txtmasv.setText(model.getValueAt(row, 0).toString());
                txtten.setText(model.getValueAt(row, 1).toString());
                cmbgt.setSelectedItem(model.getValueAt(row, 2).toString());
                txttuoi.setText(model.getValueAt(row, 3).toString());
                txtdienthoai.setText(model.getValueAt(row, 4).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        btnsua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String masv = txtmasv.getText();

                if (!masv.equals("")){
                    try
                    {
                        stmt = con.createStatement();
                        stmt.executeUpdate("update sinhvien set " +
                                " HoTen  = '"+ txtten.getText() +"' ," +
                                " Gt = '" + cmbgt.getSelectedItem() +"'," +
                                " Tuoi = "+ Integer.parseInt(txttuoi.getText()) +
                                " ,SoDienThoai = '"+ txtdienthoai.getText() +
                                "' where MaSinhVien  = '" + txtmasv.getText() + "'");
                        JOptionPane.showMessageDialog(null,
                                "Cập nhật thành công");
                        table_load();
                    }
                    catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });

        btnxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String masv = txtmasv.getText();
                try
                {
                    stmt = con.createStatement();
                    stmt.executeUpdate("delete from sinhvien  where MaSinhVien  = '" +
                            masv + "'");
                    JOptionPane.showMessageDialog(null,
                            "Xóa thành công");
                    table_load();
                    txtmasv.setText("");
                    txtten.setText("");
                    txttuoi.setText("");
                    txtdienthoai.setText("");
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }

            }
        });

    }

    public static void main(String[] args) {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setContentPane(sinhVien.sinhvienPanel);
        sinhVien.setTitle("Danh sách sinh viên");
        sinhVien.setSize(700, 500);
        sinhVien.setBounds(400, 200, 700 , 500 );
        sinhVien.setVisible(true);
        sinhVien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
