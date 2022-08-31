import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _boj_1058 {
  static int N;
  static int dp[][];
  static final int INF = (int)1e9;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    dp = new int[N+1][N+1];
    for(int i = 1 ; i <= N ; i++) {
      String str = br.readLine();
      for(int j = 1 ; j <= N ; j++) {
        char ch = str.charAt(j-1);
        if(i == j) dp[i][j] = 0;
        else  if(ch == 'N') dp[i][j] = INF;
        else dp[i][j] = 1;
      }
    }

    for(int k = 1 ; k <= N ; k++) {
      for(int i = 1 ; i <= N ; i++) {
        for(int j = 1 ; j <= N ; j++) {
          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
        }
      }
    }
    int answer = 0;
    for(int i = 1 ; i <= N; i++) {
      int cnt = 0;
      for(int j = 1 ; j <= N ; j++) {
        if(i == j) continue;
        if(dp[i][j] != INF && dp[i][j] <= 2) cnt++;
      }
      answer = Math.max(answer, cnt);
    }
    System.out.println(answer);
  }
}
