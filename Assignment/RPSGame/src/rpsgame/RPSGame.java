/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpsgame;

import java.util.Scanner;
import java.util.Random;

public class RPSGame {
    public static void main(String[] args) {
        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
        while(true) {
            int n = (int)(Math.random()*3);
            
            System.out.print("가위(scissors) 바위(rock) 보(paper)!>>");
            Scanner scanner = new Scanner(System.in);
            String me = scanner.next();
            int a=0;
            
            if(me.equals("stop")){
                System.out.println("게임을 종료합니다...");
                scanner.close();
                break;
            }
            
            if(me.equals("scissors")) {
                a = 0;
            }
            if(me.equals("rock")) {
                a = 1;
            }
            if(me.equals("paper")) {
                a = 2;
            }
            
            if(a == 0) {
                if(n==0) {
                    System.out.println("사용자 = 가위, 컴퓨터 = 가위, 비겼습니다.");
                }
                else if(n==1) {
                    System.out.println("사용자 = 가위, 컴퓨터 = 바위, 컴퓨터가 이겼습니다.");
                }
                else if(n==2) {
                    System.out.println("사용자 = 가위, 컴퓨터 = 보, 사용자가 이겼습니다.");
                }
            }
            else if(a == 1) {
                if(n==0) {
                    System.out.println("사용자 = 바위, 컴퓨터 = 가위, 사용자가 이겼습니다.");
                }
                else if(n==1) {
                    System.out.println("사용자 = 바위, 컴퓨터 = 바위, 비겼습니다.");
                }
                else if(n==2) {
                    System.out.println("사용자 = 바위, 컴퓨터 = 보, 컴퓨터가 이겼습니다.");
                }
            }
            else if(a == 2) {
                if(n==0) {
                    System.out.println("사용자 = 보, 컴퓨터 = 가위, 컴퓨터가 이겼습니다.");
                }
                else if(n==1) {
                    System.out.println("사용자 = 보, 컴퓨터 = 바위, 사용자가 이겼습니다.");
                }
                else if(n==2) {
                    System.out.println("사용자 = 보, 컴퓨터 = 보, 비겼습니다.");
                }
            }
        }
    }
}