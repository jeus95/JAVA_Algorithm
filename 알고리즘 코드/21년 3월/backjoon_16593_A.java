package com.study41;

import java.util.Arrays;
import java.util.Scanner;

public class backjoon_16593_A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int cnt=1;
		while(true) {
			if(A==B) {
				System.out.println(cnt);
				return;
			}
			if(B<A) {
				System.out.println(-1);
				return;
			}

			
			if(B%10==1) {
				B=B/10;
				cnt++;
				continue;
			}
			if(B%2==1) {
			B=(B+1)/2;
			cnt++;
			continue;
			}
			B=B/2;
			cnt++;
		}
		
		}

}
