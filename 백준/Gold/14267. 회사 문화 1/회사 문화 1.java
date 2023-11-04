import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static Map<Integer, LinkedList<Integer>> parent = new HashMap<>();
    static Map<Integer, Integer> sumMap = new HashMap<>();
    static long value[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        value = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++) {
            int root = Integer.parseInt(st.nextToken());
            if(!parent.containsKey(root)) {
                parent.put(root, new LinkedList<>());
            }
            parent.get(root).add(i);
        }
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            if(sumMap.containsKey(idx)) {
                sumMap.put(idx, sumMap.get(idx)+val);
            }else {
                sumMap.put(idx, val);
            }
        }
        sumMap.forEach((key, val) -> {
            value[key] += val;
            dfs(key, val);
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i =1 ; i <= N ; i++) {
            bw.write(value[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    private static void dfs(int key, int val) {
        if(!parent.containsKey(key)) return;
        LinkedList<Integer> children = parent.get(key);
        children.forEach(child -> {
            value[child] += val;
            dfs(child, val);
        });
    }
}
