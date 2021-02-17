package com.study19;

import java.util.Arrays;
import java.util.Scanner;

public class �������պ��� {
		static int N;
		static int[] numbers;
		static boolean[] isSelected;
		static int totalCnt;

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			
			numbers = new int[N];
			
			isSelected = new boolean[7];
			
			
			int M = sc.nextInt();
			totalCnt = 0;
			
			
			switch (M) {
			case 1:
				dice1(0);
				break;
			case 2:
				dice2(0);
				break;
			case 3:
				dice3(0,1);
				break;
			case 4:
				dice4(0,1);
			}
			System.out.println("�� ����� �� : " + totalCnt);
			
			
		}
		// �ߺ� ����: n��r ==> n^r
		private static void dice1(int cnt) {
			if(cnt == N)
			{
				totalCnt++;
				System.out.println(Arrays.toString(numbers));
				return;
			}
			for(int i =1; i<=6;i++) {
				numbers[cnt]=i;
				dice1(cnt+1);
			}
		}
		//���� : nPr ==> n! 6P3 => 6*5*4
		private static void dice2(int cnt) {
			if(cnt == N)
			{
				totalCnt++;
				System.out.println(Arrays.toString(numbers));
				return;
			}
			for(int i =1; i<=6;i++) {
				numbers[cnt]=i;
				isSelected[i]=true;
				dice2(cnt+1);
				isSelected[i]=false;
			}
		}//�ߺ� ���� nHr : 6H3 : n+r-1Cr : 8C3 -> 56
		//�ڱ� �ڽ��� �����Ѵ�.
		private static void dice3(int cnt, int start) {
			if(cnt==N) {
				totalCnt++;
				System.out.println(Arrays.toString(numbers));
				return;
			}
			
			//��ŸƮ�� ���� ���� ���� Ž�� 
			for(int i = start; i<=6;i++) {
				numbers[cnt]=i;
				dice3(cnt+1,i);
			}
		}
			//���� nCr : 6C3 : 20
			//�ڱ��ڽź��� ū������ �̴´�.
			private static void dice4(int cnt, int start) {
				if(cnt==N) {
					totalCnt++;
					System.out.println(Arrays.toString(numbers));
					return;
				}
				
				//��ŸƮ�� ������ ū������ Ž��
				for(int i = start; i<=6;i++) {
					numbers[cnt]=i;
					dice4(cnt+1,i+1);
				}
	}
			private static void dice5(int cnt) {
				
			}
	}

