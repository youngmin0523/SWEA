import java.util.*;
import java.io.*;


public class Solution_D4_준환이의양팔저울 {
	static int N, weight[], perm[], cnt;
	static boolean used[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N]; perm = new int[N]; used = new boolean[N];
			st = new StringTokenizer(br.readLine());
			cnt = 0;
			for(int i = 0; i < N; i++)
				weight[i] = Integer.parseInt(st.nextToken());
			brute_force(0);
			
			System.out.println("#" + test_case + " " + cnt);
		}
	}
	
	static void brute_force(int K) {
		if(K == N) {
			subset(0, 0, 0);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!used[i]) {
				perm[K] = weight[i];
				used[i] = true;
				brute_force(K+1);
				used[i] = false;
			}
		}
	}
	
	static void subset(int K, int left, int right) {
		if(left < right) return;
		if(K == N) {
			cnt++;
			return;
		}
		subset(K + 1, left + perm[K], right);
		subset(K + 1, left, right + perm[K]);
	}
}
