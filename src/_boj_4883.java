import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _boj_4883 {
    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        int idx = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                return;
            }
            arr = new int[N][3];
            dp = new int[N][3];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = 1987654321;
            dp[0][1] = arr[0][1];
            dp[0][2] = arr[0][1] + arr[0][2];
            for (int i = 1; i < N; i++) {
                dp[i][0] = getMin(dp[i - 1][0], dp[i - 1][1]) + arr[i][0];
                dp[i][1] = getMin(dp[i][0], dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]) + arr[i][1];
                dp[i][2] = getMin(dp[i][1], dp[i - 1][1], dp[i - 1][2]) + arr[i][2];
            }
            System.out.println(idx++ + ". " + dp[N - 1][1]);
        }
    }

    static int getMin(int... val) {
        return Arrays.stream(val)
                     .min()
                     .getAsInt();
    }
}
