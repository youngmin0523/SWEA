import java.io.*;
import java.util.*;

public class Solution_D4_1238_Contact {
	
	static List<Integer> adjList[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			adjList = new List[101];
			for(int i = 1; i <= 100; i++) {
				adjList[i] = new ArrayList<>();
			}
			int from, to;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < length/2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
			}
			
			sb.append('#').append(tc).append(' ').append(bfs(start)).append('\n');
		}
		System.out.print(sb.toString());
	}
	static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		boolean visited[] = new boolean[101];
		
		int current, max = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			max = 0;
			for(int i = 0; i < size; i++) {
				current = q.poll();
				if(visited[current]) continue;
				visited[current] = true;
				
				if(current > max) {
					max = current;
				}
				
				for(int vertex : adjList[current]) {
					if(!visited[vertex]) {
						q.offer(vertex);
					}
				}
			}
		}
		return max;
	}
}
