package gfg;
/**
 * @Minimum_Swaps_To_Sort_Array_increasing_order
 */
//https://practice.geeksforgeeks.org/problems/minimum-swaps/1/?track=amazon-graphs&batchId=192#
import java.util.Arrays;
import java.util.Scanner;
public class MinimumSwapToSort {
	public static int minSwapToSort(int n, int[] arr) {
		int[] b = arr.clone();
		Arrays.sort(b);
		int count = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] != b[i]) {
				count++;
				int x = i+1;
				while(arr[x] != b[i]) {
					x++;
				}
				arr[x] = arr[i];
				arr[i] = b[i];
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(minSwapToSort(n, arr));
	}

}
