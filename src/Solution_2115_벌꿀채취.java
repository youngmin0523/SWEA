import java.io.*;
import java.util.*;

class Solution_2115_벌꿀채취 {
    
    static int N, M, C, map[][], maxMap[][];
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            maxMap = new int[N][N]; // r, c 위치에서 연속된 M개의 벌통을 놓았을 경우 최대 수익
            
            for(int r = 0; r < N; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++){
                    map[r][c]= Integer.parseInt(st.nextToken());
                }
            }
            sb.append('#').append(tc).append(' ').append(solve()).append('\n');
        }
        System.out.println(sb.toString());
    }
    static int solve() {
    	makeMaxMap();
    	return processCombination();
    }
    static void makeMaxMap() {
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j <= N-M; j++) {
    			makeMaxSubset(i, j, 0, 0, 0);
    		}
    	}
    }
    static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
    	if(sum > C) return;
    	if(cnt == M) {
    		if(maxMap[i][j-M] < powSum) {
    			maxMap[i][j-M] = powSum;
    			return;
    		}
    	}
    	makeMaxSubset(i, j+1, cnt+1, sum+map[i][j], powSum + map[i][j] * map[i][j]);
    	makeMaxSubset(i, j+1, cnt+1, sum, powSum);
    }
    static int processCombination() {
		int max = 0, aBenefit = 0, bMaxBenefit;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j <= N - M; ++j) { // a 일꾼
				aBenefit = maxMap[i][j];
				
				bMaxBenefit = 0;
				// b 일꾼 조합
				for (int j2 = j + M; j2 <= N - M; j2++) { // 같은 행 뒷쪽 열
					if (bMaxBenefit < maxMap[i][j2]) bMaxBenefit = maxMap[i][j2];
				}
				
				for (int i2 = i + 1; i2 < N; i2++) { // 다음 행 첫열부터
					for (int j2 = 0; j2 <= N - M; j2++) {
						if (bMaxBenefit < maxMap[i2][j2]) bMaxBenefit = maxMap[i2][j2];
					}
				}
				if(max<aBenefit+bMaxBenefit) max = aBenefit+bMaxBenefit;
			}
		}
		return max;
	}
}