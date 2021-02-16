package com.study18;
//5로 최대한 나눈후에 
import java.util.Scanner;

public class backjoon_2839_설탕배달 {
	
	static int cnt=0;
	public static void dfs(int cnt) {
		
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		
		while(true) {
			if(N==0)
				break;
			if(N%15>14) {
			cnt += N/15;
			N = N/15;
			//System.out.println(N);
			continue;
			}
			if(N%5==0) {
				cnt += N/5;
				N= N%5;
				continue;
			}
			if(N>=3) {
			N-=3;
			cnt++;
			continue;
			}

			if(N>0&&N<3) {
				cnt=-1;
				break;
			}
		}
		System.out.println(cnt);	
		}
}
