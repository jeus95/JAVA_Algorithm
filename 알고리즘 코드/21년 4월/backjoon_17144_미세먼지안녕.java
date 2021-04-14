package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//bfs를 이용한 해결 미세먼지들을 bfs에 집어 넣는 방법 생각, 먼저 입력이 들어간 큐를 다 돌리고 난 후에 전체 배열을 다시 체크해서 큐에 집어 넣는다.
public class backjoon_17144_미세먼지안녕 {
	static int R,C,T;
	static int map[][];
	static Queue<int[]> que= new LinkedList<int[]>();
	static int clear[];
	//공기청정기가 나아가는 방향을 순서로 우 상 좌 하
	//벽을 만나면 방향을 트는것을 생각
	static int dx[]= {0,-1,0,1};
	static int dx2[]= {0,1,0,-1};
	static int dy[]= {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int [R][C];
		
		clear= new int[2];//항상 1번열에 설치 되어 있으므로 순서대로 나온다 ->1차원 배열로 표현가능
		for (int i = 0; i < R; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					clear[0]=i;
					clear[1]=j; //두번째 -1이 저장된다 따라서 -> [0]에 -1을 해주면 공기청정기 첫번째 좌표
				}
				
			}
			
		}

		for (int i = 0; i < T; i++) {
			initque();
			mise();
			wind();
		}
		System.out.println(sum());
		
	}
	public static void mise() {
		//미세 먼지 확산
		while(!que.isEmpty()) {
			int [] cur = que.poll();
			int x = cur[0];
			int y = cur[1];
			int cost = cur[2];
			
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				int ncost = cost/5;
				//범위를 벗어난 경우
				if(nx<0||ny<0||nx>=R||ny>=C) continue;
				//공기청정기인 경우
				if(map[nx][ny]==-1) continue;
				map[nx][ny]+=ncost;
				map[x][y]-=ncost;
			}
			
			
		}
	}
	public static void initque() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]>0) {
					//모든 미세먼지를 찾아서 큐에 삽입
					que.add(new int[] {i,j,map[i][j]});
				}
			}
		}
	}
	public static int sum() {
		int sum =0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				//현재 미세먼지를 모두 더한다
				sum+=map[i][j];
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		return sum+2;
	}
	public static void wind() {
		//공기청정기의 위쪽의 앞부분을 설정
		int x1 = clear[0]-1;
		int y1 = clear[1]+1;
		
		//공기청정기의 아래쪽의 앞부분을 설정
		int x2 = clear[0];
		int y2 = clear[1]+1;
		
		//이전 비용 저장
		int cost=map[x1][y1];
		
		map[x1][y1]=0;
		
		int i=0;
		while(true) {
			int ncost = cost;
			int nx = x1+dx[i];
			int ny = y1+dy[i];
			if(nx==clear[0]-1&&ny==clear[1]) break;
			
			if(nx<0||ny<0||nx>=R||ny>=C) {
				i++;
				continue;
			}
			cost=map[nx][ny];
			if(cost==-1) break;
			map[nx][ny]=ncost;
					
					
			x1=nx;
			y1=ny;
		}
		//System.out.println(sum());
		
		
		cost=map[x2][y2];
		map[x2][y2]=0;
		i=0;
		while(true) {
			int ncost = cost;
			int nx = x2+dx2[i];
			int ny = y2+dy[i];
			if(nx==clear[0]&&ny==clear[1]) break;
			if(nx<0||ny<0||nx>=R||ny>=C) {
				i++;
				continue;
			}
			cost=map[nx][ny];
			if(cost==-1) break;
			map[nx][ny]=ncost;
					
					
			x2=nx;
			y2=ny;
		}
		
		
	}
}
