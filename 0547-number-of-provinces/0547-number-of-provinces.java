class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] vis = new boolean[V];
        int cnt = 0;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(isConnected, i, vis); // explore all connected cities
            }
        }
        return cnt;
    }

    private void dfs(int[][] isConnected, int src, boolean[] vis) {
        vis[src] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[src][j] == 1 && !vis[j]) {
                dfs(isConnected, j, vis);
            }
        }
    }
}
