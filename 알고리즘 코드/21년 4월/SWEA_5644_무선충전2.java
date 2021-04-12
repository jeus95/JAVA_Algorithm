package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.util.StringTokenizer;

//
public class SWEA_5644_무선충전2 {
	static int map[][]=new int [11][11];
	static int dy[]= {0,-1,0,1,0};
	static int dx[]= {0,0,1,0,-1};
	static int[] pathA,pathB,playerA,playerB;
	static int[][]bc;
	static int M,A;
	static class user{
		int x,y,b;

		public user(int x, int y, int b) {
			super();
			this.x = x;
			this.y = y;
			this.b = b;
		}
		
	}
	static class charger{
		int x,y,c,p;

		public charger(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		playerA = new int[2]; //사용자 A의 위치
		playerB = new int[2]; //사용자 B의 위치
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			//이동 횟수, 배터리 충전소 개수
			M  = Integer.parseInt(st.nextToken());
			A  = Integer.parseInt(st.nextToken());
			
			playerA[0] = playerA[1]=1;
			playerB[0] = playerB[1]=10;
			
			pathA = new int[M+1];
			pathB = new int[M+1];
			bc = new int[A][4];
			
			//userA 이동 경로
			st= new StringTokenizer(br.readLine()," ");
			for (int i = 1; i <= M; i++) {
				pathA[i]=Integer.parseInt(st.nextToken());
			}
			
			//userA 이동 경로
			st= new StringTokenizer(br.readLine()," ");
			for (int i = 1; i <= M; i++) {
				pathB[i]=Integer.parseInt(st.nextToken());
			}
			//충전기 저장
			

			for (int i = 0; i < A; i++) {
				st= new StringTokenizer(br.readLine()," ");
				bc[i][0] =Integer.parseInt(st.nextToken());
				bc[i][1] =Integer.parseInt(st.nextToken());
				bc[i][2] =Integer.parseInt(st.nextToken());
				bc[i][3] =Integer.parseInt(st.nextToken());
				
				
			}

			System.out.println("#"+tc+" "+move());

		}
	}
	private static int move() {
		int totalSum =0;
		
		for (int t = 0; t <= M; t++) { //초기위치도 충전을 시도
			//두플레이어 궤적에 따라 이동
			playerA[0] += dx[pathA[t]];
			playerA[1] += dy[pathA[t]];
			
			playerB[0] += dx[pathA[t]];
			playerB[1] += dy[pathA[t]];
			
			//현 위치에서 최대 충전량 계산
			totalSum += getMaxCharge(){
				
			}
			
		}
		return totalSum;
	}
	private static int check(int a, int x, int y) {
		return Math.abs(bc[a][0]-x)+Math.abs(bc[a][1]-y) <=bc[a][2]? bc[a][3] :0;
	}
	private static int getMaxCharge() {
		int max=0;
		for (int a = 0; a < A; a++) { //플레이어 a 가 선택한 배터리 차저
			for (int b = 0; b < A; b++) { //플레이어 b가 선택한 배터리 차저
				int sum=0;
				int amountA = check(a,playerA[0],playerA[1]);
				int amountB = check(a,playerB[0],playerB[1]);
				
				//두 충전소가 다르면
				if(a != b) sum = amountA +amountB;
				//두충전소가 같다면
				else {
					sum = Math.max(amountA, amountB);
					
				}
				if(max <sum) max =sum; // 모두 수행한 횟수중에 가장 큰것을 더한다.
			}
		}
		return max;
	}
	
}
