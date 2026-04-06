import java.util.HashMap;
import java.util.Scanner;

public class B_Chemistry {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();;
            String s = sc.next();

            /*
                - I have to calculate the frequency of each characters
                - 
            */

            HashMap<Character, Integer> map = new HashMap<>();

            for(char ch : s.toCharArray()){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            if (map.size() == 1) {
                System.out.println("YES");
                continue;
            }

            int even = 0, odd = 0;

            for (char key : map.keySet()) {
                if ((map.get(key) & 1) == 0) {
                    even++;
                } else {
                    odd++;
                }
            }

            if (k == 0) {
                if (odd > 1) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            } else {
                if (odd - k > 1) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }

        }

        sc.close();
    }
}