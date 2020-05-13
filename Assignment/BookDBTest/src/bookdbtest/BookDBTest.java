package bookdbtest;

import java.util.Scanner;

public class BookDBTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookDB bookdb = new BookDB();
        int mnum=0;
        String booktitle;
        while(true) {
            System.out.print("책 추가 : 1, 책 삭제 : 2, 목록출력 : 3, 종료 : -1 >>");
            mnum=scanner.nextInt();
            if(mnum == -1) {
                break;
            }
            switch(mnum) {
                case 1:
                    System.out.print("책 제목 >>");
                    booktitle=scanner.next();
                    bookdb.addBook(booktitle);
                    break;
                case 2:
                    System.out.print("삭제할 책 제목 >>");
                    booktitle=scanner.next();
                    bookdb.deleteBook(booktitle);
                    break;
                case 3:
                    bookdb.printBooks();
                    int a = bookdb.size();
                    System.out.println("현재 책 수 : " + a);
                    break;
            }
        }    
    }
}