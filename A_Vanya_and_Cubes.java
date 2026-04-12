import java.util.Scanner;

public class A_Vanya_and_Cubes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cubes = 0;
        int i = 1;
        int count = 0;

        while (n > 0) {
            cubes += i;
            count++;
            i++;
            n -= cubes;

            if(n - (cubes + i) < 0) break;
        }

        System.out.println(count);

        sc.close();
    }
}