package com.study11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/*1���� 9�ڸ��� ������ ������ ���ڿ� �迭�� charat���� �����Ŀ� 
 *1. ���� �������� ����¹� ���� ������ ��� �״�� ����ϰ� ��Ģ���� ��ȣ�� ��� ������ ������� Ȯ���Ѵ�.
 *
 * */
public class SWEA_1223_����2 {
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
		//System.out.println(arr); // ���� ǥ���
		
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
