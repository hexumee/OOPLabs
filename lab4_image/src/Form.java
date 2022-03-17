import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
        frame.setResizable(false);
        frame.setTitle("lab4_image");
        frame.setBounds(100, 100, 816, 639);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PaintPanel panel = new PaintPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

}

