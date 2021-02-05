package com.study10;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		
		
		for (int TC = 1; TC <= 10; TC++) {
			int result=0;
			Stack<Character> stack = new Stack<>();
			int N = sc.nextInt();
			char[] tmp = new char[N];
			
			tmp= sc.next().toCharArray();
			for(int i=0;i < N ;i++) {
				if(tmp[i]=='['||tmp[i]=='('||tmp[i]=='<'||tmp[i]=='{') 
				{ 
				stack.add(tmp[i]);
				continue;
				}
					//System.out.println((int)stack.peek());
					//System.out.println((int)tmp[i]);
				
			if (!stack.isEmpty() && ((stack.peek() == tmp[i] - 2) || (stack.peek() == tmp[i] - 1))) {
					
					//System.out.println(stack.peek());
					//System.out.println(tmp[i]);
					stack.pop();
					continue;
				}
				break;
				
		}
		System.out.println(stack.isEmpty());	
		if(stack.isEmpty()) {
			result=1;
		}
		System.out.println("#"+TC +" "+result);
	}
 }
}