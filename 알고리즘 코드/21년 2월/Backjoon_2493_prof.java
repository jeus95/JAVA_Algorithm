package com.study10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon_2493_prof {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Stack<Tower> stack = new Stack<>();
		int height, position;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(no =1; no<=N; no++) {
			
		}	}
	
	static class Tower{
		int height; // 탑높이
		int position; //탑의 인덱스 값
		public Tower(int height, int position) {
			this.height = height;
			this.position = position;
		}
		
		
	}
}
