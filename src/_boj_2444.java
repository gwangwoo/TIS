import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _boj_2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N*2-1 ; i++) {
            int standard = i < N ? i : N*2-i-2;
            int starCnt = 2 * standard + 1;
            for(int j = N+standard ; j > starCnt ; j--) {
                System.out.print(" ");
            }
            while (starCnt-- > 0) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
