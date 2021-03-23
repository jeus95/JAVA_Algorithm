package com.study37;

import java.util.Scanner;

public class DP_strow {
		static int[] D;
		public static void main(String[] args) {
		
			Scanner sc= new Scanner(System.in);
			int N = sc.nextInt();
			//1. 구해야 되는 답을 문장으로 한번 써보기
			//길이가 N인 막대를 만드는 방법의 수
			
			//2. 방법의 수를 저장할 배열
			D= new int[N+1];
			//3. 초기값
			D[1] = 2;
			D[2] = 5;
			
			for (int i = 0; i <=N; i++) {
				//전체 길이가 N인 경우 : 맨 뒤에 노란색/파란색 막대를 놓는 경우, 빨간색 막대를 놓는 경우
				D[i] = D[i-1] + D[i-1] + D[i-2];
			}
			System.out.println(D[N]);
		}
	}
