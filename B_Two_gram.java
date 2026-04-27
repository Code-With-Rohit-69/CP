import java.util.HashMap;
import java.util.Scanner;

public class B_Two_gram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 1; i < n; i++) {
            String substr = s.substring(i - 1, i + 1);
            map.put(substr, map.getOrDefault(substr, 0) + 1);
        }

        int f = 0;
        String ans = "";

        for (String key : map.keySet()) {
            if (map.get(key) > f) {
                f = map.get(key);
                ans = key;
            }
        }

        System.out.println(ans);

        sc.close();
    }
}