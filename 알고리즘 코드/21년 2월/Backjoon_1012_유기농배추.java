package com.study16;

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
		//하, 우 , 상 , 좌 
		static int[] dx= {1,0,-1,0};
		static int[] dy= {0,1,0,-1};
		public static void find(int x , int y ) {
			//if()
				for (int i = 0; i < 4; i++) {
				 int nx = x+dx[i];
				 int ny = y+dy[i];
				 if(nx<0|| ny<0||ny>=M||nx>=N) continue;
				 if(map[nx][ny]==0) continue;
				 
				 find(nx,ny);
				}
				
		}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map= new int [N][M];S
		for (int tc = 0; tc < T; tc++) {
			
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			map[x][y]=1;
		}
		
	}
	}
}
