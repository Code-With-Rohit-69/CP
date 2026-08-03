import java.util.Scanner;

public class A_Arpa_s_hard_exam_and_Mehrdad_s_naive_cheat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 0) {
            System.out.println(1);
        } else {
            int rem = n % 4;

            if (rem == 1) {
                System.out.println(8);
            } else if (rem == 2) {
                System.out.println(4);
            } else if (rem == 3) {
                System.out.println(2);
            } else if (rem == 0) {
                System.out.println(6);
            }
        }

        sc.close();
    }
}