package com.study15;

import java.util.Scanner;

public class Backjoon_10872_���丮�� {
	public static int patorial(int n) {
		if(n==0)
			return 1;
		
		return patorial(n-1)*n;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		
		System.out.println(patorial(N));
		
	}
}
