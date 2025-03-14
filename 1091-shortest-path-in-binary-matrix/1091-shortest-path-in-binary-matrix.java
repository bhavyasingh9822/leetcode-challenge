class tuple{
    int a;
    int b;
    int c;
    tuple(int _a,int _b,int _c){
        this.a = _a;
        this.b = _b;
        this.c = _c;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
     int n = grid.length;
     int m = grid[0].length;
     if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
     if(n-1 == 0) return 1;
     int[][] dis = new int[n][m];
     Queue<tuple> queue = new LinkedList<>();
     for(int[] i:dis){
         Arrays.fill(i,(int)1e9);
     }
     dis[0][0] = 1;
     queue.add(new tuple(1,0,0));
     int[] dr = {0,1,-1,0,1,-1,1,-1};
     int[] dc = {1,0,0,-1,1,1,-1,-1};
     while(!queue.isEmpty()){
         tuple it = queue.poll();
         int d = it.a;
         int r = it.b;
         int c = it.c;
         for(int i=0; i<8; i++){
             int nrow = r + dr[i];
             int ncol = c + dc[i];
             if(nrow >=0 && nrow <n && ncol >=0 && ncol < m && grid[nrow][ncol] == 0 && d+1 < dis[nrow][ncol]){
                 dis[nrow][ncol] = 1 + d;
                 if(nrow == n-1 && ncol == n-1) return d + 1;
                 queue.add(new tuple(d+1,nrow,ncol));
             }
         }
     }
     return -1;
    }
}