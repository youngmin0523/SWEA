import java.util.*;
import java.io.*;

public class Solution_모의SW_4012_요리사 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, N, S[][], min;
	static boolean isSelected[];
	
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			isSelected = new boolean[N];
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0, 0);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	static void comb(int cnt, int n) {
		if(n == N) {
			if(cnt == N/2) {
				int a = 0, b = 0;
				for(int i = 0; i < N; i++) {
					for(int j = i+1; j < N; j++) {
						if(isSelected[i] && isSelected[j]) {
							a += S[i][j];
							a += S[j][i];
						}
						if(!isSelected[i] && !isSelected[j]) {
							b += S[i][j];
							b += S[j][i];
						}
					}
				}
				int tmp = Math.abs(a-b);
				if(min > tmp) {
					min = tmp;
				}
			}
			return;
		}
		
		isSelected[n] = true;
		comb(cnt+1, n+1);
		isSelected[n] = false;
		comb(cnt, n+1);
	}
}
