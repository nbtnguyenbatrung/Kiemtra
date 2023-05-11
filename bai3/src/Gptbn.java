import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gptbn extends JFrame {
    private JPanel gptbnPanel;
    private JTextField txta;
    private JTextField txtb;
    private JButton btngiai;
    private JLabel lblkq;

    public Gptbn(){
        btngiai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txta.getText().equals("") && !txtb.getText().equals("")){
                    Float a = Float.parseFloat(txta.getText());
                    Float b = Float.parseFloat(txtb.getText());
                    if (a != 0){
                        Float c = b/a;
                        lblkq.setText(c.toString());
                    }else{
                        JOptionPane.showMessageDialog(new Login(), "Kết quả vô nghiệm",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(new Login(), "Bạn chưa nhập a hoặc b",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void openGptbn(){
        Gptbn task = new Gptbn();
        task.setContentPane(task.gptbnPanel);
        task.setTitle("Giải phương trình bậc nhất");
        task.setSize(300, 400);
        task.setBounds(400, 200, 500 , 250 );
        task.setVisible(true);
        task.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
