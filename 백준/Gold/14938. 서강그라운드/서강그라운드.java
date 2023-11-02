import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,R;
    static List<Node>[] adj;
    static int[] dist;
    static int[] value;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        for(int i =1  ; i<= N ; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        value = new int[N+1];
        for(int i = 1 ; i <= N ; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < R ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v,cost));
            adj[v].add(new Node(u, cost));
        }
        int answer = 0;
        dist = new int[N+1];
        for(int i = 1 ; i<= N ; i++) {
            int val = dijk(i);
            answer = Math.max(val, answer);
        }
        System.out.println(answer);
    }

    private static int dijk(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, (int)1e9);
        pq.add(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()) {
            Node p = pq.poll();
            for(Node y : adj[p.idx]) {
                if(dist[y.idx] > dist[p.idx] + y.cost) {
                    dist[y.idx] = dist[p.idx] + y.cost;
                    pq.add(new Node(y.idx, dist[y.idx]));
                }
            }
        }
        int result = 0;
        for(int i = 1 ; i<= N ; i++) {
            if(dist[i] > M) continue;
            result += value[i];
        }
        return result;
    }

    static class Node implements Comparable<Node>{
        int idx,cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node target) {
            return this.cost - target.cost;
        }
    }
}
