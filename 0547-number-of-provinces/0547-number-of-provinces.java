class Solution {
  public int findCircleNum(int[][] isConnected) {
    return countProvinces(isConnected);
  }

  public int countProvinces(int[][] isConnected) {
    int v = isConnected.length;
    int T[][] = WarshallClosure(isConnected, v);

    int cnt = 0;
    boolean vis[] = new boolean[v];

    for (int i = 0; i < v; i++) {
      if (!vis[i]) {
        cnt++;
        for (int j = 0; j < v; j++) {
          if (T[i][j] == 1 || T[j][i] == 1)
            vis[j] = true;
        }
      }
    }
    return cnt;
  }

  public int[][] WarshallClosure(int[][] isConnected, int v) {
    int T[][] = new int[v][v];

    for (int i = 0; i < v; i++) {
      for (int j = 0; j < v; j++) {
        if (isConnected[i][j] == 1)
          T[i][j] = 1;
        else
          T[i][j] = 0;
      }
    }

    for (int k = 0; k < v; k++) {
      for (int i = 0; i < v; i++) {
        for (int j = 0; j < v; j++) {
          if (T[i][j] == 1 || (T[i][k] == 1) && T[k][j] == 1)
            T[i][j] = 1;
          else
            T[i][j] = 0;
        }
      }
    }
    return T;
  }
}