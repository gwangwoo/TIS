import java.io.*;
import java.util.*;

public class _boj_24484 {
  static int V,E,S;
  static List<Integer>[] arl;
  static int depth[];
  static int check[];
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    arl = new ArrayList[V+1];
    depth = new int[V+1];
    Arrays.fill(depth, -1);
    check = new int[V+1];
    for(int i = 1 ; i <= V ; i++) arl[i] = new ArrayList<>();
    for(int i = 0 ; i < E ; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      arl[u].add(v);
      arl[v].add(u);
    }
    for(int i = 1 ; i <= V ; i++) Collections.sort(arl[i], (o1, o2) -> o2-o1);

    dfs(S, 0);
    long answer = 0;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for(int i = 1 ; i <= V ; i++) {
      answer += (check[i] * (long)depth[i]);
    }
    bw.write(answer+"\n");
    bw.flush();
    bw.close();
  }

  static void dfs(int node, int num) {
    if(depth[node] != -1) return;
    depth[node] = num;
    check[node] = ++N;

    for(int y : arl[node]) {
      dfs(y, num+1);
    }
  }
}
