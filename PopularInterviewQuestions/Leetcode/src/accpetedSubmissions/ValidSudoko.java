package accpetedSubmissions;

public class ValidSudoko {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    char ch = board[i][j];
                    if (!validateSudoko(board, i,j,ch))
                        return false;
                }
            }
        }
        return true;
    }
    
    public boolean validateSudoko(char [][] board, int i, int j, char ch){
        int lowi = (i/3) *3;
        int lowj = (j/3) *3;
        for(int k=0;k<9;k++){
            if(k!=i && board[k][j] != '.' && board[k][j] == ch) return false;
            if(k!=j && board[i][k] != '.' && board[i][k] == ch) return false;
            if((lowi + k/3) != i && (lowj + k%3) !=j && board[lowi + k/3][lowj + k%3] != '.' && board[lowi+ k/3][lowj + k%3] == ch) return false;
            
        }
        
    return true;
    }

}
