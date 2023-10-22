import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _boj_14940 {
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};
    static int N, M;
    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i],-1);
        }
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    q.add(new Point(i,j));
                    dist[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()) {
            Point p = q.poll();
            int r = p.r;
            int c = p.c;
            for(int k = 0 ; k < 4 ; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || dist[nr][nc] != -1) continue;
                dist[nr][nc] = dist[r][c] + 1;
                q.add(new Point(nr,nc));
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i <  N ; i++) {
            for(int j = 0 ;j < M ; j++) {
                if(map[i][j] == 0) {
                    bw.write("0 ");
                    continue;
                }
                bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    static class Point {
        int r,c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
