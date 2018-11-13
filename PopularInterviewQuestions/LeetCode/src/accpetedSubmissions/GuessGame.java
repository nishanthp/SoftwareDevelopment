package accpetedSubmissions;

public class GuessGame {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	//Normal binary search
	public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low<=high){
        	          // This is usually used when adding low + high crosses the integer max value and you are forced to use int. 
            int mid = low+(high-low)/2;
            int res = guess(mid);
            if(res == 0) return mid;
            if(res > 0) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
	
	// this is given.
	public int guess(int i) {
		return 0;
	}
	

}
