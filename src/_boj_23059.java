import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class _boj_23059 {
    static int N;
    static boolean[] visited;
    static List<Integer>[] adj;
    static Map<String, Integer> hm = new TreeMap<>();
    static Map<Integer, String> reverseHm = new TreeMap<>();
    static int idx;
    static int[] indegree;
    static final int MAX = 400_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[MAX];
        indegree = new int[MAX];
        visited = new boolean[MAX];
        IntStream.range(1, MAX).forEachOrdered(i -> adj[i] = new ArrayList());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String last = st.nextToken();
            int u = setHashMap(first);
            int v = setHashMap(last);
            adj[u].add(v);
            indegree[v]++;
        }
        List<String> answer = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        for (int i = 1; i <= idx; i++) {
            if (indegree[i] == 0) {
                q.add(reverseHm.get(i));
                answer.add(reverseHm.get(i));
            }
        }
        Collections.sort(answer);
        List<String> temp = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int p = hm.get(q.poll());
                for (int y : adj[p]) {
                    if (visited[y]) {
                        continue;
                    }
                    indegree[y]--;
                    if (indegree[y] == 0) {
                        q.add(reverseHm.get(y));
                        temp.add(reverseHm.get(y));
                        visited[y] = true;
                    }
                }
            }
            Collections.sort(temp);
            answer.addAll(temp);
            temp.clear();
        }
        boolean flag = false;
        for (int i = 1; i <= idx; i++) {
            if (indegree[i] != 0) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println(-1);
            return;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        answer.stream().forEachOrdered(item -> {
            try {
                bw.write(item+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.flush();
        bw.close();
    }

    private static int setHashMap(String str) {
        if (!hm.containsKey(str)) {
            hm.put(str, ++idx);
            reverseHm.put(idx, str);
        }
        return hm.get(str);
    }
}
