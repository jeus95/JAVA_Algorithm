package com.study12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229_ÇÑºóÀÌ¿ÍSPOTMART {
	static int[] Eweight;
	static int N;
	static int Wmax;
	static int max;
	static int EWmax;
	
	public static void find(int cnt,int weight,int index) {
		if(index>2 && cnt == N) {
			max=-1;
		}
			
		

		
		if(cnt==2) {
			max = Math.max(max, weight);
			return;
		}
		
		find(cnt+1, (weight + Eweight[cnt]),index);
		find(cnt+1,weight,index);
		
	}
	
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Wmax = Integer.parseInt(st.nextToken());
			Eweight =new int[N];
			max=0;
			EWmax=0;
			st=new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				//st=new StringTokenizer(br.readLine());
				Eweight[i]=Integer.parseInt(st.nextToken());
				if(EWmax<Eweight[i])
					EWmax=Eweight[i];
			}
			
			find(0,0,0);
//			if(EWmax==max)
//				max=-1;
			System.out.println("#"+tc+" "+ max);
			
		}
	}

}
