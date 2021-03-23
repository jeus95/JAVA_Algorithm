package com.study37;

import java.util.Scanner;

public class backjoon_1463_1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int[] D;
		D =new int[1000001];
		
		D[0]=0;
		D[1]=0;
		for (int i = 2; i <= X; i++) {
			int min = Integer.MAX_VALUE;
			if(D[i-1]+1<min)
				min = D[i-1]+1;
			
			if(i>=2&&i%2==0&&D[i/2]+1<min)
				min = D[i/2]+1;

			if(i>=3&&i%3==0&&D[i/3]+1<min)
				min = D[i/3]+1;
			
			D[i]=min;
		}
		System.out.println(D[X]);
	}

}
