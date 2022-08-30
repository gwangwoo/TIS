import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _boj_1956 {
  static int V, E;
  static int dp[][];
  static final int INF = (int) 1e9;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    dp = new int[V + 1][V + 1];
    for (int i = 1; i <= V; i++) Arrays.fill(dp[i], INF);
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());
      dp[s][e] = value;
    }

    for (int k = 1; k <= V; k++) {
      for (int i = 1; i <= V; i++) {
        for (int j = 1; j <= V; j++) {
          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
        }
      }
    }
    int result = INF;
    for (int i = 1; i <= V; i++) {
      result = Math.min(dp[i][i], result);
    }
    if (result == INF) System.out.println(-1);
    else System.out.println(result);
  }
}
