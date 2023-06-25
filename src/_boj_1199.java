import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _boj_1199 {
    static int N;
    static FenwickTree[] FT;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        FT = new FenwickTree[N + 1];
        for (int i = 1; i <= N; i++) {
            FT[i] = new FenwickTree(N);
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int edge = Integer.parseInt(st.nextToken());
                FT[i].update(j, edge);
            }
        }
        for (int i = 1; i <= N; i++) {
            if ((FT[i].query(N) & 1) > 0) {
                System.out.println(-1);
                return;
            }
        }
        dfs(1);
        bw.write(sb.toString());
        bw.flush();
    }

    static void dfs(int s) {
        while (FT[s].query(N) > 0) {
            int j = FT[s].getMin();
            FT[s].update(j, -1);
            FT[j].update(s, -1);
            dfs(j);
        }
        sb.append(s+ " ");
    }

    static class FenwickTree {
        private int[] tree;

        public FenwickTree(int size) {
            tree = new int[size + 1];
        }
        // 인덱스 k의 값을 업데이트 함
        public void update(int pos, int val) {
            while (pos < tree.length) {
                tree[pos] += val;
                pos += pos & -pos;
            }
        }

        // 인덱스 k까지의 합을 계산하여 반환
        public int query(int pos) {
            int sum = 0;
            while (pos > 0) {
                sum += tree[pos];
                pos &= pos - 1;
            }
            return sum;
        }

        public int getMin() {
            int ret = 0;
            for (int i = 10; i >= 0; i--) {
                int t = ret + (1 << i);
                if (t < tree.length && tree[t] == 0) {
                    ret = t;
                }
            }
            return ret + 1;
        }

        public int getRangeSum(int a, int b) {
            return query(a) + query(b);
        }
    }
}
