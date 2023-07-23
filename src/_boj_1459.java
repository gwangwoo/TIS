import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_1459 {
    static long X, Y, W, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        W = Long.parseLong(st.nextToken());
        S = Long.parseLong(st.nextToken());
        long answer = 0;
        if ((X % 2 == 1 && Y % 2 == 1) || (X % 2 == 0 && Y % 2 == 0)) {
            if (2 * W > S) {
                answer = Math.min(X, Y) * S;
                answer += (Math.max(X, Y) - Math.min(X, Y)) * Math.min(W, S);
            } else {
                answer = (X + Y) * W;
            }
        } else {
            if (X + Y == 1) {
                answer = W;
            } else {
                if (2 * W > S) {
                    answer = Math.min(X, Y) * S;
                    answer += (Math.max(X, Y) - Math.min(X, Y) - 1) * Math.min(W, S) + W;
                } else {
                    answer = (X + Y) * W;
                }
            }
        }
        System.out.println(answer);
    }
}
