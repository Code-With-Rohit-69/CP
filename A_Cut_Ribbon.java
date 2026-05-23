import java.util.HashSet;
import java.util.Scanner;

public class A_Cut_Ribbon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();
        
        set.add(a);
        set.add(b);
        set.add(c);

        int len = n / a;
        int rem = n % a;

        if (set.contains(rem)) {
            len += rem;
        }
        

        sc.close();
    }
}