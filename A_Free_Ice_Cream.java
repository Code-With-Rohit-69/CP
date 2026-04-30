import java.util.Scanner;

public class A_Free_Ice_Cream {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long x = sc.nextLong();
        int count = 0;

        for (int i = 0; i < n; i++) {
            char ch = sc.next().charAt(0);
            long num = sc.nextLong();

            if(ch == '-' && x < num) {
                count++;
                continue;
            }

            if (ch == '+') {
                x += num;
            } else {
                x -= num;
            }

        }

        System.out.println(x + " " + count);

        sc.close();
    }
}