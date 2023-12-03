import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int[][] map;
    static int[][] vacuumMap;
    static boolean[][] visited;
    static Queue<Point> q;
    static Queue<Point> clearQ;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();
        clearQ = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new Point(i, j));
                }
            }
        }
        int answer = 0;
        while (!q.isEmpty()) {
            answer++;
            int size = q.size();
            // 진공 처리
            vacuum(map);
            while (size-- > 0) {
                Point p = q.poll();
                int r = p.r;
                int c = p.c;
                int contactCount = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || vacuumMap[nr][nc] == 0) {
                        contactCount++;
                    }
                }
                if (contactCount < 2) {
                    q.add(new Point(r, c));
                } else {
                    clearQ.add(new Point(r, c));
                }
            }
            while (!clearQ.isEmpty()) {
                Point p = clearQ.poll();
                map[p.r][p.c] = 0;
            }
        }
        System.out.println(answer);
    }

    private static void print(int[][] map) {
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void vacuum(int[][] map) {
        vacuumMap = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                vacuumMap[i][j] = map[i][j];
            }
        }
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (vacuumMap[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j, index);
                    index--;
                }
            }
        }
    }

    private static void bfs(int i, int j, int index) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        visited[i][j] = true;
        vacuumMap[i][j] = index;
        while (!q.isEmpty()) {
            Point p = q.poll();
            int r = p.r;
            int c = p.c;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || vacuumMap[nr][nc] == 1 || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                vacuumMap[nr][nc] = index;
                q.add(new Point(nr, nc));
            }
        }
    }

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
