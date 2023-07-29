import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _boj_1303_v2 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int N, M;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int wValue = 0;
        int bValue = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    continue;
                }
                int val = bfs(i, j);
                switch (map[i][j]) {
                    case 'W':
                        wValue += val;
                        break;
                    case 'B':
                        bValue += val;
                        break;
                }
            }
        }
        System.out.println(wValue + " " + bValue);
    }

    private static int bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        visited[i][j] = true;
        int cnt = 1;
        char ch = map[i][j];
        while (!q.isEmpty()) {
            Point p = q.poll();
            int r = p.r;
            int c = p.c;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != ch || visited[nr][nc]) {
                    continue;
                }
                q.add(new Point(nr, nc));
                visited[nr][nc] = true;
                cnt++;
            }
        }
        return (int) Math.pow(cnt, 2);
    }

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
