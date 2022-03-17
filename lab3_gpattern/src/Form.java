import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

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
        frame.setTitle("lab3_gpattern");
        frame.setResizable(false);
        frame.setBounds(100, 100, 960, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Размер");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(20, 643, 60, 20);
        frame.getContentPane().add(lblNewLabel);

        JSpinner spinner = new JSpinner();
        spinner.setFont(new Font("Tahoma", Font.PLAIN, 16));
        spinner.setBounds(90, 640, 100, 30);
        frame.getContentPane().add(spinner);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 925, 620);
        frame.getContentPane().add(scrollPane);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        scrollPane.setViewportView(textArea);

        JButton btnNewButton = new JButton("Нарисовать");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText(new Pattern().getPattern((int)spinner.getValue()));
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.setBounds(785, 640, 140, 30);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Нарисовать DW");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText(new Pattern().getPatternDW((int)spinner.getValue()));
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_1.setBounds(602, 640, 170, 30);
        frame.getContentPane().add(btnNewButton_1);
    }
}

