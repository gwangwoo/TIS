import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _boj_21736 {
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                char ch = str.charAt(j);
                map[i][j] = ch;
                if(ch == 'I') {
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                }
            }
        }
        int answer = 0;
        while(!q.isEmpty()) {
            Point p = q.poll();
            int r = p.r;
            int c = p.c;
            for(int k = 0 ; k < 4 ; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 'X' || visited[nr][nc]) continue;
                if(map[nr][nc] == 'P') answer++;
                q.add(new Point(nr,nc));
                visited[nr][nc] = true;
            }
        }
        if(answer == 0) {
            System.out.println("TT");
        }else {
            System.out.println(answer);
        }
    }

    static class Point {
        int r,c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
