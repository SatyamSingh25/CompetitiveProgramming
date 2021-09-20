package DynamicProgramming;

import java.util.*;

public class FairPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0, one = 0, two = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
                if (arr[i] == 1)
                    one++;
                else
                    two++;
            }
            int a1 = 0;
            if (two % 2 == 1)
                a1 += 2;
            if (a1 == 0) {
                // means there are even number of 2's
                if (one % 2 == 0)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            } else {
                // means there are odd number of 2's
                if (one >= 2) {
                    if ((one - 2) % 2 == 0) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                } else {
                    System.out.println("No");
                }
            }

        }
        sc.close();
    }
}
