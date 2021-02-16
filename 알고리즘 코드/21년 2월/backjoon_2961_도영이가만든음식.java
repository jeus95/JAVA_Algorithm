package com.study18;

import java.util.Scanner;

public class backjoon_2961_�����̰��������� {

	static int S[]; //�Ÿ� 
	static int B[]; //����
	static int N;
	static int min=1000000000;
	public static void dfs(int cnt,int sumS , int sumB) {
		
		//int Lmin = (sumS>sumB)? sumS-sumB: sumB-sumS;//���� �̴ϸ�
		int Lmin = Math.abs(sumS-sumB); // ���밪�� �̿��� ���� �������� �� ���� �� �ִ�.
		if(sumS!=1&&min>Lmin) min = Lmin;
		if(cnt==N) return;
		dfs(cnt+1,sumS*S[cnt],sumB+B[cnt]);//������ �� ���
		dfs(cnt+1,sumS,sumB);//������ ���� ���
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