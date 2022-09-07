import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class _boj_24444 {
  static int N,M,S;
  static int visited[];
  static List<Integer>[] arl;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    arl = new ArrayList[N+1];
    visited = new int[N+1];
    for(int i = 1 ; i <= N ; i++) arl[i] = new ArrayList<>();
    for(int i = 0 ; i < M ; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      arl[u].add(v);
      arl[v].add(u);
    }
    for(int i = 1 ; i <= N ; i++) Collections.sort(arl[i]);
    bfs(S);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for(int i = 1 ; i <= N ; i++) bw.write(visited[i]+"\n");
    bw.flush();
    bw.close();
  }

  private static void bfs(int s) {
    Queue<Integer> q = new LinkedList<>();
    int num = 0;
    visited[s] = ++num;
    q.add(s);
    while(!q.isEmpty()) {
      int p = q.poll();
      for(int y : arl[p]) {
        if(visited[y] != 0) continue;
        visited[y] = ++num;
        q.add(y);
      }
    }
  }
}
