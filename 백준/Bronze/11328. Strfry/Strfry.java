import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = setting(st.nextToken());
            int[] target = setting(st.nextToken());
            System.out.println(check(arr, target));
        }
    }

    private static String check(int[] arr, int[] target) {
        for(int i = 0 ; i < 26 ; i++) {
            if(arr[i] != target[i]) {
                return "Impossible";
            }
        }
        return "Possible";
    }

    private static int[] setting(String str) {
        int[] result = new int[26];
        for (int i = 0 ; i < str.length() ; i++) {
            result[str.charAt(i)-'a']++;
        }
        return result;
    }
}
