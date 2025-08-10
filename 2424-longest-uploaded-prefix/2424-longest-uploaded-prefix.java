class LUPrefix {
    int arr[];
    int n, longest= 1;
    public LUPrefix(int n) {
        this.n = n;
        arr = new int[n + 1];
    }
    
    public void upload(int video) {
        arr[video] = video;
        while(longest <= n && arr[longest] == longest) longest++;
    }
    
    public int longest() {
        return longest - 1;
    }

}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */