import java.util.*;
import java.io.*;

public class Solution_D4_1233_사칙연산유효성검사 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char tree[];
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		
		for(int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N+1];
			flag = false;
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
			}
			
			boolean avail = dfs(1);
			sb.append("#").append(tc).append(" ");
			if(avail) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static boolean dfs(int root) {
		if(root*2 <= N) {
			boolean avail = dfs(root*2);
			if(!avail) return false;
		}
		if(!flag) {
			if(!isCalc(tree[root])) {
				flag = true;
			}
			else {
				return false;
			}
		}
		else {
			if(isCalc(tree[root])) {
				flag = false;
			}
			else {
				return false;
			}
		}
		if(root*2+1 <= N) {
			boolean avail = dfs(root*2+1);
			if(!avail) return false;
		}
		return true;
	}
	static boolean isCalc(char x) {
		return x == '+' || x == '-' || x == '*' || x== '/';
	}
}
