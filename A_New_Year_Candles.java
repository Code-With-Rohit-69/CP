import java.util.Scanner;

public class A_New_Year_Candles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt();

        int hours = 0;
        int burnedCandles = 0;

        while (a != 0) {
            hours++;
            burnedCandles++;

            if (burnedCandles == b) {
                burnedCandles = 0;
                a++;
            }

            a--;

        }

        System.out.println(hours);

        sc.close();
    }
}