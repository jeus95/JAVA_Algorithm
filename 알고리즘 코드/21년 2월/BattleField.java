//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc
package com.study09;

import java.util.Arrays;
import java.util.Scanner;

public class BattleField {
	static char map[][];
	static int x;
	static int y;
	static char dir;
	static int row;
	static int col;

	public static void move(char A) {
		
		
		switch (A) {
		
		case 'U' : dir='^';
				   map[x][y]='^';
				   if(x-1>=0&&map[x-1][y]=='.')
				   {
					   map[x-1][y]=dir;
					   map[x][y]='.';
					   x--;
				   }
			
				   break;
		case 'D' : dir='v';
		 		   map[x][y]='v';
				   if(x+1<row&&map[x+1][y]=='.')
				   {
					   map[x+1][y]=dir;
					   map[x][y]='.';
					   x++;
				   }
			
				   break;
		case 'L' : 
				   dir='<';
				   map[x][y]='<';
				   if(y-1>=0&&map[x][y-1]=='.')
				   {
					   map[x][y-1]=dir;
					   map[x][y]='.';
					   y--;
				   }
			
				   break;
		case 'R' : 
					dir='>';
					map[x][y]='>';
					//System.out.println(row);
					//System.out.println(map[x][y+1]);
					if(y+1<col&&map[x][y+1]=='.')
					{
						map[x][y+1]=dir;
						map[x][y]='.';
						y++;
					}
			
					break;
		case 'S' : 	
					
					if(dir=='^') {
						
						for(int i=1; i<=x;i++) {
							if(map[x-i][y]=='#')
								break;
							if(map[x-i][y]=='*') {
								map[x-i][y]='.';
								break;
							}
						}
					}
					if(dir=='v') {
						for(int i=1; i<row-x;i++) {
							if(map[x+i][y]=='#')
								break;
							if(map[x+i][y]=='*') {
								map[x+i][y]='.';
								break;
							}
						}
					}
					if(dir=='<') {
						for(int i=1; i<=y;i++) {
							if(map[x][y-i]=='#')
								break;
							if(map[x][y-i]=='*') {
								map[x][y-i]='.';
								break;
							}
						}
					}
					if(dir=='>') {
						for(int i=1; i<col-y;i++) {
							if(map[x][y+i]=='#')
								break;
							if(map[x][y+i]=='*') {
								map[x][y+i]='.';
								break;
							}
						}
					}
			
					break;

		}
		
		
		
		
		
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int t=1;t<=TC;t++) {
			row = sc.nextInt(); 
			col = sc.nextInt();
			
			map = new char[row][col];
			
			for(int i=0;i<row;i++) {
					map[i] = sc.next().toCharArray();
				
			}
			for(int i =0 ; i< row;i++) {
				for(int j=0; j<col;j++) {
					if(map[i][j]=='>'||map[i][j]=='^'||map[i][j]=='<'||map[i][j]=='v') {
						x=i;
						y=j;
						dir=map[i][j];
					}
				}
			}
			int cnt = sc.nextInt();
			char A[]=new char[cnt];
			A=sc.next().toCharArray();
			int k=0;
			while(true) {
				if(k>=cnt)
					break;
				move(A[k++]);
				
//				for(int i=0;i<row;i++) {
//					for(int j=0;j<col;j++)
//					{
//						System.out.print(map[i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println("============");
			}
	
			System.out.print("#"+t);
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++)
				{
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		}
		
	}

}
