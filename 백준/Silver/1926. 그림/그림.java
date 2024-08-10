import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        int answer_cnt = 0;
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    int cnt = bfs(i,j);
                    answer = Math.max(answer, cnt);
                    answer_cnt++;
                }
            }
        }


        System.out.println(answer_cnt);
        System.out.println(answer);


    }

    private static int bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i,j));
        visited[i][j] = true;
        int cnt = 1;

        while(!q.isEmpty()) {
            Node p = q.poll();
            int r = p.r;
            int c = p.c;
            for(int k = 0 ; k < 4 ; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nc < 0 || nc >= M || nr < 0 || nr >= N) continue;
                if (map[nr][nc] == 0 || visited[nr][nc]) continue;
                q.add(new Node(nr,nc));
                visited[nr][nc] = true;
                cnt++;
            }
        }
        return cnt;
    }

    static class Node {
        int r,c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
