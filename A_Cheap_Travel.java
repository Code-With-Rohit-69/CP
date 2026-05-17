import java.util.Scanner;

public class A_Cheap_Travel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();

        long minPrice = n * a;

        long specialRides = n / m;
        long rem = n % m;

        long total = (specialRides * b) + (rem * a);

        minPrice = Math.min(minPrice, total);

        long ceiled = (n + m - 1) / m;

        minPrice = Math.min(minPrice, ceiled * b);

        System.out.println(minPrice);

        sc.close();
    }
}