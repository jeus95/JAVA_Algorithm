package com.study19;

/*먼저 사방탐색을 통해서 주변 배추들을 탐색하고 더이상 탐색할 배추가 없을경우 벌레 마리수를 카운트!
 * 따로 불린 배열을 사용하지 않고 2로 마킹
 * 아마 BFS
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1012_유기농배추 {
		static int  N;
		static int M;
		static int K;
		static int bugcnt;
		static int map[][];
		static int cnt;
		static boolean flag;
		//하, 우 , 상 , 좌 
		static int[] dx= {1,0,-1,0};
		static int[] dy= {0,1,0,-1};
		public static void find(int x , int y ) {

			
			

			for (int i = 0; i < 4; i++) {
				 int nx = x+dx[i];
				 int ny = y+dy[i];
				 if(nx<0|| ny<0||ny>=M||nx>=N) continue;
				 if(map[nx][ny]==0) continue;
				 if(map[nx][ny]==2) continue;
				 map[nx][ny]=2;
				 
				 find(nx,ny);
				 
				 //flag=true;
				}
			
		}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {
			cnt=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M= Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map= new int [N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			map[x][y]=1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1) {
				map[i][j]=2;
				
				find(i,j);		
				cnt++;
			}
		}
		}
		System.out.println(cnt);
	}
	}
}
