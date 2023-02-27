import java.io.*;
import java.util.*;

public class Solution_D4_3289_서로소집합 {
	static int n, m, set[], a, b;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			make(n);
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				switch(Integer.parseInt(st.nextToken())) {
				case 0:
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					union(a, b);
					break;
				case 1:
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					sb.append(find(a)==find(b)?1:0);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
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
		if(set[a] == a) {
			return a;
		}
		return set[a] = find(set[a]);
	}
}
