import java.io.*;
import java.util.*;

public class Solution_Battle_이진수표현 {
	static int N, M, mask;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			mask = (1<<N)-1;
			
			
			sb.append("#").append(tc).append(" ").append(mask == (M&mask)?"ON":"OFF").append("\n");
		}
		System.out.println(sb);
	}
}
