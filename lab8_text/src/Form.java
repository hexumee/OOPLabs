import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

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
        frame.setBounds(100, 100, 640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        JLabel lblNewLabel = new JLabel("Входной файл");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 11, 120, 20);
        frame.getContentPane().add(lblNewLabel);

        JTextArea field = new JTextArea();
        field.setBounds(10, 93, 604, 297);
        frame.getContentPane().add(field);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(128, 12, 366, 20);
        frame.getContentPane().add(textArea);

        JButton btnNewButton = new JButton("Выбрать...");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fd = new JFileChooser();
                if (fd.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    try {
                        textArea.setText(fd.getSelectedFile().getAbsolutePath());
                        Scanner sc = new Scanner(new File(fd.getSelectedFile().getAbsolutePath()));
                        String text = "";

                        while (sc.hasNext()) {
                            text += sc.nextLine() + "\n";
                        }

                        sc.close();
                        field.setText(text);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(504, 11, 110, 23);
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("Выходной файл");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(10, 54, 120, 20);
        frame.getContentPane().add(lblNewLabel_1);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(128, 55, 366, 20);
        frame.getContentPane().add(textArea_1);

        JButton btnNewButton_1 = new JButton("Выбрать...");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fd = new JFileChooser();
                if (fd.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    try {
                        textArea_1.setText(fd.getSelectedFile().getAbsolutePath());
                        BufferedWriter bw = new BufferedWriter(new FileWriter(fd.getSelectedFile().getAbsolutePath()));
                        bw.write(field.getText());
                        bw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(504, 54, 110, 23);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Обработать");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                StringTokenizer st = new StringTokenizer(field.getText(), " \n,.", true);

                while (st.hasMoreTokens()) {
                    String t = st.nextToken();
                    if (t == " " || t == "\n" || t == "," || t == ".") {
                        sb.append(t);
                    } else {
                        if (t.contains("A") || t.contains("А")) {
                            sb.append(String.format("<%s>", t));
                        } else {
                            sb.append(t);
                        }
                    }
                }

                field.setText(sb.toString());
            }
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_2.setBounds(10, 401, 604, 23);
        frame.getContentPane().add(btnNewButton_2);
    }
}

