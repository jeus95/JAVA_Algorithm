package com.study16;

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
		//��, �� , �� , �� 
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
