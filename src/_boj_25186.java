import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_25186 {
  public static int N, max;
  public static int arr[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[100001];
    StringTokenizer st = new StringTokenizer(br.readLine());
    if(N == 1) {
      System.out.println("Happy");
      return;
    }
    for(int i = 0 ; i < N ; i++) {
      int val = Integer.parseInt(st.nextToken());
      arr[val]++;
      max = Math.max(arr[val], max);
    }

    if(N/2 >= max) {
      System.out.println("Happy");
    }else {
      System.out.println("Unhappy");
    }
  }
}