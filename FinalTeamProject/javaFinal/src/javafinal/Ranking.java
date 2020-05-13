package javafinal;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Ranking{
    private JTextField playername;
    private FileReader fileReader;
    private FileReader fileReader2;
    private BufferedReader reader;
    private BufferedReader reader2;
    public ArrayList<Integer> scoreArr = new ArrayList<Integer>();
    public ArrayList<String> playerArr = new ArrayList<String>();
    private int cnt;
    private int rcnt, seccnt;
    File file;
    File [] fileArr;
    File [] fileArr2;
    
    Ranking() {
        cnt=0;
        rcnt=0; seccnt = 0;
        file = new File("src/ranking");
        fileArr = file.listFiles();
        fileArr2 = file.listFiles();
    }
    public void saveText(Stage stage) {
        JTextField playername = new JTextField();
        String namepop = JOptionPane.showInputDialog("이름을 입력하세요");
        try {
            for(int i=0;i<fileArr.length;++i) {
                ++cnt;
            }
            FileWriter fw = new FileWriter("src/ranking/"+cnt+".txt");
            ++cnt;
            BufferedWriter bw = new BufferedWriter(fw);
                bw.write(namepop+"\n"+stage.score);
                bw.newLine();
                bw.close();
        } catch (IOException r){
            System.err.println(r);
            System.exit(1);
        }
    }
    public void readText() {
        try {
            String line = null;
            fileArr = file.listFiles();
            for(int i=0;i<fileArr.length;++i) {
                fileReader = new FileReader("src/ranking/"+fileArr[i].getName());
                reader = new BufferedReader(fileReader);
                while((line = reader.readLine()) != null) {
                    if(rcnt%2 == 1) {
                        scoreArr.add(Integer.parseInt(line));
                    }
                    ++rcnt;
                }
            }
            reader.close();
            sortArr(scoreArr);
            
            String line2 = null;
            String rankername=null;
            String comp=null;
            ArrayList <String> alrsave = new ArrayList<String>();
            int i=0;
            int j=0;
            fileArr2 = file.listFiles();
            
            for(int x=0;x<scoreArr.size();++x) {
                for(i=0;i<fileArr2.length;++i) {
                    fileReader2 = new FileReader("src/ranking/" + fileArr2[i].getName());
                    reader2 = new BufferedReader(fileReader2);
                    while((line2 = reader2.readLine()) != null) {
                        if(seccnt%2 == 0) {
                            rankername = line2;
                        }
                        else if(seccnt%2 == 1) {
                            if(scoreArr.get(x) == Integer.parseInt(line2)) {
                                playerArr.add(rankername);
                                alrsave.add(rankername);
                            }
                        }
                        ++seccnt;
                    }
                }
            }
            reader2.close();
        }catch(Exception ex) {
            System.err.println(ex);
            System.exit(1);
        }
    }
    public void sortArr(ArrayList<Integer> arr) {
        int temp=0;
        for(int i=0;i<arr.size();++i) {
            for(int j=i;j<arr.size();++j) {
                if(arr.get(i) < arr.get(j)) {
                    temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
    }
    public void rankUI(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("소야논8", Font.BOLD, 40));
        if(playerArr.size() == 0) {
            g.drawString("NULL", 250, 400);     g.drawString("NULL", 550, 400);
            g.drawString("NULL", 250, 480);     g.drawString("NULL", 550, 480);
            g.drawString("NULL", 250, 555);     g.drawString("NULL", 550, 555);
            g.drawString("NULL", 250, 630);     g.drawString("NULL", 550, 630);
            g.drawString("NULL", 250, 710);     g.drawString("NULL", 550, 710);
        }
        else if(playerArr.size() == 1) {
            g.drawString(playerArr.get(0), 250, 400);       g.drawString(Integer.toString(scoreArr.get(0)), 550, 400);
            g.drawString("NULL", 250, 480);     g.drawString("NULL", 550, 480);
            g.drawString("NULL", 250, 555);     g.drawString("NULL", 550, 555);
            g.drawString("NULL", 250, 630);     g.drawString("NULL", 550, 630);
            g.drawString("NULL", 250, 710);     g.drawString("NULL", 550, 710);
        }
        else if(playerArr.size() == 2) {
            g.drawString(playerArr.get(0), 250, 400);       g.drawString(Integer.toString(scoreArr.get(0)), 550, 400);
            g.drawString(playerArr.get(1), 250, 480);       g.drawString(Integer.toString(scoreArr.get(1)), 550, 480);
            g.drawString("NULL", 250, 555);     g.drawString("NULL", 550, 555);
            g.drawString("NULL", 250, 630);     g.drawString("NULL", 550, 630);
            g.drawString("NULL", 250, 710);     g.drawString("NULL", 550, 710);
        }
        else if(playerArr.size() == 3) {
            g.drawString(playerArr.get(0), 250, 400);       g.drawString(Integer.toString(scoreArr.get(0)), 550, 400);
            g.drawString(playerArr.get(1), 250, 480);       g.drawString(Integer.toString(scoreArr.get(1)), 550, 480);
            g.drawString(playerArr.get(2), 250, 555);       g.drawString(Integer.toString(scoreArr.get(2)), 550, 555);
            g.drawString("NULL", 250, 630);     g.drawString("NULL", 550, 630);
            g.drawString("NULL", 250, 710);     g.drawString("NULL", 550, 710);
        }
        else if(playerArr.size() == 4) {
            g.drawString(playerArr.get(0), 250, 400);       g.drawString(Integer.toString(scoreArr.get(0)), 550, 400);
            g.drawString(playerArr.get(1), 250, 480);       g.drawString(Integer.toString(scoreArr.get(1)), 550, 480);
            g.drawString(playerArr.get(2), 250, 555);       g.drawString(Integer.toString(scoreArr.get(2)), 550, 555);
            g.drawString(playerArr.get(3), 250, 630);       g.drawString(Integer.toString(scoreArr.get(3)), 550, 630);
            g.drawString("NULL", 250, 710);     g.drawString("NULL", 550, 710);
        }
        else {
            g.drawString(playerArr.get(0), 250, 400);       g.drawString(Integer.toString(scoreArr.get(0)), 550, 400);
            g.drawString(playerArr.get(1), 250, 480);       g.drawString(Integer.toString(scoreArr.get(1)), 550, 480);
            g.drawString(playerArr.get(2), 250, 555);       g.drawString(Integer.toString(scoreArr.get(2)), 550, 555);
            g.drawString(playerArr.get(3), 250, 630);       g.drawString(Integer.toString(scoreArr.get(3)), 550, 630);
            g.drawString(playerArr.get(4), 250, 710);       g.drawString(Integer.toString(scoreArr.get(4)), 550, 710);
        }
    }
}