package com.study39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class backjoon_2565_ภüฑ๊มู {
	static int map[][];
	static class line implements Comparable<line>{
		int a,b;

		public line(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(line o) {
			// TODO Auto-generated method stub
			return this.a-o.a;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		
		line[] arr =new line[N];//data
		int[] LIS = new int[N];
		
		for (int i = 0; i < N; i++) {
			int a =sc.nextInt();
			int b =sc.nextInt();
			arr[i]=new line(a,b);
			
		}
		
		Arrays.sort(arr);
		Arrays.fill(LIS, 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i].b>arr[j].b)
				LIS[i]=Math.max(LIS[i], LIS[j]+1);
			}
		}
		Arrays.sort(LIS);
		System.out.println(N-LIS[N-1]);
		
	}
}
