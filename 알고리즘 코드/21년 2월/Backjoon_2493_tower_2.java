package com.study10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon_2493_tower_2 {
	public static void main(String[] args) throws  IOException {
		
		Stack<int[]> stack= new Stack<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
	
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		
		for(int i = 1; i<=N;i++) {
			
			int num = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				
					
					if(stack.peek()[0]>=num) {
						
						System.out.print(stack.peek()[1]+ " ");
						break;
					
					}
					
					stack.pop();
				}
			
			if(stack.isEmpty()) {
				System.out.print("0 ");
				}
			
			stack.push(new int[] {num,i}); //스택이 비어 있는 경우 스택에 원소 추가 
			
		}	

		
 }
}
