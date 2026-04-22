import java.util.Scanner;

public class A_Brain_s_Photos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int blackAndWhiteCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = sc.next().charAt(0);
                if(ch == 'B' || ch == 'W' || ch == 'G') {
                    blackAndWhiteCount++;
                }
            }
        }

        if (blackAndWhiteCount == n * m) {
            System.out.println("#Black&White");
        } else {
            System.out.println("#Color");
        }


        sc.close();
    }
}