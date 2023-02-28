import java.io.*;
import java.util.*;

public class Solution_D4_7465_창용마을무리의개수 {
	static int N, M, set[], res;
	static Set<Integer> groups;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			make(N);
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			groups = new HashSet<>();
			for(int i = 1; i <= N; i++) {
				groups.add(find(i));
			}
			sb.append("#").append(tc).append(" ").append(groups.size()).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void make(int n) {
		set = new int[n+1];
		for(int i = 1; i <= n; i++) {
			set[i] = i;
		}
	}
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return;
		set[rootB] = rootA;
	}
	static int find(int a) {
		if(set[a] == a) return a;
		return set[a] = find(set[a]);
	}
}
