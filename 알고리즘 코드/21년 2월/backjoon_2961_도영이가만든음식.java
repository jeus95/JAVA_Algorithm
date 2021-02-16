package com.study18;

import java.util.Scanner;

public class backjoon_2961_도영이가만든음식 {

	static int S[]; //신맛 
	static int B[]; //쓴맛
	static int N;
	static int min=1000000000;
	public static void dfs(int cnt,int sumS , int sumB) {
		
		//int Lmin = (sumS>sumB)? sumS-sumB: sumB-sumS;//로컬 미니멈
		int Lmin = Math.abs(sumS-sumB); // 절대값을 이용한 연산 위에것을 더 줄일 수 있다.
		if(sumS!=1&&min>Lmin) min = Lmin;
		if(cnt==N) return;
		dfs(cnt+1,sumS*S[cnt],sumB+B[cnt]);//선택을 한 경우
		dfs(cnt+1,sumS,sumB);//선택을 안한 경우
		//if(sumS==1 &&sumB==0) return;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			S[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}
		dfs(0,1,0);
		System.out.println(min);
	}
}