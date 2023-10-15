import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _boj_2643 {
    static int N;
    static Point[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Point[N];
        dp = new int[N];
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            if(width < height) {
                int temp = width;
                width = height;
                height = temp;
            }
            arr[i] = new Point(width, height);
        }
        Arrays.sort(arr);
        for(int i = 0 ; i < N ; i++) {
            dp[i] = 1;
            for(int j = 0 ; j < i ; j++) {
                if(arr[j].isCover(arr[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int answer = 0;
        answer = Arrays.stream(dp).max().getAsInt();
        System.out.println(answer);
    }

    static class Point implements Comparable<Point>{
        int width, height;
        Point(int width, int height) {
            this.width = width;
            this.height = height;
        }

        boolean isCover(Point target) {
            if(this.width >= target.width && this.height >= target.height) {
                return true;
            }
            return false;
        }
        @Override
        public int compareTo(Point target) {
            if(this.width == target.width) {
                return target.height - this.height;
            }
            return target.width - this.width;
        }
    }
}

