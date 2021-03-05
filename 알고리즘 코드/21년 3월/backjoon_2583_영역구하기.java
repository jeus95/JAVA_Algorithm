package com.study28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class backjoon_2583_영역구하기 {
	static int M,N,K,cnt;
	static int map[][];
	static boolean isSelected[][];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void DFS(int x, int y) {
		
		for (int i = 0; i < 4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<0||ny<0||nx>=N||ny>=M) continue;
			if(map[nx][ny]==-1) continue;
			if(isSelected[nx][ny]) continue;
			isSelected[nx][ny] = true;
			map[nx][ny]=cnt;
			DFS(nx,ny);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		K =Integer.parseInt(st.nextToken());
		isSelected= new boolean [N][M];
		map= new int[N][M];
		cnt = 0;
		for (int i = 0; i <K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sx =Integer.parseInt(st.nextToken());
			int sy =Integer.parseInt(st.nextToken());
			int ex =Integer.parseInt(st.nextToken());
			int ey =Integer.parseInt(st.nextToken());
			
			for (int j = sy; j <ey; j++) {
				for (int j2 = sx; j2 <ex; j2++) {
					
					map[j][j2]=-1;
					isSelected[j][j2]=true;
					
				}
			}
		}
		for (int j = 0; j < N; j++) {
			for (int j2 = 0; j2 < M; j2++) {
				if(!isSelected[j][j2]) {
				isSelected[j][j2]=true;
				map[j][j2]=cnt;
				DFS(j,j2);
				cnt++;
			}
		 }
		}
		//System.out.println(Arrays.deepToString(map));
		int[] numbers = new int[cnt+1];
		for (int i = 0; i <=cnt; i++) {
			int Lcnt=0;
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if(map[j][j2]==i)
					{
						Lcnt++;
					}
				}
			}
			
		numbers[i]=Lcnt;
		}
		Arrays.sort(numbers);
		System.out.println(cnt);
		for(int z:numbers) {
			if(z!=0)
			System.out.print(z+" ");
		}
	}
	
}
