import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class _boj_5355 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = st.countTokens() - 1;
            double value = Double.parseDouble(st.nextToken());
            while (K-- > 0) {
                String str = st.nextToken();
                switch (str) {
                    case "@":
                        value *= 3;
                        break;
                    case "%":
                        value += 5;
                        break;
                    case "#" :
                        value -= 7;
                        break;
                }
            }
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(df.format(value));
        }
    }
}
