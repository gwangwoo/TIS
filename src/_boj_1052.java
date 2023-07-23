import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_1052 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        if (K >= N) {
            System.out.println(0);
            return;
        }
        while(Integer.bitCount(N) > K) {
            N++;
            cnt++;
        }
        System.out.println(cnt);
    }
}
