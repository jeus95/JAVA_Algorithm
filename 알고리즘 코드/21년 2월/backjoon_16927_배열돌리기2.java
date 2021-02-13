package com.study16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_16927_배열돌리기2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine()," ");
		int arr[][];
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[]dx= {0,1,0,-1 };
		int[]dy= {1,0,-1,0 };
		
		arr= new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int level=(Math.min(N, M)/2);
		for (int j = 0; j < R%14; j++) {
			
		
		for (int i = 0; i < level; i++) {
			int dir=0;
			int temp = arr[i][i];
			int x=i;
			int y=i;
			while(dir<4) {
					
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx>= i && ny>=i&& nx<N-i&&ny<M-i) {
					arr[x][y] = arr[nx][ny]; // 현재위치로 이사시키고
					x = nx; // 현재 점을 다음점의 값으로 바꾸고 while문 다시 ㄱㄱ
					y = ny;
				}else {
					dir++;
				}
				//arr[i+1][i]=temp;
				
				}
				arr[i+1][i]=temp;
			}
			}
			for (int i = 0; i <N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(arr[i][j]+ " ");
				}
				System.out.println();
			}
			
		}
	}
