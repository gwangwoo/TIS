import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _boj_1064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        if((y2 - y1) * (x3 - x2) == (x2 - x1) * (y3 - y2)) {
            System.out.println(-1.0);
            return;
        }
        double distance12 = dist(x1,y1,x2,y2);
        double distance13 = dist(x1,y1,x3,y3);
        double distance23 = dist(x2,y2,x3,y3);
        double[] dists = {distance12, distance13, distance23};
        Arrays.sort(dists);
        System.out.println((dists[2]+dists[1])*2 - (dists[0]+dists[1]) * 2);

    }

    private static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1, 2));
    }
}
