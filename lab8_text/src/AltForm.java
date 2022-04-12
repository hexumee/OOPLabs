import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

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

        JButton btnNewButton_2 = new JButton("Обработать A");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder(field.getText());

                for (int i = 0; i < 10; i++) {
                    int index = sb.indexOf(String.valueOf(i));
                    while (index != -1) {
                        sb.replace(index, index+1, "!");
                        index++;
                        index = sb.indexOf(String.valueOf(i), index);
                    }
                }

                field.setText(sb.toString());
            }
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_2.setBounds(10, 401, 191, 23);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Обработать C");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AltString string = new AltString(field.getText().toCharArray());

                int firstLetterIndex = 0;
                int lastLetterIndex = string.length()-1;
                for (int i = 0; i < string.length(); i++) {
                    char currLetter = string.getArray()[i];
                    if (currLetter == ' ' || currLetter == ',' || currLetter == '.' || currLetter == '!' || currLetter == '?') { 
                        lastLetterIndex = i-1;
                        if (string.getArray()[firstLetterIndex] == string.getArray()[lastLetterIndex]) {
                            for (int k = lastLetterIndex-firstLetterIndex; k >= 0; k--) {
                                for (int j = firstLetterIndex; j < string.length()-1; j++) {
                                    string.getArray()[j] = string.getArray()[j+1];
                                }
                            }
                            i = lastLetterIndex-1;
                        }
                        firstLetterIndex = i+1;
                    }
                }

                field.setText(new String(string.getArray()));
            }
        });
        btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_3.setBounds(216, 401, 191, 23);
        frame.getContentPane().add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Обработать D");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] words = null;

                try {
                    Scanner sc = new Scanner(new File("words.txt"));
                    String text = "";

                    while (sc.hasNext()) {
                        text += sc.nextLine();
                    }

                    sc.close();

                    words = text.split(" ");   // разбиваем на массив
                    for (String w : words) {
                        w.trim();    // избавляемся от '\n' и прочего
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }


                AltString string = new AltString(field.getText().toCharArray());

                int firstLetterIndex = 0;
                int lastLetterIndex = string.length()-1;
                for (int i = 0; i < string.length(); i++) {
                    char currLetter = string.getArray()[i];
                    if (currLetter == ' ' || currLetter == ',' || currLetter == '.' || currLetter == '!' || currLetter == '?' || currLetter == '\n') { 
                        lastLetterIndex = i-1;
                        char[] word = new char[lastLetterIndex-firstLetterIndex+1];
                        for (int j = firstLetterIndex; j <= lastLetterIndex; j++) {
                            word[j-firstLetterIndex] = string.getArray()[j];    // собираем слово
                        }

                        AltString bracketed = new AltString(word);
                        for (int j = 0; j < words.length; j++) {
                            // если такое слово еще не встречалось и такое слово есть в словаре
                            if (words[j] != null && Arrays.equals(word, words[j].toCharArray())) {
                                for (int k = 0; k < bracketed.length(); k++) {
                                    // преобразование регистра (a => A)
                                    if (65 <= (int)bracketed.getArray()[k] && (int)bracketed.getArray()[k] <= 90) {
                                        bracketed.getArray()[k] = bracketed.getArray()[k];
                                    } else {
                                        bracketed.getArray()[k] = (char)((int)bracketed.getArray()[k]-32);
                                    }
                                }
                                bracketed.append('<', true);    // добавляем '<' с начала
                                bracketed.append('>', false);    // добавляем '>' с конца
                                string.reserve(2);    // резервируем место для сдвига символов

                                for (int l = 2; l > 0; l--) {    // сдвигаем на 2 позиции, так как два новых символа
                                    for (int k = string.length()-1; k >= lastLetterIndex; k--) {
                                        string.getArray()[k] = string.getArray()[k-1];
                                    }
                                }

                                for (int k = firstLetterIndex; k <= lastLetterIndex; k++) {
                                    for (int l = 0; l < bracketed.length(); l++) {
                                        // сдвигаем символы столько раз, какой длины слово
                                        string.getArray()[firstLetterIndex+l] = bracketed.getArray()[l];
                                    }
                                }
                                words[j] = null;    // чтобы больше такое слово не выделять
                                i = lastLetterIndex + bracketed.length();    // обновляем индексы
                            }
                        }
                        firstLetterIndex = i+1;    // начинаем со следующего слова
                    }
                }

                field.setText(new String(string.getArray()));
            }
        });
        btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_4.setBounds(421, 401, 191, 23);
        frame.getContentPane().add(btnNewButton_4);
    }
}

