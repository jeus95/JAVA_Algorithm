package com.study29;

import java.util.Scanner;

public class 백준_14697_방배정 {
	static int flag=0;
	static int A,B,C;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		int N = sc.nextInt();
//		checked(N);
//		System.out.println(flag);
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				for (int j2 = 0; j2 < 50; j2++) {
					if(N-(A*i)-(B*j)-(C*j2)==0) {
						System.out.println(1);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
	public static void checked(int Snumber) {
		if(Snumber==0) {
			flag=1;
			return;
		}
		if(Snumber<0)
			return;
		if(flag==1)
			return;
		//if(Snumber%A==0)
			checked(Snumber-A);
		
		//if(Snumber%B==0)
			checked(Snumber-B);
		
		//if(Snumber%C==0)
			checked(Snumber-C);
	}
	

}
