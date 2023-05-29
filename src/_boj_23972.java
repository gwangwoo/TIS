import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_23972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long K = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        if (N == 1L) {
            System.out.println(-1);
        } else {
            long x = (K * N) / (N - 1);
            if ((K * N) % (N - 1) != 0) {
                x++;
            }
            System.out.println(x);
        }
    }
}
