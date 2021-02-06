package com.study11;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * SWEA_3499. 퍼펙트 셔플
 * 먼저 입력 입력 받은 N으로 0~N/2 , N/2~N까지 두개의 배열을 만들고 
 * 0~N/2까지 넣은 배열을 첫번째로 그다음에는 N/2 ~ N까지 넣은 배열을 번갈아가면서 삽입한다.
 * */
public class SWEA_3499_퍼펙트셔플 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		
		int T = sc.nextInt();
		
		for(int tc =1; tc<=T;tc++) {
			
			int cnt=0;
			int N = sc.nextInt();
			if(N%2==1)
				cnt=1;
		
			String[] first = new String[N/2+cnt];
			String[] second = new String[N/2];
			for (int i = 0; i < N/2+cnt; i++) {
				first[i] = sc.next();
			}
			for (int i = 0; i < N/2; i++) {
				second[i]=sc.next();
			}
			
			for (int i = 0; i < N/2; i++) {
				arr.add(first[i]);
				arr.add(second[i]);
			}
			if(cnt==1)
			arr.add(first[N/2+cnt-1]);
			
			System.out.print("#"+tc+ " ");
			for(String z:arr) {
				System.out.print(z+" ");
				
			}
			System.out.println();
			
			arr.clear();
		}
	}

}
