package com.study07;

import java.util.Scanner;

public class Switch {
	
	
	
	public static boolean symmetry(int a,int b) {
		return (a*b==0) ? true : false ;
	
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int button[] = new int[N+1];
		for(int i =1 ; i <=N ; i++) {
			button[i]=sc.nextInt();
		}
		int student=sc.nextInt();
		for(int i=0;i<student;i++) {
			int gender = sc.nextInt();
			int index = sc.nextInt();
			if(gender==1) {
				for(int j=index; j<= N ;j+=index) {
					button[j]= (button[j]==0) ? 1:0;
				}
			}
			if(gender==2) {
				int left = index;
				int right = index;
				while(true) 
				{	if(left<1||right>N)
					{
						break;
					}
					if(button[left] != button[right])
					{
						break;
					}
					left--;
					right++;
					
				}
				left++; right--;
				for(int j=left;j<=right;j++) {
					button[j]= (button[j]==0) ? 1:0;
				}
			}
		}
		
		
		
		
		
		for(int i=1;i<=N;i++) {

			
			System.out.print(button[i]+" ");

			if(i%20==0)
			System.out.println();
		}
	}

}
