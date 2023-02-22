import java.util.*;
import java.io.*;

public class Solution_Battle_동아리실관리하기 {
	static int N, cnt;
	static String managers;
	static ArrayList<List<Character>> set = new ArrayList<>();
	static boolean[] isSelected = new boolean[4];
	static char[] members = {'A', 'B', 'C', 'D'};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			cnt = 0;
			managers = br.readLine();
			getSet(0, 0, managers.charAt(0), 'A');
			for(int i = 1; i < managers.length(); i++) {
				ArrayList<List<Character>> tmpSet = (ArrayList<List<Character>>) set.clone();
				set.clear();
				for(List<Character> subSet : tmpSet) {
					for(char keyOwner : subSet) {
						getSet(i, 0, managers.charAt(i), keyOwner);
					}
				}
			}
			sb.append("#").append(tc).append(" ").append("\n");
		}
		System.out.println(sb);
	}
	static void getSet(int days, int cnt, char manager, char keyOwner) {
		if(cnt == 4) {
			if(days == managers.length()) {
				cnt++;
			}
			else {
				List<Character> tmpList = new ArrayList<>();
				for(int i = 0; i < 4; i++) {
					if(isSelected[i]) {
						tmpList.add(members[i]);
					}
				}
				set.add(tmpList);
			}
			return;
		}
		if(members[cnt] == manager || members[cnt] == keyOwner) {
			isSelected[cnt] = true;
			getSet(days+1, cnt+1, manager, keyOwner);
		}
		else {
			isSelected[cnt] = true;
			getSet(days+1, cnt+1, manager, keyOwner);
			isSelected[cnt] = false;
			getSet(days+1, cnt+1, manager, keyOwner);
		}
	}
}
