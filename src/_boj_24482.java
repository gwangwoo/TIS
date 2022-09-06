import java.io.*;
import java.util.*;

public class _boj_24482 {
  static int V,E,S;
  static List<Integer>[] arl;
  static int visited[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    arl = new ArrayList[V+1];
    visited = new int[V+1];
    Arrays.fill(visited, -1);
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
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for(int i = 1 ; i <= V ; i++) {
      bw.write(visited[i]+"\n");
    }
    bw.flush();
    bw.close();
  }

  static void dfs(int node, int num) {
    if(visited[node] != -1) return;
    visited[node] = num;

    for(int y : arl[node]) {
      dfs(y, num+1);
    }
  }
}
