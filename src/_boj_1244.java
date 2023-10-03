import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class _boj_1244 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            action(gender, number);
        }
        for(int i = 1 ; i <= N ; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    private static void action(int gender, int number) {
        if (gender == 1) {
            int value = number;
            while (number <= N) {
                arr[number] = arr[number] == 0 ? 1 : 0;
                number += value;
            }
        } else {
            if (number > N) {
                return;
            }
            arr[number] = arr[number] == 0 ? 1 : 0;
            int diff = 1;
            while (true) {
                if (number - diff <= 0 || number + diff > N || arr[number - diff] != arr[number + diff]) {
                    return;
                }
                arr[number - diff] = arr[number - diff] == 0 ? 1 : 0;
                arr[number + diff] = arr[number + diff] == 0 ? 1 : 0;
                diff++;
            }
        }
    }
}
