import java.io.*;
import java.util.*;

public class Solution_Battle_새로운불면증치료법 {
	static final int mask = (1<<10)-1;
	static int N, flag, tmp;
	static char[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			tmp = N = Integer.parseInt(br.readLine());
			flag = 0;
			while(true) {
				arr = String.valueOf(tmp).toCharArray();
				for(int i = 0; i < arr.length; i++) {
					flag = flag | (1<<(arr[i]-'0'));
				}
				if(flag == mask) break;
				tmp += N;
			}
			sb.append("#").append(tc).append(" ").append(tmp).append("\n");
		}
		System.out.println(sb);
	}
}
