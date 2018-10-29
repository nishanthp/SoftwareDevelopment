package accpetedSubmissions;

public class FindModeBT {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Constant space (Not considering recursion). Two passes through binary tree.
	int curVal=0;
    int count=0;
    int [] result;
    int modes=0;
    int maxCount=0;
    public int[] findMode(TreeNode root) {
        traverse(root);
        result = new int[modes];
        modes=0;
        count=0;
        traverse(root);
        return result;
    }
    
    public void traverse(TreeNode root){
        if(root ==null) return;
        traverse(root.left);
        handleVal(root.val);
        traverse(root.right);
    }
    
    // this is the important part.
    public void handleVal(int val){
        if(val != curVal){
            curVal = val;
            count = 0;
        }
        count+=1;
        if(count>maxCount){
            maxCount = count;
            modes =1;
        }else if(count==maxCount){
            if(result!=null) result[modes] = curVal;
            modes +=1;
        }
    }

}
