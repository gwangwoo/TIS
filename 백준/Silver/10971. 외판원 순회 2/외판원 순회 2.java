import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] dist;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            go(i, i, 1, 0);
            visited[i] = false;
        }
        System.out.println(answer);
    }

    private static void go(int start, int cur, int picked, int cost) {
        if (cost >= answer) return;

        if (picked == N) {
            if (dist[cur][start] != 0) {
                answer = Math.min(answer, cost + dist[cur][start]);
            }
            return;
        }

        for (int next = 0; next < N; next++) {
            if (visited[next]) continue;
            if (dist[cur][next] == 0) continue;

            visited[next] = true;
            go(start, next, picked + 1, cost + dist[cur][next]);
            visited[next] = false;
        }
    }
}
