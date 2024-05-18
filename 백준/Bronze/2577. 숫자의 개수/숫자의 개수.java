import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String result = a * b * c+"";
        int[] answer = new int[10];
        IntStream.range(0, result.length())
                 .forEachOrdered(i -> answer[result.charAt(i) - '0']++);
        Arrays.stream(answer).forEach(System.out::println);
    }
}
