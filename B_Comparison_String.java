import java.util.Arrays;
import java.util.Scanner;

public class B_Comparison_String {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int count = 1;
            int max = 0;

            for(int i = 1; i < n; i++) {
                if(s.charAt(i) == s.charAt(i - 1)) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }

            max = Math.max(max, count);

            System.out.println(max + 1);

        }

        sc.close();
    }
}