import java.util.HashSet;
import java.util.Scanner;

public class B_ICPC_Balloons {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            HashSet<Character> set = new HashSet<>();

            String s = sc.next();

            for(char ch : s.toCharArray()) {
                set.add(ch);
            }

            System.out.println(n + set.size());

        }

        sc.close();
    }
}