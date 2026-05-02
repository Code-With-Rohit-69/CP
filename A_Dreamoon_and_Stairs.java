import java.util.Scanner;

public class A_Dreamoon_and_Stairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        if (m > n) {
            System.out.println(-1);
        } else {
            double takingTwoSteps = Math.ceil(n / 2.0);

            if (takingTwoSteps % m == 0) {
                System.out.println((int) takingTwoSteps);
            } else {

                while (true) {
                    takingTwoSteps++;

                    if (takingTwoSteps % m == 0) {
                        System.out.println((int) takingTwoSteps);
                        break;
                    }

                }

            }

        }

        sc.close();
    }
}