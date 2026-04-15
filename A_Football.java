import java.util.*;

public class A_Football {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        String ans = "";

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (max < map.get(s)) { 
                max = map.get(s);
                ans = s;
            }
        }

        System.out.println(ans);

        sc.close();
    }
}