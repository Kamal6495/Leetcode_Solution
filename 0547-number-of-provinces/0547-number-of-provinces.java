class Solution {
  public int findCircleNum(int[][] isConnected) {
    int V = isConnected.length;
    List<Integer>[] adj = new ArrayList[V];
    for (int i = 0; i < V; i++) {
      adj[i] = new ArrayList<>();
    }

    // Fill adjacency list
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (isConnected[i][j] == 1 && i != j) {
          adj[i].add(j);
        }
      }
    }
    int cnt = 0;
    boolean vis[] = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!vis[i]) {
        cnt++;
        dfs(adj, i, vis);
      }

    }
    return cnt;
  }

  public void dfs(List<Integer>[] adj, int src, boolean vis[]) {
    vis[src] = true;
    for (int num : adj[src]) {
      if (!vis[num])
        dfs(adj, num, vis);
    }
  }
}