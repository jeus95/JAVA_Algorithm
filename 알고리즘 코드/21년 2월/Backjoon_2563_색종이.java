package com.study13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*2차원 배열로 만들어서 들어간 부분은 1로 표시 
 * 색칠 되지 않은 배열을 1로하여 갯수를 카운트하여 너비를 출력
 * 
*/

public class Backjoon_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean [][]arr= new boolean[100+1][100+1];
		int cnt=0;
		for (int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					arr[j][k]=true;
				}
			}
			
			
					}
				
			for (int j = 1; j < 100; j++) {
				for (int k = 1; k < 100; k++) {
					if(arr[j][k]==true) {
						cnt++;}
			
				}
				
		
			}
			System.out.println(cnt);
}
}