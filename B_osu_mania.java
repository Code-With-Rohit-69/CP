    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    import java.util.Scanner;

    public class B_osu_mania {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                List<Integer> arr = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    String s = sc.next();

                    for (int j = 0; j < s.length(); j++) {
                        if (s.charAt(j) == '#') {
                            arr.add(j + 1);
                        }
                    }
                }

                Collections.reverse(arr);

                for (int i = 0; i < n; i++) {
                    System.out.print(arr.get(i) + " ");
                }

                System.out.println();

            }

            sc.close();
        }
    }