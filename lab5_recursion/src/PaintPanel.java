import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
    private int depth = 0;

    public void paint(Graphics g) {
        super.paint(g);
    }

    public void setDepth(int value) {
        if (value < 0) return;
        if (value < depth) {
            this.paint(getGraphics());
            this.setBackground(Color.WHITE);
            this.setBounds(10, 11, 964, 473);
        }
        depth = value;
        RecuStarCo(this.getGraphics(), 450, 200, 75, depth);
    }

    void DrawStar(Graphics g, int x, int y, int size) {
        Polygon star = new Polygon(new int[]{x, x+size/4, x+size, x+size/4, x, x-size/4, x-size, x-size/4}, 
                                   new int[]{y-size, y-size/4, y, y+size/4, y+size, y+size/4, y, y-size/4},
                                   8);
        g.drawPolygon(star);
    }

    void DrawStarF(Graphics g, int x, int y, int size) {
        Polygon star = new Polygon(new int[]{x, x+size/4, x+size, (int)(x+size/2.5), (int)(x+size/1.5), x, (int)(x-size/1.5), (int)(x-size/2.5), x-size, x-size/4},
                                   new int[]{y-size, y-size/4, y-size/4, y+size/4, y+size, y+size/2, y+size, y+size/4, y-size/4, y-size/4},
                                   10);
        g.drawPolygon(star);
    }

    void RecuStar(Graphics g, int x, int y, int size, int depth) {
        if (depth <= 0) return;
        DrawStar(g, x, y, size);
        RecuStarF(g, x-size, y, size/2, depth-1); // левый верх
        RecuStarF(g, x, y+size, size/2, depth-1); // правый низ
        RecuStarF(g, x, y-size, size/2, depth-1); // левый низ
        RecuStarF(g, x+size, y, size/2, depth-1); // правый верх
    }

    void RecuStarF(Graphics g, int x, int y, int size, int depth) {
        if (depth <= 0) return;
        DrawStarF(g, x, y, size);
        RecuStar(g, x-size, y-size/4, size/2, depth-1); // лево
        RecuStar(g, x+size, y-size/4, size/2, depth-1); // право
        RecuStar(g, x, y-size, size/2, depth-1); // верх
        RecuStar(g, (int)(x-size/1.5), y+size, size/2, depth-1); // левый низ
        RecuStar(g, (int)(x+size/1.5), y+size, size/2, depth-1); // правый низ
    }

    void RecuStarCo(Graphics g, int x, int y, int size, int depth) {
        if (depth <= 0) return;

        RecuStarF(g, x, y, size, depth);
    }
}

