package com.study10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218_prof {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans=1;
		
		for(int i =1; i<=10 ;i++) {
			ans=1;
			int N = Integer.parseInt(br.readLine().trim());
			
			String line = br.readLine(); //괄호들 문자열 [][[)).....
			int length = line.length(); //문자열 길이
			
			Stack<Character> stack = new Stack<>();
			if(length % 2 ==1 ) {// 짝 안맞음
				ans = 0;
			}else //문자열 길이가 짝수
			{
				for (int j = 0; j < length; j++) {
					char c = line.charAt(j);
					if(c == '{'||c == '<'||c=='('||c=='[') { 
						stack.push(c); //스택에 넣기
						
					}else { //닫는 괄호들
						char pair = getPair(c);
						if(stack.pop() != pair) {
							ans = 0;
							break;
						}//if
					}//else
				}//for
			}//else
			if(!stack.empty()) {
				ans =0;
			}
			
			System.out.println(ans);
		}//tc
		
	}//main
	private static char getPair(char c) {
		switch(c) {
		case '}': return '{';
		case ']': return '[';
		case '>': return '<';
		case ')': return '(';
		
		}
		return 0;
	}
}
