package com.study07;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int tc;
		tc = sc.nextInt();
		
		for(int t=1;t<=tc;t++) {
			char[] st = sc.next().toCharArray();
			int cnt=0;
			//int status =st.charAt(0);
			char status ='0';

			if(st[0]==1) {
				cnt++;
			}
			for(int i=0; i< st.length;i++) {
				if(st[i]!= status ) {
					cnt++;
					status=st[i];
					//System.out.println(status);
				}
			}
			
			System.out.println("#"+t+" "+cnt);
			}
			
			
		}
	}


