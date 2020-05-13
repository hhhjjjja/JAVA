package phonmanagerclass;

import java.util.Scanner;

class Phone {
    public String name;
    public String tel;
    
    Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }
}
public class PhonManagerClass {
    public static void main(String[] args) {
        Scanner save = new Scanner(System.in);
        System.out.print("인원 수 >> ");
        int peoplecnt = save.nextInt();
        Phone [] phone = new Phone[peoplecnt];
        for(int i=0;i<peoplecnt;++i) {
            System.out.print("이름과 전화번호(번호는 연속적으로 입력) >> ");
            String name = save.next();
            String tel = save.next();
            phone[i] = new Phone(name, tel);
        }
        System.out.println("저장되었습니다...");
        while(true) {
            System.out.print("검색할 이름>> ");
            String search = save.next();
            if(search.equals("exit")) {
                break;
            }
            for(int i=0;i<peoplecnt;++i) {
                if(search.equals(phone[i].name)) {
                    System.out.println(search + "의 번호는 " + phone[i].tel + "입니다.");
                    break;
                }
                if((! search.equals(phone[i].name)) && (i==peoplecnt-1)) {
                    System.out.println(search + "이 없습니다.");
                }
            }
        }
    }
}