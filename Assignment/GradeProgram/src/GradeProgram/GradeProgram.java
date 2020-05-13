/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GradeProgram;

import java.util.Scanner;

/**
 *
 * @author 박현정
 */
public class GradeProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("학점을 입력하세요>>");
        Scanner scanner = new Scanner(System.in);
        String grade = scanner.next();
        switch(grade) {
            case "A":
            case "B":
                System.out.println("Excellent");
                break;
            case "C":
            case "D":
                System.out.println("Good");
                break;
            default:
                System.out.println("Bye");
                break;
        }
    }
    
}
