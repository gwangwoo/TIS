import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_9728 {
  static int T;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    for(int tc = 1; tc <= T ; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int expect = Integer.parseInt(st.nextToken());
      int arr[] = new int[N];
      st = new StringTokenizer(br.readLine());
      for(int i = 0 ; i < N ; i++) {
        int val = Integer.parseInt(st.nextToken());
        arr[i] = val;
      }
      int ans = 0;
      for(int i = 0 ; i < N/2 ; i++) {
        if(arr[i] + arr[N-i-1] == expect) ans++;
      }
      System.out.println("Case #"+tc+": " +ans);
    }
  }
}
