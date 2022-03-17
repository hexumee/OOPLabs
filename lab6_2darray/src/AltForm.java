import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltForm {
    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AltForm window = new AltForm();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AltForm() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 675);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        AltPaintPanel panel = new AltPaintPanel();
        panel.setBounds(10, 11, 255, 261);
        frame.getContentPane().add(panel);

        AlterPaintPanel panel1 = new AlterPaintPanel();
        panel1.setBounds(10, 331, 255, 261);
        frame.getContentPane().add(panel1);

        JButton btnNewButton = new JButton("Обработать A");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.process();
                panel.repaint();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(20, 283, 239, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnB = new JButton("Обработать B");
        btnB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.process();
                panel1.repaint();
            }
        });
        btnB.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnB.setBounds(20, 603, 239, 23);
        frame.getContentPane().add(btnB);
    }
}

