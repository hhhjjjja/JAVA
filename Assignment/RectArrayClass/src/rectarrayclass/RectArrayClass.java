package rectarrayclass;

import java.util.Scanner;

class Rect {
    private int width, height;
    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getArea() {
        return width*height;
    }
}
public class RectArrayClass {
    public static void main(String[] args) {
        Scanner scanint = new Scanner(System.in);
        Rect [] rect = new Rect[4];
        for(int i=0;i<4;++i) {
            System.out.print(i+1 + " 너비와 높이 >> ");
            int width = scanint.nextInt();
            int height = scanint.nextInt();
            rect[i] = new Rect(width, height);
        }
        System.out.println("저장하였습니다...");
        int sum=0;
        for(int i=0;i<4;++i) {
            sum+=rect[i].getArea();
        }
        System.out.println("사각형의 전체 합은 " + sum);
    }
}