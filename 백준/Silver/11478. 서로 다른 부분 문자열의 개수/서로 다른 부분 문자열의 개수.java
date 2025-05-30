import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Set<String> result = new HashSet<>();
        int N = str.length();
        for (int i = 0 ; i < N ; i++) {
            for (int j = i+1 ; j < N+1 ; j++) {
                result.add(str.substring(i, j));
            }
        }
        System.out.println(result.size());
    }
}
