import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _boj_15829 {
  static int L;
  static final int r = 31;
  static final int M  = 1234567891;
  static long dp[] = new long[51];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    L = Integer.parseInt(br.readLine());
    String str = br.readLine();
    dp[0] = 1;
    for(int i = 1 ; i <= 50 ; i++) {
      dp[i] = (r * dp[i-1]) % M;
    }

    long answer = 0;
    for(int i = 0 ; i < L ; i++) {
      int val = str.charAt(i)-'a'+1;
      answer = (answer + val * dp[i] % M) % M;
    }
    System.out.println(answer);
  }
}
