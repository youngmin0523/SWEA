import java.util.*;
import java.io.*;

public class Solution_Battle_동아리실관리하기 {
	static int N;
	static String managers;
	static int[] members = {0, 1, 2, 3};
	static List<List<Integer>> days; 
	static long res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			res = 1;
			managers = br.readLine();
			days = new ArrayList<>();
			
			for(int i = 0; i < managers.length(); i++) {
				days.add(new ArrayList<>());
				int mask = 0 | (1<<(managers.charAt(i)-'A'));
				set(0, mask, i);
			}
			List<Integer> not = new ArrayList<>();
			for(int i = 0 ; i < 8; i++) {
				int tmp = days.get(1).get(i);
				not = new ArrayList<>();
				while(tmp != 0) {
					not.add(tmp%2);
					tmp /= 2;
				}
				for(int j = not.size()-1; j >= 0; j--) {
					System.out.print(not.get(j));
				}
				System.out.println("\t" + days.get(1).get(i));
			}
			
			dfs(0, days.size());
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int cnt, int length) {
		if(cnt+1 == length) {
			res++;
			return;
		}
		
		for(int mask : days.get(cnt)) {
			for(int next : days.get(cnt+1)) {
				if((mask & next) != 0) {
					dfs(cnt+1, length);
				}
			}
		}
	}
	static void set(int cnt, int mask, int day) {
		if(cnt == 4) {
			days.get(day).add(mask);
			return;
		}
		if((mask & (1<<members[cnt])) == 0){
			set(cnt+1, mask|(1<<members[cnt]), day);
		}
		set(cnt+1, mask, day);
	}
}
