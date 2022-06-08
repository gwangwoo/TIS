import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_21921 {
  static int N, X;
  static int arr[];
  static int psum[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    arr = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
    psum = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      psum[i] = psum[i - 1] + arr[i];
      if (i - X < 0) continue;
      psum[i] -= arr[i - X];
    }
    int answer = 0;
    int cnt = 0;
    for (int i = 1; i <= N; i++) {
      if (answer < psum[i]) {
        answer = psum[i];
        cnt = 1;
      } else if (answer == psum[i]) cnt++;
    }
    if (answer == 0) {
      System.out.println("SAD");
    } else {
      System.out.println(answer);
      System.out.println(cnt);
    }
  }
}
