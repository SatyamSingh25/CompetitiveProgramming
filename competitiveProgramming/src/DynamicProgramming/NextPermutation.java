package DynamicProgramming;
/**
 * @Next_largest_permutaion
 * @First_break_point
 * @Second_break_point
 * @Reverse_array_after_first_break_point
 *
 * @SDE_SHEET
 */
public class NextPermutation {

	//finding next larger permutation
	public static void nextPermutation(int[] arr) {
		if(arr.length <= 1) {
			return;
		}
		
		int i=arr.length-2;
		while(i>=0 && arr[i] >= arr[i+1]) {
			i--;
		}
		if(i >= 0) {
			int j = arr.length-1;
		
			while(arr[j] <= arr[i])
				j--;

			//swaping both break point elements
			swap(arr, i, j);
		}
		//reversing array after first break point
		reverse(arr, i+1, arr.length-1);
	}
	
	//reversing the array
	public static void reverse(int[] arr, int start, int end) {
		while(start <= end) {
			swap(arr, start++, end--);
		}
	}
	//swaping the elements 
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	//Driver Code
	public static void main(String[] args) {
		int[] arr = new int[] {1,3,5,4,2};
		System.out.println("Default array:");
		for(int i: arr) {
			System.out.print(i+ " ");
		}
		nextPermutation(arr);
		System.out.println("\nNext permutation array:");
		for(int i: arr) {
			System.out.print(i+ " ");
		}
	}

}
