package com.study19;

/*���� ���Ž���� ���ؼ� �ֺ� ���ߵ��� Ž���ϰ� ���̻� Ž���� ���߰� ������� ���� �������� ī��Ʈ!
 * ���� �Ҹ� �迭�� ������� �ʰ� 2�� ��ŷ
 * �Ƹ� BFS
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1012_�������� {
		static int  N;
		static int M;
		static int K;
		static int bugcnt;
		static int map[][];
		static int cnt;
		static boolean flag;
		//��, �� , �� , �� 
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
