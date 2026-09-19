import java.io.*;
import java.util.*;

/**
 * ACloningToys
 */
public class ACloningToys {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int copy = y - 1;

        System.out.println(x % 2 == copy % 2 && copy <= x && copy != 0 || (x == 0 && y == 1) ? "Yes" : "No");

    }
}