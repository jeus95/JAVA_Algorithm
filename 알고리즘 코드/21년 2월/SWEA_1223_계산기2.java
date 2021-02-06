package com.study11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/*1에서 9자리만 들어오기 때문에 문자열 배열을 charat으로 받은후에 
 *1. 후위 수식으로 만드는법 먼저 숫자인 경우 그대로 출력하고 사칙연산 기호일 경우 스택이 비었는지 확인한다.
 *
 * */
public class SWEA_1223_계산기2 {
	public static int setPriority(char a) {
		if(a =='*')
			return 10;
		if(a=='+')
			return 1;
		return 0;
		
	}

	public static void main(String[] args) throws  IOException {
		
		Scanner sc = new Scanner(System.in);
		for(int TC=1;TC<=10;TC++) {
		Stack<Character> op = new Stack<>();
		ArrayList<Character> arr = new ArrayList<>();
		int N = sc.nextInt();
		String s = sc.next();
		for (int i = 0; i < N; i++) {
			char tmp = s.charAt(i);
			
			if(tmp>='0'&&tmp<='9') {
				arr.add(tmp);
			}
			else{
				if(op.isEmpty()) {
				op.push(tmp);
				
				}else {
				
					if(!op.isEmpty() && setPriority(op.peek())>=setPriority(tmp))
					{	while(!op.isEmpty() && setPriority(op.peek())>=setPriority(tmp))
							{ arr.add(op.pop()); } 
						op.push(tmp);
					}
					else
						op.push(tmp);}
			}
			
			
		}
		while(!op.isEmpty()) {
			arr.add(op.pop());
		}
		//System.out.println(arr); // 후위 표기법
		
		Stack<Integer> nums = new Stack<>();
		for (int i = 0; i < N; i++) {
			char tmp=arr.get(i);
			if(tmp>='0'&&tmp<='9') {
				nums.push(tmp-'0');
			}
			else {
				int A =nums.pop();
				int B =nums.pop();
				if(tmp=='+') 
					A=A+B;
				if(tmp=='*')
					A=A*B;
				nums.push(A);
			}
			
		}
		System.out.println("#"+TC+" "+nums.pop());
		}

	}
}
