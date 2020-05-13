/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Addition;

import java.util.Scanner;

/**
 *
 * @author 박현정
 */
public class Addition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("두 정수를 입력하세요>>");
        Scanner scanner = new Scanner(System.in);
        int integer1 = scanner.nextInt();
        int integer2 = scanner.nextInt();
        
        System.out.println(integer1 + "+" + integer2 +"은 " +(integer1+integer2));
    }
    
}