package com.study37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_1149_RGB거리 {
	static int N;
	static int[][] color;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		color = new int[N][3];
		int[][] D = new int[N][3];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				color[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		D[0][1]=color[0][1];
		D[0][2]=color[0][2];
		D[0][3]=color[0][3];
		

		
		for (int i = 1; i < N; i++) {
			D[i][0]=Math.min(D[i-1][1],D[i-1][2]) + color[i][0];
			D[i][1]=Math.min(D[i-1][0],D[i-1][2]) + color[i][1];
			D[i][2]=Math.min(D[i-1][0],D[i-1][1]) + color[i][2];
		}
		
		System.out.println(Math.min(Math.min(D[N-1][0],D[N-1][1]),D[N-1][0]));
	}

}
