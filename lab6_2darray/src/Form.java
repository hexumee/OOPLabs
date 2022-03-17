import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        PaintPanel panel = new PaintPanel();
        panel.setBounds(0, 0, 434, 261);
        frame.getContentPane().add(panel);
    }
}

