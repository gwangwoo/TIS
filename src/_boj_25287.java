import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_25287 {
  static int T;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    T = Integer.parseInt(br.readLine());
    while(T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int arr[] = new int[N];
      st = new StringTokenizer(br.readLine());
      for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
      int before = Math.min(arr[0], N-arr[0]+1);
      boolean flag = false;
      for(int i = 1 ; i < N ; i++) {
        int min = Math.min(arr[i], N-arr[i]+1);
        int max = Math.max(arr[i], N-arr[i]+1);

        if(before <= min) {
          before = min;
        }else if(before <= max) {
          before = max;
        }else {
          flag = true;
          break;
        }
      }
      System.out.println(flag ? "NO" : "YES");
    }
  }
}
