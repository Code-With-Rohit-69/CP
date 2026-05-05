import java.util.Scanner;

public class A_Jzzhu_and_Children {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int max = -1, maxIndex = -1;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            int round = (int) Math.ceil((double) num / m);

            if (max <= round) {
                max = round;
                maxIndex = i + 1;
            }

        }

        System.out.println(maxIndex);

        sc.close();
    }
}