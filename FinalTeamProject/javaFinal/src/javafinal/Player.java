/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.awt.Graphics;
import java.awt.Color;
/**
 *
 * @author wgpak
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JLabel;

public class Player {
    protected int x_pos;
    protected int y_pos;
    protected int min_x;
    protected int max_x;
    protected int min_y;
    protected int max_y;
    protected  final int collision_distance = 15;
    Image playerImage;

    public Player(int x, int y, int min_x, int max_x , int min_y , int max_y) {
        x_pos = x;
        y_pos = y;
        this.min_x = min_x;
        this.max_x = max_x;
        this.min_y = min_y;
        this.max_y = max_y;
    }
    
    public void setPosition(int x,int y)
    {
        this.x_pos = x;
        this.y_pos = y;
    }

    public void moveX(int speed) {
        x_pos += speed;
        if( x_pos < min_x) x_pos = min_x;
        if( x_pos > max_x) x_pos = max_x;
    }
    public void moveY(int speed) {
        y_pos += speed;
        if( y_pos < min_y) y_pos = min_y;
        if( y_pos > max_y) y_pos = max_y;
    }
    

    public int getX() {
        return x_pos;
    }

    public int getY() {
        return y_pos;
    }

    public Shot generateShot() {
        Shot shot = new Shot(x_pos, y_pos,0);

        return shot;
    }
    public Bomb generateBomb() {
        Bomb Bomb = new Bomb(x_pos-150, y_pos);

        return Bomb;
    }
    
    public boolean isCollidedWithShot(Shot[] shots) {
        for (Shot shot : shots) {
            if (shot == null) {
                continue;
            }
            if (-collision_distance <= (y_pos - shot.getY()) && (y_pos - shot.getY() <= collision_distance)) {
                if (-collision_distance <= (x_pos - shot.getX()) && (x_pos - shot.getX() <= collision_distance)) {
                    //collided.
                    shot.collided();
                    return true;
                }
            }
        }
        return false;
    }
    

    public void drawPlayer(Graphics g) {
        //g.setColor(Color.red);
        int[] x_poly = {x_pos, x_pos - 10, x_pos, x_pos + 10};
        int[] y_poly = {y_pos, y_pos + 15, y_pos + 10, y_pos + 15};
        //g.fillPolygon(x_poly, y_poly, 4);
        //g.drawImage(playerImage,min_x,min_y,max_x,max_y,this);
    }
    
    /*
    public void drawPlayer(JLabel g) {
        //g.setColor(Color.red);
        
        int[] x_poly = {x_pos, x_pos - 10, x_pos, x_pos + 10};
        int[] y_poly = {y_pos, y_pos + 15, y_pos + 10, y_pos + 15};
        //g.imageUpdate(, min_x, min_x, min_x, min_x, min_x)
        
        //g.fillPolygon(x_poly, y_poly, 4);
    }
    */
    
}
