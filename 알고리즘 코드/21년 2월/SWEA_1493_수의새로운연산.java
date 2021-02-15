package com.study17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0,0에 값을 주고 
//i,0부터 j를 빼나가면서 
//i-j,j,로 i=j가 같아질때까지 점을 찍고 
//입력이 들어오면 해당되는 점의 i j 값을 받아서 서로 더하는방법
public class SWEA_1493_수의새로운연산 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int dot[][] = new int [300][300];
		int cnt=1;
		for(int i=0;i<300;i++)
			for(int j=0;j<=i;j++) {
				dot[i-j][j]=cnt++;
			}
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int x1 = 0,y1=0;
			int x2=0,y2 = 0;
			for (int i = 0; i < 300; i++) {
				for (int j = 0; j < 300; j++) {
					if(dot[i][j]==A) {
						x1=i+1;
						y1=j+1;
						System.out.println(x1);
						System.out.println(y1);
					}
					if(dot[i][j]==B)
					{
						x2=i+1;
						y2=j+1;
						System.out.println(x2);
						System.out.println(y2);
					}	
				}
			}
			int x=x1+x2;
			int y=y1+y2;
			
			System.out.println(x);
			System.out.println(y);
			System.out.println("#"+tc+ " "+ dot[x-1][y-1]);
		}
		
	}

}
