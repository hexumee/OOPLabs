import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.lang.Math;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltForm {
    private JFrame frame;
    private JTextField textField;
    private JLabel lblSh;
    private JTextField textField_1;
    private JLabel lblDepth;

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

    private long factorial(int v) {
        if (v <= 2) {
            return v;
        }
        return v*factorial(v-1);
    }

    private double power(double v, int a) {
        if (a == 0)
            return 1;
        else
            return v*power(v, a-1);
    }

    private double sh(double value, int depth, double sum) {
        if (depth == 0) return sum;

        sum += (power(value, 2*depth-1)/factorial(2*depth-1));

        return sh(value, --depth, sum);
    }

    private void initialize() {	
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Math.sinh()");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 10, 72, 24);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(92, 12, 330, 24);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        lblSh = new JLabel("sh()");
        lblSh.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSh.setBounds(10, 45, 72, 24);
        frame.getContentPane().add(lblSh);

        textField_1 = new JTextField();
        textField_1.setEditable(false);
        textField_1.setColumns(10);
        textField_1.setBounds(92, 47, 330, 24);
        frame.getContentPane().add(textField_1);

        lblDepth = new JLabel("Глубина");
        lblDepth.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDepth.setBounds(124, 105, 56, 24);
        frame.getContentPane().add(lblDepth);

        JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
        spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spinner.setBounds(120, 129, 64, 24);
        frame.getContentPane().add(spinner);

        JLabel lblValue = new JLabel("Значение");
        lblValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblValue.setBounds(240, 105, 64, 24);
        frame.getContentPane().add(lblValue);

        JSpinner spinner_1 = new JSpinner();
        spinner_1.setModel(new SpinnerNumberModel(0.0, null, null, 0.1));
        spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spinner_1.setBounds(226, 129, 92, 24);
        frame.getContentPane().add(spinner_1);

        JButton btnNewButton = new JButton("Вычислить");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.sinh((double)spinner_1.getValue())));
                textField_1.setText(String.valueOf(sh((double)spinner_1.getValue(), (int)spinner.getValue(), 0)));
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(157, 210, 120, 24);
        frame.getContentPane().add(btnNewButton);
    }
}

