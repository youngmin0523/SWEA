import java.io.*;
import java.util.*;


public class Solution_D4_1218_괄호짝짓기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Map<Character, Character> map = new HashMap<>();
	static ArrayDeque<Character> deque;
	static int flag;
	
	public static void main(String[] args) throws Exception {
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		map.put('>', '<');
		
		for(int tc = 1; tc <= 10; tc++) {
			flag = 1;
			deque = new ArrayDeque<>();
			int length = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for(int i = 0; i < length; i++) {
				char tmp = str.charAt(i);
				if(!map.containsKey(tmp)) {
					deque.push(tmp);
				}
				else {
					if(deque.isEmpty()) {
						flag = 0;
						break;
					}
					char tmp2 = deque.pop();
					if(tmp2 != map.get(tmp)) {
						flag = 0;
						break;
					}
				}
			}
			if(!deque.isEmpty()) flag = 0;
			sb.append("#").append(tc).append(" ").append(flag).append("\n");
		}
		System.out.println(sb);
	}
}
