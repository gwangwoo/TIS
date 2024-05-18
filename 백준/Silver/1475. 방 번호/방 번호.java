import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String val = br.readLine();
        int[] arr = new int[10];
        for (int i = 0 ; i < val.length() ; i++) {
            arr[val.charAt(i)-'0']++;
        }
        arr[6] = (arr[6] + arr[9]) % 2 == 1 ?  (arr[6] + arr[9]) / 2 + 1 : (arr[6] + arr[9]) / 2;
        arr[9] = 0;
        System.out.println(Arrays.stream(arr).max().getAsInt());

    }
}
