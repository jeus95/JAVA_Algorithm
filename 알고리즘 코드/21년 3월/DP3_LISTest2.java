package com.study39;

import java.util.Arrays;
import java.util.Scanner;

public class DP3_LISTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//수열의 길이
		int[] arr = new int[N]; //수열의 값
		int[] LIS = new int[N]; //각 위치 ==> LIS 길이를 만족하는 원소의 최소값
		
		
		for (int i = 0; i < N; i++) {
			arr[i]= sc.nextInt();
		}
		int size = 0;
		for (int i = 0; i < LIS.length; i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);
			temp = Math.abs(temp)-1; //중복값이 없으므로 탐색에 실패하고 음수값이 리턴
			LIS[temp] = arr[i]; //맨뒤에 추가되거나 기존 위치에 덮어쓰거나
			
			if(temp == size) ++size;
			
		}
		System.out.println(size);
	}

}
