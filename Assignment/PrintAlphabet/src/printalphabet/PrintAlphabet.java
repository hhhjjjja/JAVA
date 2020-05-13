/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printalphabet;

import java.util.Scanner;

public class PrintAlphabet {

    public static void main(String[] args) {
        System.out.print("알파벳 한 문자를 입력하세요>>");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char c = s.charAt(0);
        int ch = (int) c;
        for(int i='a';i<=ch;++i) {
            for(int j=i;j<=ch;++j) {
                char alpha=(char) j;
                System.out.print(alpha);
            }
            System.out.println();
        }
    }
}