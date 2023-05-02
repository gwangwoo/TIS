import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _boj_24479 {
    static int N, M, R;
    static List<Integer> arl[];
    static int visited[];
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arl = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arl[i] = new ArrayList<>();
        }
        visited = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arl[u].add(v);
            arl[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(arl[i]);
        }
        dfs(R);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            bw.write(visited[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int s) {
        if(visited[s] != 0) return;
        visited[s] = ++count;
        for (int y : arl[s]) {
            dfs(y);
        }
    }
}
