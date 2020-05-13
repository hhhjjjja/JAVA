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
public class Item extends Enemy{
    protected final int collision_distance = 30; //총알에 부딪히면 죽는 면적
    protected final int index;
    public Item(int x, int y, float delta_x, float delta_y, int max_x, int max_y, float delta_y_inc, int index)
    {
        super(x,y,delta_x,delta_y,max_x,max_y,delta_y_inc);
        delta_y = 30.0f;
        this.index = index;
        if(index == 1)
            img = tk.getImage("src/resourcepack/power.png");
        else if(index == 0)
            img = tk.getImage("src/resourcepack/score.png");
            
    }
    
    public void move(float i) {
        
        i+=0.1f;
        y_pos += delta_y+i;

        /*if (y_pos > max_y) {
            y_pos = 0;
            delta_y += delta_y_inc;
        }*/
    }
    public boolean isCollidedWithPlayer(Player player) {
        if (-collision_distance <= (y_pos - player.getY()) && (y_pos - player.getY() <= collision_distance)) {
            if (-collision_distance <= (x_pos - player.getX()) && (x_pos - player.getX() <= collision_distance)) {
                //collided.
                return true;
            }
        }
        return false;
    }
    
    
    public void draw(Graphics g, ImageObserver i) {
        
        g.drawImage(img, (int)x_pos, (int)y_pos, i);
        /*g.setColor(Color.blue);
        int[] x_poly = {(int) x_pos, (int) x_pos - 10, (int) x_pos, (int) x_pos + 10};
        int[] y_poly = {(int) y_pos + 15, (int) y_pos, (int) y_pos + 10, (int) y_pos};
        g.fillPolygon(x_poly, y_poly, 4);*/
    }
    
    
}
