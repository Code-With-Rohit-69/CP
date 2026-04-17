import java.util.Scanner;

public class A_Do_Not_Be_Distracted {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int[] freq = new int[26];
            boolean isSus = true;

            for(int i = 0; i < n; i++) {
                char ch = s.charAt(i);

                int index = ch - 'A';

                if(freq[index] > 0 && s.charAt(i) != s.charAt(i - 1))  {
                    isSus = !isSus;
                    break;
                }

                freq[ch - 'A']++;

            }

            if (isSus) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }


        }

        sc.close();
    }
}