package hashmapnation;
import java.util.*;

public class HashMapNation {
    public static void main(String[] args) {
        int maxPop = 0;
        Scanner scanner= new Scanner(System.in);
        String maxSt = null;
        HashMap<String, Integer> nation = new HashMap<String, Integer>();
        System.out.println("나라 이름과 인구를 5개 입력하세요.(예: Korea 5000)");
        for(int i=0;i<5;++i) {
            System.out.print("나라 이름, 인구 >> ");
            String state = scanner.next();
            int popul = scanner.nextInt();
            nation.put(state, popul);
        }
        Set <String> statname = nation.keySet();
        Iterator<String> niter = statname.iterator();
        while(niter.hasNext()) {
            String name = niter.next();
            int p = nation.get(name);
            if(maxPop < p) {
                maxSt = name;
                maxPop = p;
            }
        }
        System.out.println("제일 인구가 많은 나라는 ("+maxSt+", "+maxPop+")");
    }
}