import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _boj_1418 {
    static int N, K;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        prime = new boolean[N+1];
        for (int i = 2; i <= N; i++) {
            if (!prime[i]) {
                for (int j = i + i; j <= N; j += i) {
                    prime[j] = true;
                }
            }
        }
        List<Integer> primeNumbers = new ArrayList<>();
        for(int i = 2 ; i < prime.length ; i++) {
            if(!prime[i]) primeNumbers.add(i);
        }
        List<Integer> filterPrimeNumbers = primeNumbers.stream()
                                                       .filter(x -> x > K)
                                                       .filter(x -> x <= N)
                                                       .collect(Collectors.toList());
        int answer = 0;
        for(int i = 1 ; i <= N ; i++) {
            for(int val : filterPrimeNumbers) {
                if(i % val == 0) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(N - answer);
    }
}
