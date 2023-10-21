import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _boj_18110 {
    static int N;
    static List<Integer> arl = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            arl.add(Integer.parseInt(br.readLine()));
        }
        if (N == 0) {
            System.out.println(0);
            return;
        }
        int exceptCount = (int) Math.round(15 / (100d / N));
        arl.sort(Integer::compareTo);
        int result = (int) Math.round(new ArrayList<>(arl.subList(exceptCount, N - exceptCount)).stream()
                                                                                                .mapToInt(Integer::intValue)
                                                                                                .average()
                                                                                                .getAsDouble());
        System.out.println(result);
    }
}
