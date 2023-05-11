import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame{

    private JPanel longinPanel;
    private JTextField txtusername;
    private JTextField txtpassword;
    private JButton btnsubmit;
    private JButton btnclear;

    private static String DB_URL = "jdbc:mysql://localhost:3306/bai3";

    public Login () {
        btnsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                    Connection conn = DriverManager.getConnection(DB_URL, "root" , "");
                    Statement stmt = conn.createStatement();

                    if (!txtusername.getText().equals("") && !txtpassword.equals("")){


                        ResultSet rs = stmt.executeQuery("select * from login Where username ='" +
                                txtusername.getText() + "' And password ='" + txtpassword.getText() + "'");
                        if (rs.isBeforeFirst()){
                            Task task = new Task();
                            task.openTask();
                            dispose();
                        }else{
                            JOptionPane.showMessageDialog(new Login(),
                                    "username hoặc password không đúng",
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        conn.close();

                    }else{
                        JOptionPane.showMessageDialog(new Login(), "Bạn chưa nhập username hoặc password",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtpassword.setText("");
                txtusername.setText("");
            }
        });
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.setContentPane(login.longinPanel);
        login.setTitle("Thông tin đăng nhập");
        login.setSize(300, 400);
        login.setBounds(400, 200, 500 , 200 );
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
