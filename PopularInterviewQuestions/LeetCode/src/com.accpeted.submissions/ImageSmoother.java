package accpetedSubmissions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ImageSmoother {

	public static void main(String[] args) {
		// Ran on leetcode
	}
	
	public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                int sum=0;
                int count=0;
                
                // This is the important part. This is how you control where to go next,
                // hence not using a normal DFS.
                for(int row : new int[]{-1,0,1}){
                   for(int col : new int[]{-1,0,1}){  
                       if (isValid(i+row,j+col, M.length, M[0].length)){
                           count+=1;                         
                           sum += M[i+row][j+col];
                       }
                   } 
                }
                result[i][j] = sum/count;
            }
        }
        return result;
    }
    
    public boolean isValid(int i, int j, int rowL, int colL) {
        if(i<0 || j<0 || i>=rowL || j>=colL) return false;
        return true;
    }

}




class Comp implements Comparator<Integer>{

	HashMap<Integer,Integer> map;
Comp(HashMap<Integer,Integer> map){
	this.map = map;
}

@Override
public int compare(Integer o1, Integer o2) {
	return this.map.get(o2).compareTo(this.map.get(o1));
}
}
