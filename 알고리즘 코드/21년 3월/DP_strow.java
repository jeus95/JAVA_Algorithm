package com.study37;

import java.util.Scanner;

public class DP_strow {
		static int[] D;
		public static void main(String[] args) {
		
			Scanner sc= new Scanner(System.in);
			int N = sc.nextInt();
			//1. ���ؾ� �Ǵ� ���� �������� �ѹ� �Ẹ��
			//���̰� N�� ���븦 ����� ����� ��
			
			//2. ����� ���� ������ �迭
			D= new int[N+1];
			//3. �ʱⰪ
			D[1] = 2;
			D[2] = 5;
			
			for (int i = 0; i <=N; i++) {
				//��ü ���̰� N�� ��� : �� �ڿ� �����/�Ķ��� ���븦 ���� ���, ������ ���븦 ���� ���
				D[i] = D[i-1] + D[i-1] + D[i-2];
			}
			System.out.println(D[N]);
		}
	}
