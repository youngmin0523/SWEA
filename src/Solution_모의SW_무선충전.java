import java.util.*;
import java.io.*;

public class Solution_모의SW_무선충전 {
	static class Place{
		int x, y;
		Place max_charger;
		List<Place> chargers;
		int c, p;

		public Place(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public Place(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
		
	}
	
	static int M, A, res;
	static Place userA[], userB[], charger[];
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			userA = new Place[M+1];
			userB = new Place[M+1];
			charger = new Place[A];
			userA[0] = new Place(1, 1);
			userB[0] = new Place(10, 10);
			st = new StringTokenizer(br.readLine());
			setUser(userA);
			st = new StringTokenizer(br.readLine());
			setUser(userB);
			for(int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				charger[i] = new Place(
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			process();
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	static void process() {
		int distance;
		for(int i = 0; i <= M; i++) {
			userA[i].chargers = new ArrayList<>();
			userB[i].chargers = new ArrayList<>();			
			for(int j = 0; j < A; j++) {
				distance = get_distance(userA[i], charger[j]);
				if(distance <= charger[j].c) {
					userA[i].chargers.add(charger[j]);
					if(userA[i].max_charger == null) {
						userA[i].max_charger = charger[j];
					}
					else if(charger[j].p > userA[i].max_charger.p) {
						userA[i].max_charger = charger[j];
					}
				}
				distance = get_distance(userB[i], charger[j]);
				if(distance <= charger[j].c) {
					userB[i].chargers.add(charger[j]);
					if(userB[i].max_charger == null) {
						userB[i].max_charger = charger[j];
					}
					else if(charger[j].p > userB[i].max_charger.p) {
						userB[i].max_charger = charger[j];
					}
				}
			}
			if(userA[i].max_charger != null && userB[i].max_charger != null) {
				if(userA[i].max_charger == userB[i].max_charger) {
					int max = userA[i].max_charger.p;
					for(Place charger : userA[i].chargers) {
						if(charger != userA[i].max_charger) {
							int tmp = charger.p + userA[i].max_charger.p;
							if(tmp > max) {
								max = tmp;
							}
						}
					}
					for(Place charger : userB[i].chargers) {
						if(charger != userB[i].max_charger) {
							int tmp = charger.p + userB[i].max_charger.p;
							if(tmp > max) {
								max = tmp;
							}
						}
					}
					res += max;
				}
				else {
					res += userA[i].max_charger.p + userB[i].max_charger.p;
				}
			}
			else if(userA[i].max_charger != null) {
				res += userA[i].max_charger.p;
			}
			else if(userB[i].max_charger != null) {
				res += userB[i].max_charger.p;
			}
		}
	}
	static int get_distance(Place user, Place charger) {
		return Math.abs(user.x - charger.x) + Math.abs(user.y - charger.y);
	}
	static void setUser(Place[] user) {
		for(int i = 1; i <= M; i++) {
			switch(Integer.parseInt(st.nextToken())) {
			case 0:
				user[i] = new Place(user[i-1].x, user[i-1].y);
				break;
			case 1:
				user[i] = new Place(user[i-1].x, user[i-1].y-1);
				break;
			case 2:
				user[i] = new Place(user[i-1].x+1, user[i-1].y);
				break;
			case 3:
				user[i] = new Place(user[i-1].x, user[i-1].y+1);
				break;
			case 4:
				user[i] = new Place(user[i-1].x-1, user[i-1].y);
			}
		}
	}
}
