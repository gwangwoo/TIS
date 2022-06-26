import java.io.*;
import java.util.*;

public class _boj_14217 {
  static int N, M, Q;
  static int arr[][];
  static int dist[];

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N + 1][N + 1];
    dist = new int[N + 1];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      arr[u][v] = 1;
      arr[v][u] = 1;
    }
    Q = Integer.parseInt(br.readLine());
    while (Q-- > 0) {
      Arrays.fill(dist, -1);
      st = new StringTokenizer(br.readLine());
      int command = Integer.parseInt(st.nextToken());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      if (command == 1) {
        arr[u][v] = 1;
        arr[v][u] = 1;
      } else {
        arr[u][v] = 0;
        arr[v][u] = 0;
      }
      bfs(1);
      for (int i = 1; i <= N; i++) bw.write(dist[i] + " ");
      bw.write("\n");
    }
    bw.flush();
    bw.close();
  }

  private static void bfs(int s) {
    Queue<Integer> q = new LinkedList<>();
    dist[s] = 0;
    q.add(s);
    while (!q.isEmpty()) {
      int p = q.poll();
      for (int i = 1; i <= N; i++) {
        if (arr[p][i] == 0 || dist[i] != -1) continue;
        dist[i] = dist[p] + 1;
        q.add(i);
      }
    }
  }

  private static void print() {
    for (int i = 1; i <= N; i++) System.out.print(dist[i] + " ");
    System.out.println();
  }
}
