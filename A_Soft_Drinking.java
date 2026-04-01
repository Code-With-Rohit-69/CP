import java.util.Scanner;

public class A_Soft_Drinking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        int nl = sc.nextInt();
        int np = sc.nextInt();

        int totalDrink = k * l;
        int each_friend_can_get = totalDrink / nl;

        int total_lime_slices = c * d;

        int total_gram_of_salt_each_friend_can_get = p / np;

        int res = Math.min(each_friend_can_get, Math.min(total_lime_slices, total_gram_of_salt_each_friend_can_get)) / n;

        System.out.println(res);
        

        sc.close();
    }
}