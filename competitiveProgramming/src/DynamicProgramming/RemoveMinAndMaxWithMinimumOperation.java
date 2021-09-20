package DynamicProgramming;
import java.util.*;
public class RemoveMinAndMaxWithMinimumOperation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- != 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int max = Integer.MIN_VALUE, maxIndex = 0, min = Integer.MAX_VALUE, minIndex = 0;
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
				if(max < arr[i]) {
					maxIndex = i;
					max = arr[i];
				}
				if(min > arr[i]) {
					minIndex = i;
					min = arr[i];
				}
			}
			int i =0 , j=n-1;
			int count = 0;
			while(i<=j) {
				if(arr[i] == min) {
					
				}
				else if(arr[j] == max){
					
				}
				
				if(arr[j] == min) {
					
				}
				else if(arr[j] == max) {
					
				}
			}
		}
	}

}
