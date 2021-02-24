package com.study24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class backjoon_6987_¿ùµåÄÅ {
	static int W,M,L;
	Stack<Integer> stack = Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			W=0;
			M=0;
			L=0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreElements()) {
				W+=Integer.parseInt(st.nextToken());
				M+=Integer.parseInt(st.nextToken());
				L+=Integer.parseInt(st.nextToken());
			}
			if(W==L)
				System.out.println(1);
			else
				System.out.println(0);
		}	
	}
	
}
