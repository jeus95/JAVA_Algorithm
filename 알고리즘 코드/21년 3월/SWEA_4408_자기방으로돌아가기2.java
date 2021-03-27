package com.study40;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4408_자기방으로돌아가기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 돌아가야할 학생들의 수, N명
			
			//복도 배열 준비(1,2->0 / 3,4->1 / 399,400->199
			int[] cor = new int[200];
						
			for (int i = 0; i < N; i++) {// 학생수 만큼
				int r1 = sc.nextInt();
				int r2 = sc.nextInt();
				
				//방번호 정리 r1->r2
				int min = Math.min(r1,  r2);
				int max = Math.max(r1,  r2);
				
				//방번호 -> 복도번호로 변환
				r1 = (min -1) /2; //1 2
				r2 = (max -1) /2; //1 2
				
				for (int j = r1; j <= r2; j++) {
					cor[j]++;
				}				
			}
			Arrays.sort(cor);
			System.out.println("#" + tc + " " + cor[199]);

		}
	}

}