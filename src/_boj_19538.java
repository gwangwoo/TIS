import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _boj_19538 {
    static int N, M;
    static List<Integer>[] arl;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arl = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arl[i] = new ArrayList<>();
        }
        dist = new int[N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            while (true) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 0) {
                    break;
                }
                arl[i].add(val);
            }
        }
        M = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, -1);
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int rumorNum = Integer.parseInt(st.nextToken());
            q.add(rumorNum);
            dist[rumorNum] = 0;
        }
        Queue<Integer> tempQ = new LinkedList<>();
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int p = q.poll();
                for (int y : arl[p]) {
                    if (dist[y] != -1 || !isRumorTrue(y)) {
                        continue;
                    }
                    tempQ.add(y);
                }
            }
            time++;
            while (!tempQ.isEmpty()) {
                int rumor = tempQ.poll();
                dist[rumor] = time;
                q.add(rumor);
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            bw.write(dist[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    private static boolean isRumorTrue(int y) {
        int size = arl[y].size();
        long rumorCount = arl[y].stream()
                           .filter(x -> dist[x] != -1)
                           .count();
        return size <= 2 * rumorCount;
    }
}
