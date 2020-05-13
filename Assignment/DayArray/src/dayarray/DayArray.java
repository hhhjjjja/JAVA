/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayarray;

import java.util.Scanner;
import java.util.InputMismatchException;

public class DayArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char [] day = {'일', '월', '화', '수', '목', '금', '토'};
        
        while(true) {
            System.out.print("정수를 입력하세요>>");
            
            try {
                int num = scanner.nextInt();
                
                if (num>=0) {
                    System.out.println(day[num%7]);
                }
                else if (num<0) {
                    System.out.println("프로그램을 종료합니다...");
                    scanner.close();
                    break;
                }
            }
            catch(InputMismatchException e) {
                System.out.println("경고! 숫자가 입력되지 않았습니다.");
                scanner.next();
            }
        }
        scanner.close();
    }
}