package com.study13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*DFS알고리즘으로 후위순회 하며 풀것
 * 
 * 
*/
public class SWEA_1223_사칙연산유효성검사 {
	static String[] nodes;
	static int lastIndex;
	static int N;
	static int flag = 1;
	static StringTokenizer st;
	static Stack<Integer> stack = new Stack<>();
	public static void dfs(int current) {
		if(flag==0)
			return;
		//VLR
		if(current*2<N) {
		dfs(current*2);
		dfs(current*2+1);
		}
		oper(nodes[current]); //방문 관련 처리
	}
	public static void oper(String A) {
		if(A.equals("+")||A.equals("-")||A.equals("*")||A.equals("/")) {
			if(stack.size()<2) {
				flag=0;
				return;
			}
			int i =stack.pop();
			int j =stack.pop();
			
			if(A.equals("+")) stack.push(i+j);
			if(A.equals("-")) stack.push(i-j);
			if(A.equals("*")) stack.push(i*j);
			if(A.equals("/")) { 
			if(j==0) j=1;	stack.push(i/j);
					}
		}else
			stack.push(Integer.parseInt(A));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			nodes = new String[N+1];			
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int index=Integer.parseInt(st.nextToken());
				
				nodes[index] = st.nextToken();
				
				for (int j = 0; j < 2; j++) {
					if(st.hasMoreTokens()) {
						String a =st.nextToken(); 
						//String b =st.nextToken();
					}
				}
			}
			
			dfs(1);
			if(stack.size()<1) {
				flag=0;
			}
			System.out.println("#"+tc+" "+flag);
			
		}
		
	}

}
