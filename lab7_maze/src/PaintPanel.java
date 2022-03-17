import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
    private Image wallTexture;
    private Image playerTexture;
    private Image portalTexture;
    private Image leverTexture;
    private Image leverBrokenTexture;
    private Image doorTexture;
    private Image doorOpenedTexture;
    private Image mineTexture;
    private Image shieldTexture;

    private int width;
    private int height;
    private int[][] array;
    private int level = 0;
    private int levCnt = 2;

    private int xloc = 0;
    private int yloc = 0;
    private int px = 0;
    private int py = 0;

    private int pxloc = 0;
    private int pyloc = 0;

    private boolean isDoorUnlocked = false;
    private boolean isShieldActive = false;

    public PaintPanel() {
        wallTexture = new ImageIcon("wall.png").getImage();
        playerTexture = new ImageIcon("player.png").getImage();
        portalTexture = new ImageIcon("portal.png").getImage();
        leverTexture = new ImageIcon("lever.png").getImage();
        leverBrokenTexture = new ImageIcon("lever_broken.png").getImage();
        doorTexture = new ImageIcon("door.png").getImage();
        doorOpenedTexture = new ImageIcon("door_opened.png").getImage();
        mineTexture = new ImageIcon("mine.png").getImage();
        shieldTexture = new ImageIcon("shield.png").getImage();
        loadLevel(0);
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                switch (array[i][j]) {
                    case 8: // кирпич
                        g2d.drawImage(wallTexture, 30+30*j, 60+30*i, null);
                        break;
                    case 6: // портал
                        g2d.drawImage(portalTexture, 30+30*j, 60+30*i, null);
                        break;
                    case 1: // игрок
                        g2d.drawImage(playerTexture, px, py, null);
                        break;
                    case 7: // рычаг
                        if (!isDoorUnlocked) {
                            g2d.drawImage(leverTexture, 30+30*j, 60+30*i, null);
                        } else {
                            g2d.drawImage(leverBrokenTexture, 30+30*j, 60+30*i, null);
                        }
                        break;
                    case 3: // дверь
                        if (!isDoorUnlocked) {
                            g2d.drawImage(doorTexture, 30+30*j, 60+30*i, null);
                        } else {
                            g2d.drawImage(doorOpenedTexture, 30+30*j, 60+30*i, null);
                        }
                        break;
                    case 4: // мина
                        g2d.drawImage(mineTexture, 30+30*j, 60+30*i, null);
                        break;
                    case 9: // щит
                        if (!isShieldActive) {
                            g2d.drawImage(shieldTexture, 30+30*j, 60+30*i, null);
                        } else {
                            g2d.drawImage(null, 30+30*j, 60+30*i, null);
                        }
                        break;
                }
            }
        }

        g2d.dispose();
    }

    public void loadLevel(int level) {
        isDoorUnlocked = false;
        isShieldActive = false;
        try {
            Scanner sc = new Scanner(new File(String.format("level%d.txt", level)));
            width = sc.nextInt();
            height = sc.nextInt();
            array = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    array[i][j] = sc.nextInt();
                    if (array[i][j] == 1) {
                        px = 30+30*j;
                        py = 60+30*i;
                        xloc = j;
                        yloc = i;
                    } else if (array[i][j] == 6) {
                        pxloc = j;
                        pyloc = i;
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void nextLevel() {
        loadLevel(++level);
        isDoorUnlocked = false;
        isShieldActive = false;
        this.repaint();
    }

    public int getCurrentLevel() {
        return level;
    }

    public int getLevelCount() {
        return levCnt;
    }

    public int getPortalX() {
        return pxloc;
    }

    public int getPortalY() {
        return pyloc;
    }

    public int getPlayerX() {
        return xloc;
    }

    public int getPlayerY() {
        return yloc;
    }

    public int getPlayerXCoord() {
        return px;
    }

    public int getPlayerYCoord() {
        return py;
    }

    public void setPlayerXCoord(int val) {
        this.px = val;
        this.repaint();
    }

    public void setPlayerYCoord(int val) {
        this.py = val;
        this.repaint();
    }

    public boolean setPlayerX(int val) {
        if (array[yloc][val] != 8) {
            if (array[yloc][val] == 3 && !isDoorUnlocked) {
                return false;
            }
            if (array[yloc][val] == 7) {
                isDoorUnlocked = true;
            }
            if (array[yloc][val] == 9) {
                isShieldActive = !isShieldActive;
            }
            if (array[yloc][val] == 4 && !isShieldActive) {
                loadLevel(level);
                return false;
            }
            this.xloc = val;
            return true;
        }
        return false;
    }

    public boolean setPlayerY(int val) {
        if (array[val][xloc] != 8) {
            if (array[val][xloc] == 3 && !isDoorUnlocked) {
                return false;
            }
            if (array[val][xloc] == 7) {
                isDoorUnlocked = true;
            }
            if (array[val][xloc] == 9) {
                isShieldActive = !isShieldActive;
            }
            if (array[val][xloc] == 4 && !isShieldActive) {
                loadLevel(level);
                return false;
            }
            this.yloc = val;
            return true;
        }
        return false;
    }
}

