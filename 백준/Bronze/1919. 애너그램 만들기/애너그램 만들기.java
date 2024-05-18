import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] now = setting(br.readLine());
        int[] target = setting(br.readLine());
        System.out.println(calc(now, target));
    }

    private static int calc(int[] now, int[] target) {
        int result = 0;
        for(int i = 0 ; i < 26 ; i++) {
            result += Math.abs(now[i] - target[i]);
        }
        return result;
    }

    private static int[] setting(String str) {
        int[] result = new int[26];
        for (int i = 0 ; i < str.length() ; i++) {
            result[str.charAt(i)-'a']++;
        }
        return result;
    }
}
