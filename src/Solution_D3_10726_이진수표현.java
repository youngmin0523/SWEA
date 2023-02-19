import java.util.*;
import java.io.*;

public class Solution_D3_10726_이진수표현 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb =new StringBuilder();
	static StringTokenizer st;
	static int N, M, TC, mask;
	
	public static void main(String[] args) throws Exception {
		TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			mask = (1<<N)-1;
			
			sb.append("#").append(tc).append(" ").append(mask==(mask&M)?"ON":"OFF").append("\n");
		}
		System.out.println(sb);
	}
}
