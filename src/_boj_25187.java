import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_25187 {
  static int arr[];
  static int N,M,Q;
  static int p[];

  static int find(int a) {
    if(p[a] < 0) return a;
    else return find(p[a]);
  }

  static boolean union(int a, int b) {
    a = find(a);
    b = find(b);
    if(a == b) return false;

    if(p[a] < p[b]) {
      p[a] += p[b];
      arr[a] += arr[b];
      p[b] = a;
    }else {
      p[b] += p[a];
      arr[b] += arr[a];
      p[a] = b;
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());
    arr = new int[N+1];
    p = new int[N+1];
    for(int i = 1 ; i <= N ; i++) p[i] = -1;
    st = new StringTokenizer(br.readLine());
    for(int i = 1 ; i <= N ; i++) {
      int val = Integer.parseInt(st.nextToken());
      if(val == 0) arr[i] = -1;
      else arr[i] = val;
    }

    for(int i = 0 ; i < M ; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      union(u,v);
    }

    for(int i = 0 ; i < Q ; i++) {
      int val = Integer.parseInt(br.readLine());
      int root = find(val);
      if(arr[root] > 0) System.out.println(1);
      else System.out.println(0);
    }
  }
}
