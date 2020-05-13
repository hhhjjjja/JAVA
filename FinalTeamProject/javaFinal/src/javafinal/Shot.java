/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.awt.Graphics;
import java.awt.Color;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
/**
 *
 * @author wgpak
 */
public class Shot {

    protected int x_pos;
    protected int y_pos;
    protected boolean alive;
    
    protected final int radius = 3;
    protected final int index;
    protected Toolkit tk = Toolkit.getDefaultToolkit();
    protected Image img;
    protected Image effect_img;
    public Shot(int x, int y,int index) {
        x_pos = x;
        y_pos = y;
        alive = true;
        this.index = index;
        switch(index)
        {
            case 0:
                 img = tk.getImage("src/resourcepack/player_shot.png");
                break;
            case 10://enemyshot
                 img = tk.getImage("src/resourcepack/enemy_shot.png");
                break;
        }
           
    }
    
    
    

    public int getY() {
        return y_pos;
    }

    public int getX() {
        return x_pos;
    }

    public void moveShot(int speed) {
        y_pos += speed;
    }

    public void drawShot(Graphics g, ImageObserver i) {
        if (!alive) {
            return;
        }
        g.drawImage(img, (int)x_pos, (int)y_pos, i);
        //g.setColor(Color.yellow);
        //g.fillOval(x_pos, y_pos, radius, radius);
    }
    

    public void collided() {
        alive = false;
    }
}
