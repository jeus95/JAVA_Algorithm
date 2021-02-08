package com.study12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1940_°¡¶ùRCÄ« {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D =0;
			int speed =0;
			int num=0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				if(op!=0) {
				num = Integer.parseInt(st.nextToken());
				}
				if(op==0) {
					if(speed>0)
					D+=speed;
				}
				if(op==1) {
					speed+=num;
					D+=speed;
				
				}
				
				if(op==2) {
					if((speed-num)>=0) {
					speed-=num;
					D+=speed;
					}
				}
			}
			System.out.println("#"+tc+ " "+D);
			
		}
	}
}
