package com.study08;

import java.util.Scanner;

public class SWEA_1210_Ladder1 {
	static int[][] Ladder = new int[100][100];
	//static boolean[][] map = new boolean[100][100];
	static int nx;
	static int ny;
	
	public static void searchl() {
		
		if(ny-1 >=0&&Ladder[nx][ny-1]==1) //좌측에 길이 있는 경우
		{	
			Ladder[nx][ny]=0;
			ny=ny-1;
			//map[nx][ny]=true;
			return;
		}
		if(ny+1 <100&&Ladder[nx][ny+1]==1)//우측에 길이 있는 경우
		{	
			Ladder[nx][ny]=0;
			ny=ny+1;
			//map[nx][ny]=true;
			return;
		}
		if(nx >0&&Ladder[nx-1][ny]==1) {//위쪽으로 
			
			Ladder[nx][ny]=0;
			nx=nx-1;
			//map[nx][ny]=true;
			return;
		}
		if(nx==0)
			return;
		

	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//int[][] Ladder = new int[100][100];
		
		for(int t=0; t<10;t++) {
			
			int TC = sc.nextInt();
			
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
			
					int tmp=sc.nextInt();
					Ladder[i][j]=tmp;
					
					if(tmp==2) {
						nx=i;
						ny=j;
						//map[nx][ny]=true;
					}
				}
			}
			
			
			
		
			while(true) {
				searchl();
				if(nx==0) {
				break;
				}
			}
			System.out.println("#"+TC +" "+ ny );
		}
	}

}
