import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_24391 {
  static int N,M;
  static int p[];

  static int find(int a) {
    if(p[a] < 0) return a;
    return find(p[a]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    p = new int[N+1];
    for(int i = 1 ; i <= N ; i++) p[i] = -1;

    for(int i = 0 ; i < M ; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      union(u,v);
    }
    st = new StringTokenizer(br.readLine());
    int q = st.countTokens()-1;
    int now = Integer.parseInt(st.nextToken());
    int answer = 0;
    while(q-- > 0) {
      int next = Integer.parseInt(st.nextToken());
      if(find(now) != find(next)) answer++;
      now = next;
    }
    System.out.println(answer);
  }

  private static boolean union(int u, int v) {
    u = find(u);
    v = find(v);
    if(u == v) return true;
    if(u > v) {
      p[v] += p[u];
      p[u] = v;
    }else {
      p[u] += p[v];
      p[v] = u;
    }
    return false;
  }
}
