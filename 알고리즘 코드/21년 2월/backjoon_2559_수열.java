package com.study24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



//조합을 이용하여 해결한다.
public class backjoon_2559_수열 {
	static int c,max=0,D;
	static boolean[] isSelected;
	public static void combination(int cnt,int sum,int r) {

		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		D = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int[] day = new int[D];
		st =new StringTokenizer(br.readLine());
		for (int i = 0; i < D; i++) {
			
		day[i]=Integer.parseInt(st.nextToken());
		}
		int max=-999;
		for(int i=0;i<=D-c;i++) {
			int sum=0;
			for (int j = i; j <i+c; j++) {
				sum+=day[j];
			}
			if(max<sum)
				max=sum;
		}
		System.out.println(max);
	}

}
