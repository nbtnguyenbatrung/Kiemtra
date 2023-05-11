import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task extends JFrame {
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private JRadioButton radio4;
    private JPanel taskPanel;
    private JButton btnOk;
    private JButton btnExit;

    public Task (){
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radio1.isSelected()){
                    Gptbn task = new Gptbn();
                    task.openGptbn();
                    dispose();
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        radio1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radio2.setSelected(Boolean.FALSE);
                radio3.setSelected(Boolean.FALSE);
                radio4.setSelected(Boolean.FALSE);
            }
        });
        radio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radio1.setSelected(Boolean.FALSE);
                radio3.setSelected(Boolean.FALSE);
                radio4.setSelected(Boolean.FALSE);
            }
        });
        radio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radio2.setSelected(Boolean.FALSE);
                radio1.setSelected(Boolean.FALSE);
                radio4.setSelected(Boolean.FALSE);
            }
        });
        radio4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radio2.setSelected(Boolean.FALSE);
                radio3.setSelected(Boolean.FALSE);
                radio1.setSelected(Boolean.FALSE);
            }
        });
    }

    public void openTask(){
        Task task = new Task();
        task.setContentPane(task.taskPanel);
        task.setTitle("Danh sách công việc");
        task.setSize(300, 400);
        task.setBounds(400, 200, 500 , 250 );
        task.setVisible(true);
        task.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
