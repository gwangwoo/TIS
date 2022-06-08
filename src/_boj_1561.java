import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_1561 {
  static int N,M;
  static int arr[];

  private static boolean check(long mid) {
    long person = M;
    for(int i = 0 ; i < M ; i++) {
      person += mid / arr[i];
    }
    if(person >= N) return true;
    return false;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[M];
    st = new StringTokenizer(br.readLine());
    for(int i = 0 ; i < M ; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    if(N <= M) {
      System.out.println(N);
      return;
    }

    long left = 1;
    long right = (long)6e10;
    long time = 0;
    while(left <= right) {
      long mid = (left + right) >> 1;
      if(check(mid)) {
        time = mid;
        right = mid -1;
      }else {
        left = mid + 1;
      }
    }
    long before = time - 1;
    long child = M;
    for(int i = 0 ; i < M ; i++) {
      child += before / arr[i];
    }
    long leftChild = N - child;
    long cnt = 0;
    int idx = 0;

    for(int i = 0 ; i < M ; i++) {
      if(((time) / arr[i]) == (before / arr[i])) continue;
      idx = i+1;
      cnt++;
      if(cnt == leftChild) break;
    }
    System.out.println(idx);
  }
}
