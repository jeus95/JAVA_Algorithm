package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import org.omg.CosNaming.IstringHelper;

public class SWEA_1249_보급로 {
	static int map[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static int ans[][];
	static int N;
	static int min =Integer.MAX_VALUE;
	static class point{
		int x,y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans = new int[N][N];
			min=Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
			Arrays.fill(ans[i], Integer.MAX_VALUE);
			}
			 ans[0][0] = 0;
			 for(int i=0; i<N; i++){
	                String[] temp = br.readLine().split("");
	                for(int j=0; j<N; j++){
	                    map[i][j] = Integer.parseInt(temp[j]);
	                }
	        }
			 
			bfs();
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					
//					System.out.print(ans[i][j]+" ");
//				}
//				System.out.println();
//			}
			System.out.println("#"+t+" "+min);
		}
	}
	public static void bfs() {
		Queue<point> que = new LinkedList<point>(); 
		boolean isSelected[][] = new boolean[N][N];
		
		que.add(new point(0,0));
		
		isSelected[0][0]=true;
		
		while(!que.isEmpty()) {
			
			point cur = que.poll();
			
			if(cur.x==N-1 && cur.y==N-1) {
				min= min > ans[N-1][N-1] ? ans[N-1][N-1] : min;
			}
	          if(min <= ans[cur.x][cur.y])
	                continue;
	           
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				//if(isSelected[nx][ny]) continue;

				if(!isSelected[nx][ny]||ans[nx][ny] > ans[cur.x][cur.y] + map[nx][ny]) {
				
				isSelected[nx][ny]=true;
				ans[nx][ny] = ans[cur.x][cur.y] + map[nx][ny];
				que.add(new point(nx,ny));
				}
			}
		}
		
	}
}
