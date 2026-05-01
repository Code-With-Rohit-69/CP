import java.util.Scanner;

public class A_Problem_Generator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            String s = sc.next();

            int[] freq = new int[7];

            for (char c : s.toCharArray()) {
                freq[c - 'A']++;
            }

            int count = 0;

            for (int i = 0; i < 7; i++) {
                if (freq[i] < m) {
                    count += m - freq[i];
                }
            }

            System.out.println(count);

        }

        sc.close();
    }
}