import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_26595 {
    static long N;
    static long a,pa,b,pb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        pa = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        pb = Long.parseLong(st.nextToken());
        long max = 0;
        long X = 0;
        long Y = 0;
        for(int x = 0 ; x <= N/pa ; x++) {
            long cntA = x;
            long cntB = (N - x * pa)/ pb;
            if(a * cntA + b * cntB > max) {
                max = a * cntA + b * cntB;
                X = cntA;
                Y = cntB;
            }
        }
        System.out.println(X + " " + Y);
    }
}
