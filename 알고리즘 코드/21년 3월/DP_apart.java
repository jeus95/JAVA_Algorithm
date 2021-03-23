package com.study37;

import java.util.Scanner;

//F(n) N 층의 건물에 칠 할 수 있는 방법의 수! 
//DFS를 이용한 해결
public class DP_apart {
	static int[] D;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		D= new int[N];
		DP(N);
		System.out.println(DP(N));
	}
	public static int DP(int i) {
		if(i==1)
			return 2;
		if(i==2)
			return 3;
		
		return DP(i-1)+DP(i-2);
	}
}
