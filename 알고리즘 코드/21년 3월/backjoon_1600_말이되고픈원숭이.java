package com.study38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_1600_¸»ÀÌµÇ°íÇÂ¿ø¼þÀÌ {
	static int K,W,H;
	static int[][] map;
	static boolean[][][] isSelected;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] hx = {1,2,2,1,-1,-2,-2,-1}; 
	static int[] hy = {2,1,-1,-2,-2,-1,1,2};
	
	
	static class point{
		int x, y;
		int count; // ÁøÇàµÈ ¿òÁ÷È½¼ö 
		int jump; //¸»ÀÌ ¶Ú È½¼ö
		
		public point(int x, int y, int count,int jump) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.jump = jump;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		K = Integer.parseInt(br.readLine());
		st =new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map= new int[H][W];
		for (int i = 0; i < H; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		
		isSelected = new boolean[K+1][H][W];
		
		Queue<point> que =new LinkedList<>();
		
		que.add(new point(0,0,0,0));
		
		while(!que.isEmpty()) {
			
			point curr = que.poll();
			int x = curr.x;
			int y = curr.y;
			int cnt = curr.count;
			if(x == H-1&& y ==W-1)
				return cnt;
			
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0||ny<0||nx>=H||ny>=W) continue;
				
				if(isSelected[curr.jump][nx][ny]) continue;
				
				if(map[nx][ny]==1) continue;
				
				if(nx==H-1&&ny==W-1) {
					
					return cnt+1;
				}
				
				isSelected[curr.jump][nx][ny]=true;
				
				que.add(new point(nx,ny,cnt+1,curr.jump));
			}
			
			
			if(curr.jump+1<=K) {
				
				for (int i = 0; i < 8; i++) {
					int nx = x+hx[i];
					int ny = y+hy[i];
					
					if(nx<0||ny<0||nx>=H||ny>=W) continue;
					
					if(isSelected[curr.jump+1][nx][ny]) continue;
					
					if(map[nx][ny]==1) continue;
					
					if(nx==H-1&&ny==W-1) {
						
						return cnt+1;
					}
					
					isSelected[curr.jump+1][nx][ny]=true;
					
					que.add(new point(nx,ny,cnt+1,curr.jump+1));
				}
				
				
				
			}
			
			
			
			
			
			
			
		}
		
		return -1;
	}
}
