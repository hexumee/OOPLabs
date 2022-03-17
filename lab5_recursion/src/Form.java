import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;

public class Form {
    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Form window = new Form();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Form() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("lab5_recursion");
        frame.setBounds(100, 100, 1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        PaintPanel panel = new PaintPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 11, 964, 473);
        frame.getContentPane().add(panel);

        JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                panel.setDepth((int)spinner.getValue());
            }
        });
        spinner.setFont(new Font("Tahoma", Font.PLAIN, 16));
        spinner.setBounds(109, 507, 75, 26);
        frame.getContentPane().add(spinner);

        JLabel lblNewLabel = new JLabel("Глубина");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(35, 507, 75, 26);
        frame.getContentPane().add(lblNewLabel);
    }
}

