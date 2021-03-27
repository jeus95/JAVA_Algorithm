package com.study40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BACKJOON_14502_연구소 {
	static class virus{
		int x,y;

		public virus(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	
	}
	static int N,M,max;
	static int[][] map;
	static ArrayList<virus> virus;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		max = Integer.MIN_VALUE;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		virus=new ArrayList<>();
		map = new int [N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					virus.add(new virus(i,j));
				}
			}
		}
		makeWall(0);
		
		System.out.println(max);
	}
	public static void makeWall(int cnt) {
		if(cnt==3) {
			virus();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1) continue;
				if(map[i][j]==2) continue;
				
				map[i][j]=1;//벽 짓기
				makeWall(cnt+1);
				map[i][j]=0;
				
			}
		}
	}
	private static void virus() {
		int[][] cmap= copy(map);
		
		Queue<virus> que = new LinkedList<virus>();
		for (int i = 0; i < virus.size(); i++) {
			que.add(virus.get(i));
		}
		while(!que.isEmpty()) {
			virus curr = que.poll();
			int x = curr.x;
			int y = curr.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x +dx[i];
				int ny = y +dy[i];
				
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				
				if(cmap[nx][ny]==1) continue;
				if(cmap[nx][ny]==2) continue;
				
				cmap[nx][ny]=2;
				que.add(new virus(nx,ny));
			}
		}
		int cnt=0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(cmap[i][j]==0) {
					cnt++;
				}
			}
		}
		max = Math.max(cnt, max);
	}
	public static int[][] copy(int [][] arr) {

		int[][] copy = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}
}
