import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JPanel;

public class AltPaintPanel extends JPanel {
    private Color color0 = new Color(31, 126, 230);
    private Color color1 = new Color(23, 246, 93);
    private Color color2 = new Color(248, 175, 36);
    private Color color3 = new Color(228, 246, 140);
    private Color color4 = new Color(111, 153, 217);
    private Color color5 = new Color(116, 102, 73);
    private Color color6 = new Color(146, 43, 28);
    private Color color7 = new Color(193, 70, 187);
    private Color color8 = new Color(66, 45, 96);
    private Color color9 = new Color(180, 180, 180);
    private Color colorErr = new Color(255, 0, 0);

    private int width;
    private int height;
    private int[][] array;

    public AltPaintPanel() {
        try {
            Scanner sc = new Scanner(new File("dataAlt.txt"));
            width = sc.nextInt();
            height = sc.nextInt();
            array = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int el = sc.nextInt();
                    array[i][j] = el;
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void process() {
        // считаем суммы и индексы
        int[] rs = new int[height];
        int minridx = 0;
        int maxridx = 0;
        int mioa = Integer.MAX_VALUE;    /* ничего лучше             */
        int mxoa = Integer.MIN_VALUE;    /*              не придумал */
        for (int i = 0; i < height; i++) {
            int s = 0;
            for (int j = 0; j < width; j++) {
                s += array[i][j];
            }
            rs[i] = s;

            if (s > mxoa) {
                mxoa = s;
                maxridx = i;
            }
            if (s < mioa) {
                mioa = s;
                minridx = i;
            }
        }

        //
        // собственно обработка
        //
        for (int i = 0; i < width; i++) {
            int ta = array[minridx][i];
            int tb = array[maxridx][i];
            array[maxridx][i] = ta;
            array[minridx][i] = tb;
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                switch (array[i][j]) {
                    case 0:
                        g.setColor(color0);
                        break;
                    case 1:
                        g.setColor(color1);
                        break;
                    case 2:
                        g.setColor(color2);
                        break;
                    case 3:
                        g.setColor(color3);
                        break;
                    case 4:
                        g.setColor(color4);
                        break;
                    case 5:
                        g.setColor(color5);
                        break;
                    case 6:
                        g.setColor(color6);
                        break;
                    case 7:
                        g.setColor(color7);
                        break;
                    case 8:
                        g.setColor(color8);
                        break;
                    case 9:
                        g.setColor(color9);
                        break;
                    default:
                        g.setColor(colorErr);
                }
                g.fillRect(65+40*j, 45+40*i, 40, 40);
                g.setColor(Color.black);
                g.drawRect(65+40*j, 45+40*i, 40, 40);
            }
        }
    }
}

