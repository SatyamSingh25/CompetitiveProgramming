package DynamicProgramming;

import java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[] { 100, 20, 10, 5, 1 };
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = ans + (n / arr[i]);
            n %= arr[i];
        }
        System.out.println(ans);
        sc.close();
    }

}
