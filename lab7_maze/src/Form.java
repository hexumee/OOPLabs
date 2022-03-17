import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;

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
        final PaintPanel panel = new PaintPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(10, 11, 565, 489);

        frame = new JFrame();
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if (panel.setPlayerX(panel.getPlayerX()-1)) {
                            panel.setPlayerXCoord(panel.getPlayerXCoord()-30);
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (panel.setPlayerX(panel.getPlayerX()+1)) {
                            panel.setPlayerXCoord(panel.getPlayerXCoord()+30);
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (panel.setPlayerY(panel.getPlayerY()-1)) {
                            panel.setPlayerYCoord(panel.getPlayerYCoord()-30);
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (panel.setPlayerY(panel.getPlayerY()+1)) {
                            panel.setPlayerYCoord(panel.getPlayerYCoord()+30);
                        }
                        break;
                }

                if (panel.getPlayerX() == panel.getPortalX() && panel.getPlayerY() == panel.getPortalY()) {
                    if (panel.getCurrentLevel() < panel.getLevelCount()) {
                        panel.nextLevel();
                    } else {
                        JOptionPane.showMessageDialog(null, "Конец игры!", "Вот это да...", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        frame.setBounds(100, 100, 601, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(panel);
    }
}

