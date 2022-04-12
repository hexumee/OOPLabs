import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

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
        frame.setBounds(100, 100, 920, 645);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Входной файл");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 10, 100, 20);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField.setBounds(125, 10, 655, 24);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 135, 882, 415);
        frame.getContentPane().add(textArea);

        JButton btnNewButton = new JButton("Выбрать...");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fd = new JFileChooser();
                if (fd.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    try {
                        textField.setText(fd.getSelectedFile().getAbsolutePath());
                        Scanner sc = new Scanner(new File(fd.getSelectedFile().getAbsolutePath()));
                        String text = "";

                        while (sc.hasNext()) {
                            text += sc.nextLine() + "\n";
                        }

                        sc.close();
                        textArea.setText(text);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnNewButton.setBounds(792, 10, 100, 23);
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("Выходной файл");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(10, 55, 110, 20);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_1.setColumns(10);
        textField_1.setBounds(125, 55, 655, 24);
        frame.getContentPane().add(textField_1);

        JButton btnNewButton_1 = new JButton("Выбрать...");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fd = new JFileChooser();
                if (fd.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    textField_1.setText(fd.getSelectedFile().getAbsolutePath());
                }
            }
        });
        btnNewButton_1.setBounds(792, 55, 100, 23);
        frame.getContentPane().add(btnNewButton_1);


        JLabel lblNewLabel_1_1 = new JLabel("Последовательность");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(10, 101, 143, 20);
        frame.getContentPane().add(lblNewLabel_1_1);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_2.setColumns(10);
        textField_2.setBounds(160, 101, 732, 24);
        frame.getContentPane().add(textField_2);

        JButton btnNewButton_2 = new JButton("Обработать");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringTokenizer st = new StringTokenizer(textArea.getText(), "\n .,");
                int count = 0;
                String template = "<html><body><p align='center'><b>Лабораторная работа №9</b></p><p align='center'><i>Вариант В</i></p><p>Выполнил студент группы <i>ИВТАСбд-11</i> <b><i>Нуждов Д. А.</i></b></p><p>Файл: <b>%s</b></p><p>Начало слова: <b>%s</b></p><p>Количество найденных слов: <b>%d</b></p></body></html>";

                while (st.hasMoreTokens()) {
                    String t = st.nextToken();
                    if (t.startsWith(textField_2.getText())) {
                        count++;
                    }
                }

                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(textField_1.getText()));
                    bw.write(String.format(template, textField_1.getText(), textField_2.getText(), count));
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_2.setBounds(10, 565, 882, 26);
        frame.getContentPane().add(btnNewButton_2);
    }
}

