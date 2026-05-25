import java.util.*;

public class A_Doremy_s_Paint_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                map.put(x, map.getOrDefault(x, 0) + 1);
            }

            if(map.size() > 2) {
                System.out.println("No");
            } else if(map.size() == 1) {
                System.out.println("Yes");
            } else {
                List<Integer> keys = new ArrayList<>(map.values());
                int a = keys.get(0);
                int b = keys.get(1);

                int diff = Math.abs(a - b);

                if (diff == 0) {
                    System.out.println("Yes");
                    continue;
                }

                if(Math.abs(a - b) == 1) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

            }

        }

        sc.close();
    }
}