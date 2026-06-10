import java.util.Scanner;

public class B_Palindrome_Twelve_and_Two_Terms {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        int[] pallindrome = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 22, 11};

        while(tt-- > 0) {
            long n = sc.nextLong();

            int r = (int) (n % 12);
            int a = pallindrome[r];

            if(a > n) {
                System.out.println(-1);
            } else {
                System.out.println(a + " " + (n - a));
            }


        }

        sc.close();
    }
}
