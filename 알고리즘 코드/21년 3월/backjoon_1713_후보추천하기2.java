package com.study31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class backjoon_1713_후보추천하기2 {
	static int Cnt,N;
	
	//static student[] st;
	
	static class student implements Comparable<student>{
		int Num,R,Cnt;

		public student(int num, int r,int cnt) {
			Num = num;
			R = r;
			Cnt = cnt;
		}

		@Override
		public int compareTo(student o) {
			// TODO Auto-generated method stub
		if(this.R == o.R)
			return this.Cnt-o.Cnt;
			
			return this.R-o.R;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cnt = sc.nextInt();
		N = sc.nextInt();
		ArrayList<student> st= new ArrayList<>();
		boolean isSelected[] =new boolean[101];
		int cnt=0;
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			int num = sc.nextInt();
				for(student s : st ) {
					if(s.Num == num) {
						flag=true;
						s.R++;
						break;
					}
				}

			Collections.sort(st);
			if(flag) continue;
			
			if (st.size() == Cnt) {
				st.remove(0);
				st.add(new student(num, 1, i));
			}else {// 아직 프레임이 꽉 안참
				st.add(new student(num, 1, i));
			}
		 
			Collections.sort(st);
		}
		Collections.sort(st ,(a,b)-> a.Num - b.Num
		);
		for (student p : st) {
			System.out.print(p.Num + " ");
		}
		
	}
}
