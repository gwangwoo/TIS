import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _boj_1351 {
    static long N,P,Q;
    static Map<Long, Long> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        hm.put(0L,1L);
        long result = go(N,P,Q);
        System.out.println(result);
    }

    private static long go(long n, long p, long q) {
        if(n == 0) return 1;
        if(hm.containsKey(n)) return hm.get(n);
        long val = go(n/p , p, q) + go(n/q, p, q);
        hm.put(n, val);
        return val;
    }
}
