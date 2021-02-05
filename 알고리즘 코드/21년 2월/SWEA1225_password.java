package com.study10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1225_password {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//int T=sc.nextInt();
		
		for(int TC = 1;TC<=10;TC++) {
			int T=sc.nextInt();
			Queue<Integer> que =new LinkedList<>();
			boolean flag =false;
			for (int i = 0; i < 8; i++) {
				que.add(sc.nextInt());
			}
			
				while(true) {
					
					for(int j=1;j<=5;j++) {
						int tmp = que.poll();
						tmp-=j;
						
						if(tmp>0) {
						que.offer(tmp);
						}else {
							flag = true;
							tmp=0;
							que.offer(tmp);
							break;
						}
					}
					if(flag) 
						break;
				}
				int cnt =que.size();
				System.out.print("#"+T+" ");
				for(int i=0;i<cnt ;i++) {
					System.out.print(que.poll()+ " ");
				}
				que.clear();
				
				System.out.println();
				
			
			
			
			
			
			
		}
	}

}
