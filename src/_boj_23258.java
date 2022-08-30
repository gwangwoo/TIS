import java.io.*;
import java.util.StringTokenizer;

public class _boj_23258 {
  static int N, Q;
  static int dp[][][];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());
    dp = new int[N + 1][N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        if (i == j) {
          st.nextToken();
          continue;
        }
        dp[0][i][j] = Integer.parseInt(st.nextToken());
        if (dp[0][i][j] == 0) dp[0][i][j] = (int) 1e9;
      }
    }

    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          dp[k][i][j] = Math.min(dp[k - 1][i][j], dp[k - 1][i][k] + dp[k - 1][k][j]);
        }
      }
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while(Q-- > 0) {
      st = new StringTokenizer(br.readLine());
      int C = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      bw.write((dp[C-1][s][e] == (int)1e9 ? -1 : dp[C-1][s][e]) + "\n");
    }
    bw.flush();
    bw.close();
  }
}
