package com.study08;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_Flatten_retry {
	static int []boxheight = new int[101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Tc = sc.nextInt();
		for(int tc =1;tc <=10;tc++) {
			int diff =0; //최고점과 최저점의 높이차
			int dumpCount = sc.nextInt();//덤프 횟수 1~1000
		
		
		int[] nums= new int[100];
		for(int i=0;i<nums.length;i++) {
			nums[i]=sc.nextInt();
		}
		//System.out.println(Arrays.toString(nums));
		
		//최고점 , 최저점 알아야 함으로 정렬 되면 좋음
		//평탄화 완료 -> 언제 될지 모름
		while(true) {
			Arrays.sort(nums); //오름차순
			
			//평탄화가 완료 되었거나 덤프 카운트를 다 쓴경우
			if(nums[99] - nums[0] <= 1 || dumpCount <= 0) {
				diff = nums[99]-nums[0];
				break;
			}
			//계속 덤프 
			dumpCount--;
			nums[99]--;
			nums[0]++;

			}	
		}
	}
}
