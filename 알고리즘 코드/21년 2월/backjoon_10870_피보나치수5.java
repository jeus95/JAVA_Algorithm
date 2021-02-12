package com.study15;

import java.util.Scanner;

public class backjoon_10870_피보나치수5 {
	static int meno[];
//	static int fibo(int n) {
//		if(n==1)
//			return 1;
//		if(n==0)
//			return 0;
//		
//		return fibo(n-1)+fibo(n-2);
//	}
	static int fibo(int n) {
		if(n==0)
			return 0;
		if(n<=2){
			return 1;
		}
		
		if(meno[n]==0) {
			
			meno[n]=fibo(n-1)+fibo(n-2);
			return meno[n];
			
		}else
			return meno[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		meno = new int[N+1];
		int result = fibo(N);
		System.out.println(result);
	}
}
