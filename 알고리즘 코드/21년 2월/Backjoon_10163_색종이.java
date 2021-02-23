package com.study23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Backjoon_10163_»öÁ¾ÀÌ {
	static int[][] map;
	static int x;
	static int y;
	static int row;
	static int col;
	static int cnt;
	static int level;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int [101][101];
		level=1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			
			for (int j = x; j < x+row; j++) {
				for (int j2 = y; j2 < y+col; j2++) {
					map[j][j2]=level;
					
				}
			}
			level++;
		}
		level--;
		cnt=0;
		for (int i = 1; i <= level; i++) {
			
		
		for (int j = 0; j < 101; j++) {
			
			for (int j2 = 0; j2 < 101; j2++) {
				
				if(map[j][j2]==i) {
					cnt++;
				}
			}
			
		}
		System.out.println(cnt);
		cnt=0;
	}
	}
}
