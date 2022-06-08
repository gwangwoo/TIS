import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _boj_23352 {
  static int N, M;
  static int map[][];
  static int answer, cnt;

  static int dr[] = {-1,0,1,0};
  static int dc[] = {0,1,0,-1};

  static Point bfs(int r,int c) {
    Queue<Point> q = new LinkedList<>();
    int visited[][] = new int[N][M];
    visited[r][c] = 1;
    q.add(new Point(r,c,visited[r][c]));

    while(!q.isEmpty()) {
      Point p = q.poll();
      r = p.r;
      c = p.c;
      for(int k = 0 ; k < 4 ; k++) {
        int nr = r + dr[k];
        int nc = c + dc[k];
        if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] != 0 || map[nr][nc] == 0) continue;
        visited[nr][nc] = visited[r][c] + 1;
        q.add(new Point(nr,nc, visited[nr][nc]));
      }
    }
    return new Point(r,c,visited[r][c]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for(int i = 0 ; i < N ; i++) {
      for(int j = 0 ; j < M ; j++) {
        if(map[i][j] == 0) continue;
        Point ans = bfs(i, j);
        if(ans.l > cnt) {
          cnt = ans.l;
          answer = map[i][j] + map[ans.r][ans.c];
        }else if(ans.l == cnt) {
          answer = Math.max(answer, map[i][j] + map[ans.r][ans.c]);
        }
      }
    }
    System.out.println(answer);
  }
  static class Point {
    int r,c,l;
    Point(int r,int c, int l) {
      this.r = r;
      this.c = c;
      this.l = l;
    }
  }
}
