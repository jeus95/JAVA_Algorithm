package com.study34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_1759_암호만들기 {
	static int L,C;
	static char[] pw;
	static boolean isSelected[];
	static char[] M = {'a', 'e', 'i', 'o', 'u'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		isSelected = new boolean[C];
		M = new char[5];
		st = new StringTokenizer(br.readLine());
		pw = new char[C];
		for (int i = 0; i < C; i++) {
			pw[i] =st.nextToken().charAt(0);
				
			
		}
		
		
		Arrays.sort(pw);
		
		comb(0,0);

	}
	public static void check() {
			int mcnt=0;
			boolean flag=false;
			for (int j = 0; j < C; j++) {
				if(isSelected[j])
					if(pw[j]=='a'||pw[j]=='e'||pw[j]=='i'||pw[j]=='o'||pw[j]=='u')
						mcnt++;
			}
			if(mcnt>=1&&mcnt<=L-2) {
				for (int i = 0; i < C; i++) {
					if(isSelected[i])
					System.out.print(pw[i]);
					flag=true;
				}
				
			}
			if(flag)
			System.out.println();
	}
	public static void comb(int cnt, int target) {

		if(target==L) {
			check();
			return;
		}
		if(cnt == C)
		{
			return;
		}
		
		if(isSelected[cnt]) return;
		isSelected[cnt]=true;
		comb(cnt+1, target+1);
		isSelected[cnt]=false;
		comb(cnt+1, target);
		
		
	}
}
