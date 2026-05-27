import java.util.Scanner;

public class B_Ilya_and_Queries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int n = s.length();

        int[] prefix = new int[n];

        for (int i = 1; i < n; i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        int m = sc.nextInt();

        while (m-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            
            System.out.println(prefix[r - 1] - prefix[l - 1]);

        }

        sc.close();
    }
}