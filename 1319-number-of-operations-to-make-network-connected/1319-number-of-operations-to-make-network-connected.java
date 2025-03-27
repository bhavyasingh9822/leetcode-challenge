class Solution {
    private int[] parent;
    private int[] rank;

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return;
        }

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]); 
    }

    public int makeConnected(int n, int[][] connections) {
        int comp = n;
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        Arrays.fill(rank,0);

        int m = connections.length;
        if(m < n-1){
            return -1;
        }
        for(int i=0;i<m;i++){
            int x = connections[i][0];
            int y = connections[i][1];
            int x_parent = find(x);
            int y_parent = find(y);
            if(x_parent != y_parent){
                union(x,y);
                comp--;
            }
        }
        return comp-1;
    }
}