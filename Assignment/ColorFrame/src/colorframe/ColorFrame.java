package colorframe;

import javax.swing.*;
import java.awt.*;

public class ColorFrame extends JFrame{
    ColorFrame() {
        setTitle("4*4 Color Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        setLayout(new GridLayout(4, 4));
        Color [] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA,
            Color.GRAY, Color.PINK, Color.LIGHT_GRAY, Color.WHITE, Color.BLACK, Color.RED, Color.DARK_GRAY, Color.YELLOW, Color.GREEN};
        for(int i=0;i<16;++i) {
            JLabel label = new JLabel() ;
            label.setText(Integer.toString(i));
            label.setOpaque(true);
            label.setBackground(color[i]);
            add(label);
        }
        setSize(400, 400);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ColorFrame();
    }
}