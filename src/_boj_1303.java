import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _boj_1303 {
  static int N,M;
  static int dr[] = {-1,0,1,0};
  static int dc[] = {0,1,0,-1};

  static char[][] map;
  static boolean[][] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    visited = new boolean[N][M];
    for(int i = 0 ; i < N ; i++) {
      String str = br.readLine();
      for(int j = 0 ; j < M ; j++) {
        map[i][j] = str.charAt(j);
      }
    }
    int answerW = 0;
    int answerB = 0;
    for(int i = 0 ; i < N ; i++) {
      for(int j = 0 ; j < M ; j++) {
        if(visited[i][j]) continue;
        int cnt = bfs(i, j);
        if(map[i][j] == 'W') answerW += Math.pow(cnt,2);
        else answerB += Math.pow(cnt, 2);
      }
    }
    System.out.println(answerW + " " + answerB);
  }

  private static int bfs(int i, int j) {
    Queue<Point> q = new LinkedList<>();
    q.add(new Point(i,j));
    visited[i][j] = true;
    char word = map[i][j];
    int cnt = 1;

    while(!q.isEmpty()) {
      Point p = q.poll();
      int r = p.r;
      int c = p.c;
      for(int k = 0 ; k < 4 ; k++) {
        int nr = r + dr[k];
        int nc = c + dc[k];
        if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != word || visited[nr][nc]) continue;
        cnt+=1;
        q.add(new Point(nr,nc));
        visited[nr][nc] = true;
      }
    }
    return cnt;
  }

  static class Point {
    int r,c;
    Point(int r,int c) {
      this.r = r;
      this.c = c;
    }
  }
}
