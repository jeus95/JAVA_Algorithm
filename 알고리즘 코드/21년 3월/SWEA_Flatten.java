package com.study40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Flatten {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] D = new int[100];
		for (int tc = 1; tc <= 10; tc++) {
			boolean flag=true;
			int cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < 100; i++) {
				D[i]= Integer.parseInt(st.nextToken());
			}
			int result=0;
			for (int i = 0; i <= cnt; i++) {
				int max=Integer.MIN_VALUE;
				int max_index=-1;
				
				int min=Integer.MAX_VALUE;
				
				int min_index=-1;
				for (int j = 0; j < 100; j++) {
					if(D[j]>max) {
						max_index = j;
						max=D[j];
					}
					if(D[j]<min) {
						min_index = j;
						min=D[j];
					}
					
				}
				
				if(D[max_index]-D[min_index]==0) {
					System.out.println("#"+tc+" "+0);
					flag=false;
					break;
				}
				
				if(D[max_index]-D[min_index]==1) {
					System.out.println("#"+tc+" "+1);
					flag=false;
					break;
				}
				result = D[max_index]-D[min_index];
				
				D[max_index]--;
				D[min_index]++;
				

				
			}
			if(flag)
			System.out.println("#"+tc+" "+result);
			
		}
	}
}
