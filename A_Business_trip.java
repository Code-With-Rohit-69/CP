import java.util.Arrays;
import java.util.Scanner;

public class A_Business_trip {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        int[] months = new int[12]; 

        for (int i = 0; i < 12; i++) {
            months[i] = sc.nextInt();
        }

        Arrays.sort(months);

        if (k == 0) {
            System.out.println(0);
            sc.close();
            return;
        }

        int size = 0;

        for (int i = 11; i >= 0; i--) {
            size += months[i];

            if (size >= k) {
                System.out.println(12 - i);
                sc.close();
                return;
            }

        }

        System.out.println(-1);

        sc.close();
    }
}