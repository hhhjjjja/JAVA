/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multable;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author 박현정
 */
public class MulTable extends JFrame{

    MulTable() {
        String input = JOptionPane.showInputDialog("Input a number.");
        int number = 1;
        if(input != null) {
            number=Integer.parseInt(input);
        }
        
        String text="<html>";
        for(int i=1;i<10;++i) {
            text += number + "*" + i +"=" + number*i;
            text += "<br>";
        }
        text += "<html>";
        //here
        setLayout(new FlowLayout());
        setTitle("JavaTest");
        JLabel label = new JLabel();
        
        label.setText(text);
        add(label);
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        MulTable frame = new MulTable();
    }
    
}