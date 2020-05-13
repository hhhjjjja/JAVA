/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

/**
 *
 * @author Administrator
 */
public class Bomb extends Shot{
    
    protected final int radius = 500;
    protected Toolkit tk = Toolkit.getDefaultToolkit();
    protected Image img;
    protected Image effect_img;
    Bomb(int x, int y)
    {
        super(x,y,0);
         img = tk.getImage("src/resourcepack/bomb.png");
    }
    
    public void bombShot(int speed) {
        y_pos += speed;
    }
    public void drawShot(Graphics g,ImageObserver i) {
        if (!alive) {
            return;
        }
         g.drawImage(img, (int)x_pos, (int)y_pos, i);
    }
     public void collided() {
        
    }
    
}
