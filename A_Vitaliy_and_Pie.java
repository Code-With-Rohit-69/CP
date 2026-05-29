import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A_Vitaliy_and_Pie {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        Map<Character, Integer> map = new HashMap<>();

        int key = 0;

        for (char ch : s.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            } else {
                char c = Character.toLowerCase(ch);

                if (!map.containsKey(c) || map.get(c) <= 0) {
                    key++;
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }

        System.out.println(key);

        sc.close(); 
    }
}