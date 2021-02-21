package com.study22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

//문제이해하는데 오래걸림 -> 크기에 상관 없이 모든 체스판을 수정하는것이 아니라
//전체 체스판중 적게 수정하는 체스판을 찾아서 그때 수정해야하는 칸의 개수를 구하는문제 
//전체 칸 64개 중 수정해야하는 칸의수를 카운트 해서 64에서 뺀 최솟값을 구한다.



//푼 이후 ! 
//생각하지 못한점 첫번쨰가 W 가, B 두가지 모두 가능하다 
public class backjoon_1018_체스판다시칠하기 {
		static int N,M;
		static char[][] map;
		static int min;
	public static void find(int x, int y) {
		int n=x+8;
		int m=y+8;
		int cnt=0;
		char start = map[x][y];
		if(m>M||n>N) return;
		
		for (int i = x; i < n; i++) {
			for (int j = y; j < m; j++) {
				if(map[i][j]==start) {
					cnt++;
				}
				start = start=='W'? 'B':'W'; 	
			}
			start = start=='W'? 'B':'W'; 
		}
		
		min = Math.min(min, 64-cnt);
		start = start=='W'? 'B':'W'; 
		cnt=0;
		for (int i = x; i < n; i++) {
			for (int j = y; j < m; j++) {
				if(map[i][j]==start) {
					cnt++;
				}
				start = start=='W'? 'B':'W'; 	
			}
			start = start=='W'? 'B':'W'; 
		}
		min = Math.min(min, 64-cnt);
	}
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min =9999999;
		map= new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i]=st.nextToken().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				find(i,j);
					
			}
		}
		System.out.println(min);
	}

}
