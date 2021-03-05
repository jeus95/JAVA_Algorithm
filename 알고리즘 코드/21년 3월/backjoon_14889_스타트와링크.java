package com.study29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.InputMap;

public class backjoon_14889_스타트와링크 {
	static int map[][];
	static int R,N;
	static boolean[] isSelected;
	static int[] start,link;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isSelected = new boolean[N];
		R=N/2;
		start = new int[R];
		link = new int[R];
		min=999999;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		combination(0,0);
		System.out.println(min);
		
	}
	public static void combination(int cnt,int target) {	
		if(target==R) {
			int Scnt=0;
			int Lcnt=0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					start[Scnt++]=i;
					continue;
				}
				
				link[Lcnt++]=i;
			}
			min = Math.min(min, sum());
			return;
		}
		if(cnt ==N) {
			return;
		}
		if(isSelected[cnt]) return;
		isSelected[cnt]=true;
		combination(cnt+1, target+1);
		isSelected[cnt]=false;
		combination(cnt+1, target);
	}
	
	public static int sum() {
		int Ssum=0;
		int Lsum=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < R; j++) {
				if(i==j) continue;
				Ssum+=map[start[i]][start[j]];
				Lsum+=map[link[i]][link[j]];
			}
		}
		return Math.abs(Ssum-Lsum);
	}

}
