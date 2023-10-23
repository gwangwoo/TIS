import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _boj_2559 {
    static int N, M;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        dp = new int[N + 1];
        Arrays.fill(dp, -1987654321);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[M] = Arrays.stream(arr)
                      .limit(M + 1)
                      .sum();
        for (int i = M + 1; i <= N; i++) {
            dp[i] = dp[i - 1] - arr[i - M] + arr[i];
        }
        System.out.println(Arrays.stream(dp)
                                 .max()
                                 .getAsInt());
    }
}
