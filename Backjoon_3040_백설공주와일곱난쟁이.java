package com.study17;


import java.util.Scanner;

//9개의 모자중에 7개만 고르면되기때문에 조합으로 해결 해볼것이다.
public class Backjoon_3040_백설공주와일곱난쟁이 {
	static int hats[];
	static boolean[] result = new boolean[9];
	static int N=9;
	public static void combination(int cnt,int target,int sum) {
		if(cnt==7) {
			for (int i = 0; i < 9; i++) {
				if(result[i]&&sum==100)
					System.out.println(hats[i]);
			}
			return;
		}
		if(target == N)return;
		
		result[target] = true;
		combination(cnt+1,target+1,sum+hats[target]);
		result[target] = false;
		combination(cnt,target+1,sum);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		hats = new int[9];
		for (int i = 0; i < 9; i++) {
			
			hats[i]=sc.nextInt();
		}
		combination(0,0,0);
	}
}