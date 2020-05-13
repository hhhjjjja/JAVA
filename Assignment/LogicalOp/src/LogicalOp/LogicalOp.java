/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicalOp;

import java.util.Scanner;

/**
 *
 * @author 박현정
 */
public class LogicalOp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("논리 연산을 입력하세요>>");
        Scanner scanner = new Scanner(System.in);
        boolean a = scanner.nextBoolean();
        String op = scanner.next();
        boolean b = scanner.nextBoolean();
        switch(op) {
            case "AND" :
                System.out.println("false");
                break;
            case "OR" :
                System.out.println("true");
                break;
        }
    }
    
}
