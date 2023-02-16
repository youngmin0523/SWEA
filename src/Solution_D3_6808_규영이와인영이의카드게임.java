import java.io.*;
import java.util.*;

public class Solution_D3_6808_규영이와인영이의카드게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, A[], B[], win, lose;
	static boolean isSelected[];
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			A = new int[9];
			B = new int[9];
			isSelected = new boolean[19];
			win = 0; lose = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				isSelected[A[i]] = true;
			}
			factorial(0);
			
			
			sb.append("#").append(tc).append(" ").append(win);
			sb.append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}
	static void factorial(int cnt) {
		if(cnt == 9) {
			int a = 0, b = 0;
			for(int i = 0; i < 9; i++) {
				if(A[i] > B[i]) {
					a += A[i]+B[i];
				}
				else {
					b += A[i]+B[i];
				}
			}
			if(a > b) {
				win++;
			}
			else {
				lose++;
			}
			return;
		}
		for(int i = 1; i <= 18; i++) {
			if(isSelected[i]) continue;
			B[cnt] = i;
			isSelected[i] = true;
			factorial(cnt+1);
			isSelected[i] = false;
		}
	}
}
