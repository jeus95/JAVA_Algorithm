package com.study24;
//A를 바닥에 놓게 되면 F가 사용 불가능
//그럼 2번 주사위에서 F가 가지고잇는 숫자에 해당하는 번호와 그 맞은편에 있는 번호를 사용 불가능
//인덱스가 0인경우 5가 맞은편
//인덱스가 1인 경우 3이 맞은편
//인덱스가 2인경우 4가 맞은편
//-> 그렇게 숫자들을 제거하고 남은 숫자들의 max값만 찾아서 더한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class backjoon_2116_주사위쌓기 {
	static int N,Max=0;
	static int[][] dice;
	static boolean[][] isSelected;
	public static void cal() {
		for (int j = 0; j <6; j++) {
			isSelected= new boolean[N][6];
			int num = dice[0][j];
			isSelected[0][j]=true;
			if(j==0) 
			{
				isSelected[0][5]=true;
			}
			if(j==1) 
			{
				isSelected[0][3]=true;

			}
			if(j==2)
			{
				isSelected[0][4]=true;
			}
			if(j==3) 
			{
				isSelected[0][1]=true;
			}
			if(j==4) 
			{
				isSelected[0][2]=true;
			}
			if(j==5) 
			{
				isSelected[0][0]=true;
			}
			
			for (int i = 1; i <N; i++) {
				for (int k = 0; k <6; k++) {
					
					if(dice[i][k]==num) {
						
						isSelected[i][k]=true;
						
						if(k==0) 
						{
							isSelected[i][5]=true;
							num=dice[i][5];
							break;
						}
						if(k==1) 
						{
							isSelected[i][3]=true;
							num=dice[i][3];
							break;
						}
						if(k==2)
						{
							isSelected[i][4]=true;
							num=dice[i][4];
							break;
						}
						if(k==3) 
						{
							isSelected[i][1]=true;
							num=dice[i][1];
							break;
						}
						if(k==4) 
						{
							isSelected[i][2]=true;
							num=dice[i][2];
							break;
						}
						if(k==5) 
						{
							isSelected[i][0]=true;
							num=dice[i][0];
							break;
						}
					}
				}
				
			}
			int Sum=0;
			for (int i = 0; i < N; i++) {
				int Lmax =0;
				
				for (int k = 0; k < 6; k++) {
					if(isSelected[i][k]) continue;
					
					if(Lmax<dice[i][k]) {
						Lmax=dice[i][k];
					}
					
				}
				Sum+=Lmax;
			}
			
			if(Max<Sum) {
				Max=Sum;
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		isSelected= new boolean[N][6];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			dice[i][0]=Integer.parseInt(st.nextToken());
			dice[i][1]=Integer.parseInt(st.nextToken());
			dice[i][2]=Integer.parseInt(st.nextToken());
			dice[i][3]=Integer.parseInt(st.nextToken());
			dice[i][4]=Integer.parseInt(st.nextToken());
			dice[i][5]=Integer.parseInt(st.nextToken());
			
		}
		
		cal();
		System.out.println(Max);
	}
}
