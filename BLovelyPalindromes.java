import java.util.*;

/**
 * BLovelyPalindromes
 */
public class BLovelyPalindromes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(s + new StringBuilder(s).reverse().toString());

        sc.close();

    }
}