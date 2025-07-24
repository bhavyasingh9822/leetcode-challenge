class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allboards=new ArrayList<>();
        char[][] board=new char[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }

        queens(0,board,allboards);
        return allboards;
    }

    static void queens(int row,char[][]board,List<List<String>> allboards){
        if(row==board.length){
            allboards.add(display(board));
            return;
        }

        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                queens(row+1,board,allboards);
                board[row][col]='.';
            }
        }
    }

    static boolean isSafe(char[][]board,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        for(int i=row-1 , j=col-1 ; i>=0 && j>=0 ; i--,j--){
            if(board[i][j]=='Q') return false;
        }

        for(int i=row-1 , j=col+1; i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q') return false;
        }

        return true;

    }

    static List<String> display(char[][]board){
        List<String> result = new ArrayList<>();
        for(char[] row:board){
            result.add(new String(row));
        }
        return result;
    }

}