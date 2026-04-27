import java.util.Scanner;

public class B_Ten_Words_of_Wisdom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            int res = 0;
            int q = 0;

            for(int i = 1; i <= n; i++) {
                int len = sc.nextInt();
                int quality = sc.nextInt();

                if(quality > q && len <= 10) {
                    res = i;
                    q = quality;
                }

            }
            
            System.out.println(res);

        }

        sc.close();
    }
}