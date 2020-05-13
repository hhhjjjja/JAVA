/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 *
 * @author wgpak
 */
public class BossEnemy extends Enemy{
	private boolean bossCheck = true;
	protected final int collision_distance = 100; //총알에 부딪히면 죽는 면적
    public BossEnemy(int x, int y, float delta_x, float delta_y, int max_x, int max_y, float delta_y_inc) {
    	super(0,0,0,0,0,0,0);
        x_pos = x;
        y_pos = y;
        this.delta_x = delta_x;
        this.delta_y = delta_y;
        this.max_x = max_x;
        this.max_y = max_y;
        this.delta_y_inc = delta_y_inc;
    	img = tk.getImage("src/resourcepack/boss.png");
    	effect_img = tk.getImage("src/resourcepack/big_effect.png");
    }
    
    public void move() {
    	System.out.println(x_pos);
    	if(bossCheck){
    		x_pos += 2;
    	}
    	if(bossCheck==false){
    		x_pos -= 2;
    	}
    	
        if(x_pos < 1){ 	
        	bossCheck = true;
        	x_pos = 1;
        }
        if( x_pos > max_x){ 
        	bossCheck = false;
        	x_pos = max_x;
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
                    g.drawImage(effect_img, (int)x_pos-100, (int)y_pos-80, i);
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

    public void draw(Graphics g, ImageObserver i) {
        g.drawImage(img, (int)x_pos-100, (int)y_pos-80, i);
    }
}
