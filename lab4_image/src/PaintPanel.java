import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
    Color cyan = new Color(30, 144, 255);            // голубой
    Color green = new Color(34, 139, 34);            // зеленый
    Color orange = new Color(255, 133, 0);           // оранжевый
    Color brown = new Color(189, 89, 40);            // коричневый
    Color darkerBrown = new Color(148, 70, 31);      // темно-коричневый
    Color veryDarkBrown = new Color(105, 49, 22);    // очтемно-коричневый
    Color lightGray = new Color(127, 118, 121);      // ярко-серый
    Color gray = new Color(108, 104, 116);           // серый
    Color darkGray = new Color(73, 66, 61);          // темно-серый
    Color white = new Color(255, 255, 255);          // белый
    Color black = new Color(0, 0, 0);                // черный

    Polygon roof = new Polygon(new int[]{460, 620, 780}, new int[]{330, 220, 330}, 3);				// крыша
    Polygon ear1 = new Polygon(new int[]{234, 245, 260}, new int[]{395, 370, 390}, 3);				// ухо 1
    Polygon ear2 = new Polygon(new int[]{270, 295, 300}, new int[]{405, 380, 415}, 3);				// ухо 2
    Polygon tail = new Polygon(new int[]{160, 150, 125, 135}, new int[]{480, 510, 530, 500}, 4);    // хвост
    Polygon paw1 = new Polygon(new int[]{150, 170, 190}, new int[]{570, 540, 570}, 3);				// лапа 1
    Polygon paw2 = new Polygon(new int[]{260, 280, 300}, new int[]{570, 540, 570}, 3);				// лапа 2

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g; 

        // фон
        g2d.setColor(cyan);
        g2d.fillRect(0, 0, 800, 600);

        // трава
        g2d.setColor(green);
        g2d.fillRect(0, 570, 800, 30);

        // солнце
        g2d.setColor(orange);
        g2d.fillOval(30, 30, 60, 60);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(60, 5, 60, 25);
        g2d.drawLine(5, 60, 25, 60);
        g2d.drawLine(20, 20, 35, 35);
        g2d.drawLine(60, 95, 60, 115);
        g2d.drawLine(35, 85, 20, 100);
        g2d.drawLine(95, 60, 115, 60);
        g2d.drawLine(85, 35, 100, 20);
        g2d.drawLine(85, 85, 100, 100);

        // будка
        g2d.setColor(brown);
        g2d.fillRect(480, 330, 283, 240);
        g2d.setColor(orange);
        g2d.drawRect(480, 330, 283, 240);
        g2d.setColor(darkerBrown);
        g2d.fillPolygon(roof);
        g2d.setColor(brown);
        g2d.drawPolygon(roof);
        g2d.setColor(veryDarkBrown);
        g2d.fillOval(560, 380, 125, 140);
        g2d.fillRect(560, 440, 125, 130);

        // собака
        g2d.setColor(lightGray);
        g2d.fillRect(160, 480, 130, 70);
        g2d.fillRect(170, 425, 70, 35);
        g2d.fillPolygon(ear1);
        g2d.setColor(darkGray);
        g2d.drawPolygon(ear1);
        g2d.drawRect(160, 480, 130, 70);
        g2d.drawRect(170, 425, 70, 35);
        g2d.fillOval(160, 415, 20, 20);
        g2d.drawLine(170, 450, 190, 450);
        g2d.setColor(gray);
        g2d.fillOval(210, 390, 100, 90);
        g2d.setColor(darkGray);
        g2d.drawOval(210, 390, 100, 90);
        g2d.setColor(white);
        g2d.fillOval(230, 405, 25, 25);
        g2d.setColor(black);
        g2d.fillOval(231, 415, 14, 14);
        g2d.setColor(lightGray);
        g2d.fillPolygon(ear2);
        g2d.setColor(darkGray);
        g2d.drawPolygon(ear2);
        g2d.drawOval(230, 405, 25, 25);
        g2d.fillPolygon(paw1);
        g2d.fillPolygon(paw2);
        g2d.fillPolygon(tail);

        // облако
        g2d.setColor(white);
        g2d.fillOval(480, 70, 30, 30);
        g2d.fillOval(500, 50, 40, 40);
        g2d.fillOval(530, 60, 40, 40);
        g2d.fillRect(495, 75, 55, 25);
    }
}

