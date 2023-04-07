import java.util.*;
import java.io.*;

public class Solution_5604_구간합 {

	static long A, B, num[], res, mul;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			num = new long[10];
			res = 0; mul = 1;
			
			A = Math.max(1, A);
			while(true) {
				while(A%10 != 0 && A <= B) {
					solve(A);
					A++;
				}
				if(A > B) break;
				while(B % 10 != 9 && A <= B) {
					solve(B);
					B--;
				}
				long sub = B/10 - A/10 + 1;
				for(int i = 0; i < 10; i++) {
					num[i] += sub*mul;
				}
				mul *= 10;
				A /= 10;
				B /= 10;
			}
			for(int i = 1; i < 10; i++) {
				res += i * num[i];
			}
			sb.append('#').append(tc).append(' ').append(res).append('\n');
		}
		System.out.println(sb.toString());
	}
	static void solve(long x) {
		for(long i = x; i > 0; i /= 10) {
			String str = Long.toString(i);
			int n = str.charAt(str.length()-1)-'0';
			num[n] += mul;
		}
	}
}
