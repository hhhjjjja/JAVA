package randomlabel;

import javax.swing.*;
import java.awt.*;

public class RandomLabel extends JFrame {
    RandomLabel() {
        setTitle("Random Labels");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        setLayout(null);
        
        for(int i=0 ; i<20 ; ++i) {
            JLabel label = new JLabel();
            label.setBackground(Color.BLUE);
            int x_pos = (int)(Math.random()*200) + 50;
            int y_pos = (int)(Math.random()*200) + 50;
            label.setLocation(x_pos, y_pos);
            label.setSize(10, 10);
            label.setOpaque(true);
            add(label);
        }
        setSize(300, 300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new RandomLabel();
    }
}