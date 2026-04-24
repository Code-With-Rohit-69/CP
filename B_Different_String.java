import java.util.*;

public class B_Different_String {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String sorted = new String(arr);

            if (sorted.equals(s)) {
                sorted = new StringBuilder(sorted).reverse().toString();
            }

            if (sorted.equals(s)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                System.out.println(sorted);
            }
        }

        sc.close();
    }
}