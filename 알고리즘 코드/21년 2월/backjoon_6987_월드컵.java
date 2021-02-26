package com.study24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class backjoon_6987_월드컵 {
	static int W[],M[],L[];
	static int wS,mS,lS;
//	static int numbers[];
	public static int dfs(int cnt,int start) {
		if(wS+mS+lS==0) {
			return 1;
		}
		for(int i = start; i<=6;i++) {
			//이길경우
			if(W[cnt]>0&&L[i]>0) {
				W[cnt]--;
				L[i]--;
				wS--;
				dfs(cnt,i+1);
				wS++;
				W[cnt]++;
				L[i]++;
			}
			//질경우
			if(L[cnt] > 0 && W [i] >0) {
	            L[cnt]--;
	            W[i]--;
	            lS--;
	            dfs(cnt,i+1);
	            lS++;
	            L[cnt]++;
	            W[i]++;
	        }
	        //무승부 인경우
	        if(M[cnt] > 0 && M[i] >0) {
	        	M[cnt]--;
	            M[i]--;
	            mS--;
	            dfs(cnt,i+1);
	            mS++;
	            M[cnt]++;
	            M[i]++;
	        }    
			cnt++;
		}
		return 0;
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			W=new int[6];
			M=new int[6];
			L=new int[6];
			wS=0;
			mS=0;
			lS=0;
			int N=0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreElements()) {
				W[N]=Integer.parseInt(st.nextToken());
				M[N]=Integer.parseInt(st.nextToken());
				L[N]=Integer.parseInt(st.nextToken());
				wS++;
				mS++;
				lS++;
				N++;
			}
			System.out.println(dfs(0,0));
		}	
	}
	
}
