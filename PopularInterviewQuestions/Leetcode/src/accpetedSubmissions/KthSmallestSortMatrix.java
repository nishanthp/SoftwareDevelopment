package accpetedSubmissions;

public class KthSmallestSortMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 
	public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix[0].length-1];
        while(low < high){
            int mid = (low + high)/2;
            //global mid;
            int count = 0;
            int j = matrix[0].length-1;
            for(int i=0;i<matrix.length;i++){
                while(j>=0 && matrix[i][j] > mid) j--;
                // number of elements lower than mid (count) < kth smallest element(repeated for each row). So move right else left.
                count += (j+1);
            }
            if(count < k) low = mid+1;
            else high = mid;
        }
        return low;
    }

}
