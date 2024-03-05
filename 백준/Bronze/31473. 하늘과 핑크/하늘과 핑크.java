import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int aSum = 0;
        int bSum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            aSum += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            bSum += Integer.parseInt(st.nextToken());
        }

        int gcd = getGCD(aSum, bSum);
        System.out.println(bSum / gcd + " " + aSum / gcd);

    }

    private static int getGCD(int aSum, int bSum) {
        if(aSum < bSum) return getGCD(bSum, aSum);
        if(aSum % bSum == 0) {
            return bSum;
        }
        return getGCD(bSum, aSum % bSum);
    }
}
