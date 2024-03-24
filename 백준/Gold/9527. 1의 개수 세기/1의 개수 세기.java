import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] psum;
    static final int N = 55;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        psum = new long[N];
        psum[0] = 1;
        for (int i = 1; i < N; i++) {
            psum[i] = 2 * psum[i - 1] + (1L << i);
        }
        System.out.println(go(b) - go(a-1));
    }

    static long go(long val) {
        long answer = 1L & val;
        for(long i = N ; i > 0 ; i--) {
            if((val & (1L << i)) > 1) {
                answer += psum[(int)(i-1)] + val - (1L << i) + 1;
                val -= (1L << i);
            }
        }
        return answer;
    }
}
