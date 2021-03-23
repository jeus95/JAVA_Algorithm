package com.study37;

import java.util.Arrays;
import java.util.Scanner;

public class DP1_MinCoinTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] D = new int[money+1];
		
		//D[i-1],D[i-4],D[i-6]
		
		D[0]=0;
		for (int i = 1; i <= money; i++) {
			int min = Integer.MAX_VALUE;
			if(D[i-1]+1<min)//1���ϳ� ���� �õ�
				min=D[i-1]+1;
			
			if(i>=4 && D[i-4]+1<min)//4���� �ϳ� ���� �õ�
				min = D[i-4]+1;
			
			if(i>=6 && D[i-6]+1<min)//6���� �ϳ� ���� �õ�
				min = D[i-6]+1;
			
			D[i] = min;
		}
		System.out.println(D[money]);
		System.out.println(Arrays.toString(D));
	}
}
