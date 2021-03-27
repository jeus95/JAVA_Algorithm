package com.study39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_9205_맥주마시면서걸어가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 0; tc < T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int store = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine()); 
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			
			int way_x =start_x;
			int way_y =start_y;
			boolean flag =false;
			for (int i = 0; i < store; i++) {
				
				st = new StringTokenizer(br.readLine()); 
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				int dis=Math.abs(way_x-x) +Math.abs(way_y-y);
				if(dis>1000) {
					System.out.println("sad");
					flag=true;
					break;
				}
				
				way_x=x;
				way_y=y;
				
				
			}
			if (flag) {
				continue;
			}
			st = new StringTokenizer(br.readLine()); 
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());
			
			int dis=Math.abs(way_x-end_x) +Math.abs(way_y-end_y);
			
			if(dis>1000) {
				System.out.println("sad");
				continue;
			}
			
			System.out.println("happy");
			
			
			
		}
		
		
		
		
	}
}
