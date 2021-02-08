package com.study12;

/*완전 탐색으로 모든 경우의 수를 따져 본 후에
 * 조합을 이용해서  해결 가능할것 같다.
 * 
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.omg.PortableInterceptor.INACTIVE;

public class SWEA_5215_햄버거다이어트 {
	static int max;
	static int N,LCal;
	static StringTokenizer st;
	static int[] scores;
	static int[] cals;
	static int cnt=0;
	
	static void find(int score,int cal,int cnt) {
		if(cal > LCal) {
			return;}
		if(cnt==N) 
		{
			max=Math.max(max, score);
			return;
		}
		find(score + scores[cnt],cal+cals[cnt],cnt+1);
		find(score,cal,cnt+1);
		
	}
	

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			cnt=0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			LCal = Integer.parseInt(st.nextToken());
//			System.out.println(N);
//			System.out.println(LCal);
			scores=new int[N];
			cals=new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				scores[i] = Integer.parseInt(st.nextToken());
				cals[i] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			find(0,0,0);
			System.out.println("#"+tc+" "+ max);
		}
		
	}

}
