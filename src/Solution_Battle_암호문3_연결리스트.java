import java.util.*;
import java.io.*;

public class Solution_Battle_암호문3_연결리스트 {
	static class Node{
		String num;
		Node link;
		public Node(String num, Node link) {
			super();
			this.num = num;
			this.link = link;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [num=");
			builder.append(num);
			builder.append(", link=");
			builder.append(link);
			builder.append("]");
			return builder.toString();
		}
		
	}
	
	static int N, M, x, y;
	static Node head, current, tail;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			head = new Node(st.nextToken(), null);
			current = head;
			for(int i = 1; i < N; i++) {
				current.link = new Node(st.nextToken(), null);
				current = current.link;
			}
			tail = current;
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				switch(st.nextToken().charAt(0)) {
				case 'I':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					current = head;
					if(x == 0) {
						current = new Node(st.nextToken(), head);
						head = current;
						for(int j = 1; j < y; j++) {
							current.link = new Node(st.nextToken(), current.link);
							current = current.link;
						}
					}
					else {
						for(int j = 1; j < x; j++) {
							current = current.link;
						}
						for(int j = 0; j < y; j++) {
							current.link = new Node(st.nextToken(), current.link);
							current = current.link;
						}
					}
					break;
				case 'D':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					current = head;
					if(x == 0) {
						for(int j = 0; j < y; j++) {
							head = head.link;
						}
					}
					else {
						for(int j = 1; j < x; j++) {
							current = current.link;
						}
						for(int j = 0; j < y; j++) {
							current.link = current.link.link;
						}
					}
					break;
				case 'A':
					y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; j++) {
						tail.link = new Node(st.nextToken(), null);
						tail = tail.link;
					}
					break;
				}
			}
			sb.append("#").append(tc);
			current = head;
			for(int i = 0; i < 10; i++) {
				sb.append(" ").append(current.num);
				current = current.link;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}
