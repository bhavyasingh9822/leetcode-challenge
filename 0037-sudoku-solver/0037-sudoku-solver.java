class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board,0,0);
    }
    private boolean backtrack(char[][] board,int row,int col){
        if(col==9){
            row++;
            col=0;
        }
        if(row==9){
            return true;
        }
        if(board[row][col]!='.'){
            return backtrack(board,row,col+1);
        }
        else{
            for(char val='1';val<='9';val++){
                if(isItSafe(board,row,col,val)){
                    board[row][col]=val;
                    boolean ans=backtrack(board,row,col+1);
                    if(ans){
                        return true;
                    }
                    board[row][col]='.';
                }
            }
        }
        return false;
    }
    private boolean isItSafe(char[][] board,int row,int col,char val){
        for(int i=0;i<9;i++){
            if(board[row][i]==val){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==val){
                return false;
            }
        }
        int r=row-row%3;
        int c=col-col%3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(board[i][j]==val){
                    return false;
                }
            }
        }
        return true;
    }
}