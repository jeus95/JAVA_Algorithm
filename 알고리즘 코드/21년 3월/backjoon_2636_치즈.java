package com.study38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_2636_치즈 {
	static int[][] map;
	static int N,M;
	static int time=0;
	static int[] D; //인덱스를 time으로 가지고 현재 전체 치즈의 개수
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] isSelected;
	static int total;

	static class point{
		int x,y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void air() {
		isSelected = new boolean[N][M];
		
		Queue<point> que = new LinkedList<>();
		
		que.add(new point(0,0));
		
		isSelected[0][0]=true;
		
		while(!que.isEmpty()) {
			point temp = que.poll();
			
			int x = temp.x;
			int y = temp.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				
				if(map[nx][ny]==1) {
					
					isSelected[nx][ny]=true;
					map[nx][ny]=0;
					total--;
					continue;
				}
				
				if(isSelected[nx][ny]) continue;
				
				que.add(new point(nx,ny));
				
				isSelected[nx][ny]=true;
				
			}
		}
		
	}
	public static int clear() {
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==-1) {
					total--;
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		int end=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		int totalCheese=0;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());;
				if(map[i][j]==1) {
					totalCheese++;
				}
			}
		}
		total=totalCheese;
		int last=totalCheese;
		while(total>0) {
			air();
			//int temp = clear();
			time++;
			if(total>0) {
				last =total;
			}
			
		}
		System.out.println(time);
		System.out.println(last);
		
	}
}
