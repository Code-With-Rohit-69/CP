import java.util.Scanner;

public class A_Vlad_and_the_Best_of_Five {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            int A = 0, B = 0;

            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'A') A++;
                else B++;
            }

            System.out.println(A > B ? 'A' : 'B');

        }
        

        sc.close();
    }
}