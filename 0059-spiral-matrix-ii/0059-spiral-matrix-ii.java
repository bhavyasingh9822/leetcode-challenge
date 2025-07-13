class Solution {
    public int[][] generateMatrix(int n) {
        int value = 1;
        int[][] arr = new int[n][n];
        int top = 0 ,left = 0 ,right = arr[0].length - 1, bottom = arr.length - 1;
        while(top<=bottom && left <= right){
            for(int i=left;i<=right;i++){
                arr[top][i] = value++;
            }
            top++;
             for(int i=top;i<=bottom;i++){
                 arr[i][right] =value++;
            }
            right--;
            if(top <= bottom){
                for(int i=right;i>=left;i--){
                arr[bottom][i] =value++;
            }
            bottom--;
            }
            if(left <= right){
                for(int i=bottom;i>=top;i--){
                arr[i][left] =value++;
            }
            left++;
            }
        }
        return arr;
    }
}