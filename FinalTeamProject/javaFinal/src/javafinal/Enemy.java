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

public class Enemy {
    protected float x_pos;
    protected float y_pos;
    protected float delta_x;
    protected float delta_y;
    protected int max_x;
    protected int max_y;
    protected float delta_y_inc;
    protected final int collision_distance = 15; //총알에 부딪히면 죽는 면적
    protected Toolkit tk = Toolkit.getDefaultToolkit();
    protected Image img;
    protected Image effect_img;
    
    public Enemy(int x, int y, float delta_x, float delta_y, int max_x, int max_y, float delta_y_inc) {
        x_pos = x;
        y_pos = y;
        this.delta_x = delta_x;
        this.delta_y = delta_y;
        this.max_x = max_x;
        this.max_y = max_y;
        this.delta_y_inc = delta_y_inc;
    	img = tk.getImage("src/resourcepack/enemy.png");
    	effect_img = tk.getImage("src/resourcepack/effect.png");
    }

    public void move() {
        x_pos += delta_x;
        y_pos += delta_y;

        if (x_pos < 0) {
            x_pos = 0;
            delta_x = -delta_x;
        } else if (x_pos > max_x) {
            x_pos = max_x;
            delta_x = -delta_x;
        }
        if (y_pos > max_y) {
            y_pos = 0;
            delta_y += delta_y_inc;
        }
    }

    public boolean isCollidedWithShot(Shot[] shots, Graphics g, ImageObserver i) {
        for (Shot shot : shots) {
            if (shot == null) {
                continue;
            }
            if (-collision_distance <= (y_pos - shot.getY()) && (y_pos - shot.getY() <= collision_distance)) {
                if (-collision_distance <= (x_pos - shot.getX()) && (x_pos - shot.getX() <= collision_distance)) {
                    //collided.
                    g.drawImage(effect_img, (int)x_pos, (int)y_pos, i);
                    shot.collided();
                    return true;
                }
            }
        }
        return false;
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
    
    public Shot generateShot() {
        Shot shot = new Shot((int)x_pos, (int)y_pos,10);
        return shot;
    }

    public void draw(Graphics g, ImageObserver i) {
        g.drawImage(img, (int)x_pos, (int)y_pos, i);
    }

    
    
    public boolean isCollidedWithBomb(Bomb bombs) {
        
        if (bombs == null) {
               return false;
            }
            if (-collision_distance <= (y_pos - bombs.getY()) && (y_pos - (bombs.getY()+300) <= collision_distance)) {
                if (-collision_distance <= (x_pos - bombs.getX()) && (x_pos - bombs.getX()-300 <= collision_distance)) {
                    //collided.
                    bombs.collided();
                    return true;
                }
            }
        
        return false;
    }
    
}


