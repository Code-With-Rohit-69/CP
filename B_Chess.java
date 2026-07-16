import java.util.Scanner;

/**
 * B_Chess
 */
public class B_Chess {

    public static boolean valid(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String rook = sc.next();
        String knight = sc.next();

        int[][] moves = {
                { 2, 1 },
                { 2, -1 },
                { -2, 1 },
                { -2, -1 },
                { 1, 2 },
                { 1, -2 },
                { -1, 2 },
                { -1, -2 }
        };

        int rx = rook.charAt(0) - 'a';
        int ry = rook.charAt(1) - '1';

        int kx = knight.charAt(0) - 'a';
        int ky = knight.charAt(1) - '1';

        int count = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if ((i == rx && j == ry) || (i == kx && j == ky)) {
                    continue;
                }

                if (i == rx || j == ry) {
                    continue;
                }

                boolean valid = true;

                for (int[] move : moves) {
                    int x = move[0] + i;
                    int y = move[1] + j;

                    if ((x == rx && y == ry) || (x == kx && y == ky)) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    count++;
                }

            }
        }

        System.out.println(count);

        sc.close();
    }
}