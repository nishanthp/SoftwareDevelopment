package practise;

public class TwistedBinarySearch {

	// Binary search is used to search an element in array. So the mid is compared with the target value.
	public static void main(String[] args) {
		//Binary search to find lowest element in array.
		int [] arr = {4,5,1,2,3};
		
		int left = 0;
		int right = arr.length-1;
		// This is working as both low and high are peaks, and we are converging onto a low. Similarly if
		// we have a array = {1,2,7,3,4}, low and high are lows intially, we can find the peak element.
		// allow right to converge onto to left or vice versa.
		while(left < right){
			int mid = (left+right)/2;
			if(arr[mid]>arr[right]) left = mid+1;
			else right = mid;
		}
		System.out.println(arr[left]);
		
		left = 0;
		right = arr.length-1;
		int [] arr1 = {1,2,7,3,4};
		while(left < right){
			int mid = (left+right)/2;
			if(arr1[mid]>arr1[right]) right = mid;
			else left = mid+1;
		}
		System.out.println(arr1[right]);
	}

}
