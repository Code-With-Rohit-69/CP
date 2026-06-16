import java.util.HashSet;
import java.util.Scanner;

public class B_Tatar_TV_Show {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            char[] ch = s.toCharArray();
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if(ch[i] == '1') {
                    int nextIndex = i + k;

                    if (nextIndex >= n) {
                        valid = false;
                        break;
                    }

                    if (ch[nextIndex] == '0') {
                        ch[nextIndex] = '1';
                    } else {
                        ch[nextIndex] = '0';
                    }
                    
                    ch[i] = '0';
                }
            }

            System.out.println(valid ? "YES" : "NO");

            
            // int startIndex = n - k;

            // HashSet<Integer> index = new HashSet<>();

            // for (int i = 0; i < startIndex; i++) {
            //     if (s.charAt(i) == '1') {
            //         index.add(i);
            //     }
            // }

            // for(int i = startIndex; i <= n - 1; i++) {
            //     char ch = s.charAt(i);

            //     if (ch == '1') {
            //         int prevIndex = i - k;

            //         if (prevIndex < 0 || s.charAt(prevIndex) != '1') {
            //             valid = false;
            //             break;
            //         } else {
            //             if (index.contains(i)) {
            //                 index.remove(i);
            //             }
            //             index.remove(prevIndex);
            //         }
            //     }
            // }

            // System.out.println(valid && index.size() == 0 ? "YES" : "NO");

        }

        sc.close();
    }
}


/*

25

1 1
0
1 1
1
2 1
00
2 2
00
2 1
10
2 2
10
2 1
01
2 2
01
2 1
11
2 2
11
3 1
000
3 2
000
3 3
000
3 1
100
3 2
100
3 3
100
3 1
010
3 2
010
3 3
010
3 1
110
3 2
110
3 3
110
3 1
001
3 2
001
3 3
001

output

YES
NO
YES
YES
NO
NO
NO
NO
YES
NO
YES
YES
YES
NO
NO
NO
NO
NO
NO
YES
NO
NO
NO
NO
NO


*/