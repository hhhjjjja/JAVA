package javafinal;

import java.awt.Graphics;
import javax.swing.*;
import java.util.*;

public class PointIcon {
    private ImageIcon pointIcon;
    private Stage stage;
    private ImageIcon [] startbtn = new ImageIcon[2];
    private ImageIcon [] howTobtn = new ImageIcon[2];
    private ImageIcon [] replaybtn = new ImageIcon[2];
    private ImageIcon [] saverankbtn = new ImageIcon[2];
    private ImageIcon [] exitbtn = new ImageIcon[2];
    private ImageIcon [] rankbtn = new ImageIcon[2];
    private final int x_pos=100;
    public int iconpos;    //0:게임시작, 1:howto페이지로
    
    public PointIcon() {
        iconpos = 0;
        stage = new Stage();
        pointIcon = new ImageIcon("src/resourcepack/point.png");
        startbtn[0] = new ImageIcon("src/resourcepack/startGame1.png");
        startbtn[1] = new ImageIcon("src/resourcepack/startGame2.png");
        howTobtn[0] = new ImageIcon("src/resourcepack/howToPlay1.png");
        howTobtn[1] = new ImageIcon("src/resourcepack/howToPlay2.png");
        replaybtn[0] = new ImageIcon("src/resourcepack/btn/replaybtn1.png");
        replaybtn[1] = new ImageIcon("src/resourcepack/btn/replaybtn2.png");
        saverankbtn[0] = new ImageIcon("src/resourcepack/btn/savebtn1.png");
        saverankbtn[1] = new ImageIcon("src/resourcepack/btn/savebtn2.png");
        rankbtn[0] = new ImageIcon("src/resourcepack/btn/rankbtn1.png");
        rankbtn[1] = new ImageIcon("src/resourcepack/btn/rankbtn2.png");
        exitbtn[0] = new ImageIcon("src/resourcepack/btn/exitbtn1.png");
        exitbtn[1] = new ImageIcon("src/resourcepack/btn/exitbtn2.png");
    }
    public void drawPoint(Graphics g) {
        if(iconpos == 0) {
            g.drawImage(pointIcon.getImage(), x_pos, 360, null);
            g.drawImage(startbtn[1].getImage(), 245, 350, null);
            g.drawImage(howTobtn[0].getImage(), 240, 420, null);
        }
        else if(iconpos == 1) {
            g.drawImage(pointIcon.getImage(), x_pos, 435, null);
            g.drawImage(startbtn[0].getImage(), 250, 350, null);
            g.drawImage(howTobtn[1].getImage(), 235, 420, null);
        }
    }
    public void drawClearPagePoint(Graphics g) {
        if(iconpos == 0) {
            g.drawImage(pointIcon.getImage(), 140, 250, null);
            g.drawImage(replaybtn[1].getImage(), 320, 235, null);
            g.drawImage(saverankbtn[0].getImage(), 315, 330, null);
            g.drawImage(rankbtn[0].getImage(), 325, 430, null);
            g.drawImage(exitbtn[0].getImage(), 315, 520, null);
        }
        else if(iconpos == 1) {
            g.drawImage(pointIcon.getImage(), 140, 335, null);
            g.drawImage(replaybtn[0].getImage(), 310, 238, null);
            g.drawImage(saverankbtn[1].getImage(), 315, 320, null);
            g.drawImage(rankbtn[0].getImage(), 325, 430, null);
            g.drawImage(exitbtn[0].getImage(), 315, 520, null);
        }
        else if(iconpos == 2) {
            g.drawImage(pointIcon.getImage(), 140, 430, null);
            g.drawImage(replaybtn[0].getImage(), 310, 235, null);
            g.drawImage(saverankbtn[0].getImage(), 315, 330, null);
            g.drawImage(rankbtn[1].getImage(), 310, 415, null);
            g.drawImage(exitbtn[0].getImage(), 315, 520, null);
        }
        else if(iconpos == 3) {
            g.drawImage(pointIcon.getImage(), 140, 520, null);
            g.drawImage(replaybtn[0].getImage(), 310, 235, null);
            g.drawImage(saverankbtn[0].getImage(), 315, 330, null);
            g.drawImage(rankbtn[0].getImage(), 325, 430, null);
            g.drawImage(exitbtn[1].getImage(), 315, 520, null);
        }
    }
}