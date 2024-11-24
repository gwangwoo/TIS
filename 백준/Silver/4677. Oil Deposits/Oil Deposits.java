import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static char[][] map;
    static boolean[][] visited;
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (R == 0 && C == 0) {
                bw.flush();
                bw.close();
                return;
            }
            map = new char[R][C];
            visited = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                String str = br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            int answer = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == '@' && !visited[i][j]) {
                        answer += bfs(i, j);
                    }
                }
            }
            bw.write(answer + "\n");
        }
    }

    private static int bfs(int sr, int sc) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        visited[sr][sc] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            for (int k = 0; k < 8; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] != '@') {
                    continue;
                }
                q.add(new Pair(nr, nc));
                visited[nr][nc] = true;
            }
        }
        return 1;
    }

    static class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
