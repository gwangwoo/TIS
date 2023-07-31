import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _boj_27112 {
    static int N;
    static Work[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Work[N+1];
        arr[0] = new Work(0,0);
        for(int i = 1 ; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            arr[i] = new Work(day, cnt);
        }
        Arrays.sort(arr);
        Queue<Work> q = new LinkedList<>(Arrays.asList(arr));
        int peaceTime = 0;
        int overTime = 0;
        int time = 0;
        int answer = 0;
        while(true) {
            if (++time > 100_000) {
                break;
            }
            if (time % 7 == 6 || time % 7 == 0) {
                overTime++;
            } else {
                peaceTime++;
                overTime++;
            }
            if(q.peek().day > time) continue;
            while(true) {
                if(q.isEmpty() || q.peek().day > time) break;
                Work work = q.poll();
                peaceTime -= work.cnt;
                if(peaceTime < 0) {
                    overTime += peaceTime;
                    answer += peaceTime;
                    peaceTime = 0;
                    if(overTime < 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
            if(q.isEmpty()) break;
        }
        System.out.println(-answer);
    }


    static class Work implements Comparable<Work> {
        int day, cnt;
        Work(int day, int cnt) {
            this.day = day;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Work target) {
            if(this.day == target.day) {
                return this.cnt - target.cnt;
            }
            return this.day - target.day;
        }
    }
}
