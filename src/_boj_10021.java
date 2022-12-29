import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _boj_10021 {
    static int N, C;
    static int graph[][];
    static int p[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        p = new int[N];
        for(int i = 0 ; i < N ; i++) p[i] = i;
        List<Point> arl = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arl.add(new Point(r, c));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int cost = (int) Math.pow(arl.get(i).r - arl.get(j).r, 2) +
                        (int) Math.pow(arl.get(i).c - arl.get(j).c, 2);

                pq.add(new Node(i,j,cost));
            }
        }
        int cnt = 0;
        int answer = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(node.cost < C) continue;

            int rootU = find(node.u);
            int rootV = find(node.v);

            if(rootU == rootV) continue;
            union(rootU,rootV);
            answer += node.cost;
        }
        boolean flag = false;
        for(int i = 0 ; i < N-1 ; i++) {
            if(p[i] != p[i+1]) {
                flag = true;
                break;
            }
        }
        if(flag) System.out.println(-1);
        else System.out.println(answer);
    }

    static int find(int a) {
        if(p[a] == a) return a;
        return p[a] = find(p[a]);
    }

    static void union(int a,int b) {
        a = find(a);
        b = find(b);
        if(a != b) p[b] = a;
    }

    static class Node implements Comparable<Node> {
        int u, v, cost;

        Node(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node target) {
            return this.cost - target.cost;
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
