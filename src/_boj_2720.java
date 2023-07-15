import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _boj_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            int val = Integer.parseInt(br.readLine());
            int quarter = val / 25;
            val %= 25;
            int dime = val / 10;
            val %= 10;
            int nickel = val / 5;
            val %= 5;
            int penny = val / 1;
            System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
        }
    }
}
