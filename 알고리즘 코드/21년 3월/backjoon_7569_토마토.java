package com.study27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class position{
	int x,y,z;
	int cnt;

	public position(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}
public class backjoon_7569_토마토 {
	static int N,M,H;
	static int[][][] map;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	static int[] dz= {-1,1};
	static Queue<position> que=new LinkedList<>();
	public static void bfs() {
		while(!que.isEmpty()) {
			int x = que.peek().x;
			int y = que.peek().y;
			int z = que.peek().z;
			que.poll();
			//사방탐색하는 부분 
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				int nz = z;
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				if(map[nz][nx][ny]==-1) continue;
				if(map[nz][nx][ny]>0) continue;
				
				map[nz][nx][ny]=map[z][x][y]+1;
				que.offer(new position(nx,ny,nz));
			}
			//위아래 탐색하는 부분
			for (int i = 0; i < 2; i++) {
				int nx = x;
				int ny = y;
				int nz = z+dz[i];
				if(nz<0||nz>=H) continue;
				if(map[nz][nx][ny]==-1) continue;
				if(map[nz][nx][ny]>0) continue;
				
				map[nz][nx][ny]=map[z][x][y]+1;
				que.offer(new position(nx,ny,nz));
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		for (int i = 0; i <H; i++) {
			
			for (int j = 0; j <N; j++) {
				
				st = new StringTokenizer(br.readLine()," ");
				
				for (int k = 0; k <M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k]==1) {
						que.offer(new position(j,k,i));
					}
				}
			}
		}
		bfs();
		int max =0;
		for (int i = 0; i <H; i++) {
			for (int j = 0; j <N; j++) {
				for (int k = 0; k <M; k++) {
					if(map[i][j][k]==0) {
						System.out.println(-1);
						return;
					}
					if(map[i][j][k]>0&&map[i][j][k]>max) 
					{	
						max = map[i][j][k];
					}
				}
			}
		}
		if(max>0)
			max--;
		System.out.println(max);
		
		
	}

}
