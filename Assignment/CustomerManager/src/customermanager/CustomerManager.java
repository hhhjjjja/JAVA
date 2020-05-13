package customermanager;

import java.util.*;

public class CustomerManager {
    public static void main(String[] args) {
        Integer cpoint = null;
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> customermanager = new HashMap<String, Integer>();
        System.out.println("** 포인트 관리 프로그램입니다 **");
        while(true) {
            System.out.print("이름과 포인트 입력>> ");
            String name = scanner.next();
            int point = scanner.nextInt();
            cpoint = customermanager.get(name);
            if (cpoint != null) {
                point += cpoint;
            }
            customermanager.put(name, point);
            Set<String> kname = customermanager.keySet();
            Iterator<String> it = kname.iterator();
            while(it.hasNext()) {
                String prtname = it.next();
                int prtpoint = customermanager.get(prtname);
                System.out.println("(" + prtname + ", " + prtpoint + ")");
            }
        }
    }
}