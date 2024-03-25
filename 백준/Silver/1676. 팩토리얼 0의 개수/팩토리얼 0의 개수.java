import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mod_two_cnt = 0;
        int mod_five_cnt = 0;
        for (int i = 1; i <= N; i++) {
            int number = i;
            while (number % 2 == 0) {
                mod_two_cnt++;
                number /= 2;
            }
            while (number % 5 == 0) {
                mod_five_cnt++;
                number /= 5;
            }
        }
        System.out.println(Math.min(mod_two_cnt, mod_five_cnt));
    }
}