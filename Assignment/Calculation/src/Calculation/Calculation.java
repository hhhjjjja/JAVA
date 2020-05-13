/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculation;

import java.util.Scanner;

/**
 *
 * @author 박현정
 */
public class Calculation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("식을 입력하세요>>");
        double op1 = scanner.nextDouble();
        String operator = scanner.next();
        double op2 = scanner.nextDouble();
        double result = 0;
        switch(operator) {
            case "+" :
                result = op1 + op2;
                break;
            case "-" :
                result = op1 - op2;
                break;
            case "*" :
                result = op1 * op2;
                break;
            case "/" :
                if(op2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return;
                }
                result = op1 / op2;
                break;
            default :
                System.out.println("연산 기호가 잘못되었습니다.");
        }
        System.out.println("=" + result);
    }
    
}
