import java.util.Arrays;
import java.util.Scanner;

public class B_Taxi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        int four = 0;
        int three = 0;
        int two = 0;
        int one = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] == 3) {
                three++;
            } else if (arr[i] == 4) {
                four++;
            } else if (arr[i] == 2) {
                two++;
            } else {
                one++;
            }
        }

        int cars = four;

        // 3 with 1

        int rem = 0;

        if (three == one) {
            cars += three;
        } else if (three > one) {
            cars += one;
            three -= one;
            cars += three;
        } else {
            cars += three;
            rem = one - three;
        }

        // only 2 and remaining 1s

        int multiple2s = two * 2;

        cars += multiple2s / 4;

        rem += multiple2s % 4;

        // remaining

        if (rem > 0) {
            if (rem % 4 == 0) {
                cars += rem / 4;
            } else {
                cars += rem / 4 + 1;
            }
        }

        System.out.println(cars);

        sc.close();
    }
}

// 1 1 2 2 3 3 4 4