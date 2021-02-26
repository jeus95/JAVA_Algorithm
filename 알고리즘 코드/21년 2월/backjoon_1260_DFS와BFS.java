package com.study24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.InputMap;
class point{
	int x,y;

	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
public class backjoon_1260_DFS¿ÍBFS {
	static int[][] map;
	static int N,M;
	static boolean isSelected[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int Start = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		isSelected = new boolean[N+1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			map[x][y] =map[y][x]= 1;
		}
		dfs(Start);
		System.out.println();
		isSelected = new boolean[N+1];
		bfs(Start);
	}
	private static void dfs(int index) {
		if(isSelected[index]) return;
		
		isSelected[index] = true;
		System.out.print(index+" ");
		for (int i = 1; i <=N; i++) {
			if(map[index][i]==1) {
				dfs(i);
			}
		}

	}
	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		isSelected[start]=true;
		
		while(!que.isEmpty()){
			int x = que.poll();
			System.out.print(x+ " ");
			
			for (int i = 1; i <=N; i++) {
				if(map[x][i]==1&&!isSelected[i]) {
					que.offer(i);
					isSelected[i]=true;
				}
				
			}
		}
	}
}
