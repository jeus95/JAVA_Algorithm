package com.study08;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1954_number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		int[] dx = {0,1,-1,0};
		int[] dy = {1,0,0,-1};
		
		for(int t = 1; t<=TC;t++ ) {
			
			int N =sc.nextInt();
			
			int[][] numbers= new int[N][N];
			boolean [][]map = new boolean[N][N];
			
			//int cnt=0;
			int cnt=2;
			int x=0;
			int y=0;
			int dir=0;
			int nx;
			int ny;
			numbers[0][0]=1;
			while(true) {
					if(dir==0&&(y+1>=N||map[x][y+1]==true))
					{	//우측 이동
						dir=1;
					}
					if(dir==1&&(x+1>=N||map[x+1][y]==true)) {
						dir=2;
					}
					if(dir==2&&(y-1<=0||map[x][y-1]==true)) {
						dir=3;
					}
					if(dir==3&&(x-1<=0||map[x-1][y]==true)) {
						dir=0;
					}
					if(y+1<N&&y-1>0&&x-1>0&&x+1<N&&
			map[x-1][y]==true&&map[x+1][y]==true&&map[x][y-1]==true&&map[x][y+1]==true)
						break;
					
					
					x=x+dx[dir];
					
					y=y+dy[dir];
					
					numbers[x][y]=cnt++;
					
					map[x][y]=true;
			}
			for(int[] z: numbers)
		System.out.println(Arrays.toString(z));
		}
	}
}
