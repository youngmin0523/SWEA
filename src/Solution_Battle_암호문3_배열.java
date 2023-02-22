import java.util.*;
import java.io.*;

public class Solution_Battle_암호문3_배열 {
	static int N, M, x, y;
	static List<String> cipherText;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			cipherText = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				cipherText.add(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				switch(st.nextToken().charAt(0)) {
				case 'I':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; j++) {
						cipherText.add(x++, st.nextToken());
					}
					break;
				case 'D':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; j++) {
						cipherText.remove(x++);
					}
					break;
				case 'A':
					y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; j++) {
						cipherText.add(st.nextToken());
					}
					break;
				}
			}
			sb.append("#").append(tc);
			for(int i = 0; i < 10; i++) {
				sb.append(" ").append(cipherText.get(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}
