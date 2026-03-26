import java.util.*;

public class A_Don_t_Try_to_Count {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            String x = sc.next(), s = sc.next();

            int count = 0;

            int times = 5;

            while(times-- > 0 && x.indexOf(s) == -1) {
                x = x + x;
                count++;
            }

            System.out.println(x.indexOf(s) == -1 ? -1 : count);

        }

        sc.close();
    }
}
