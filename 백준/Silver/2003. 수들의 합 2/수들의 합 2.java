import java.util.*;

public class Main {
	static int num[];
	static int N;
	static long M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextLong();
		num = new int[N];
		for(int i = 0 ; i < N ; i++) {
			num[i] = sc.nextInt();
		}
		Long sum = 0l;
		int l = 0, r = 0;
		int res = 0;
		while(true) {
			if(sum >= M) sum -= num[l++];
			else if (r == N) break;
			else sum += num[r++];
			if(sum == M) res++;
		}
		System.out.println(res);
	}

}
