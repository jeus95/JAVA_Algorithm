package com.study11;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * SWEA_3499. ����Ʈ ����
 * ���� �Է� �Է� ���� N���� 0~N/2 , N/2~N���� �ΰ��� �迭�� ����� 
 * 0~N/2���� ���� �迭�� ù��°�� �״������� N/2 ~ N���� ���� �迭�� �����ư��鼭 �����Ѵ�.
 * */
public class SWEA_3499_����Ʈ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		
		int T = sc.nextInt();
		
		for(int tc =1; tc<=T;tc++) {
			
			int cnt=0;
			int N = sc.nextInt();
			if(N%2==1)
				cnt=1;
		
			String[] first = new String[N/2+cnt];
			String[] second = new String[N/2];
			for (int i = 0; i < N/2+cnt; i++) {
				first[i] = sc.next();
			}
			for (int i = 0; i < N/2; i++) {
				second[i]=sc.next();
			}
			
			for (int i = 0; i < N/2; i++) {
				arr.add(first[i]);
				arr.add(second[i]);
			}
			if(cnt==1)
			arr.add(first[N/2+cnt-1]);
			
			System.out.print("#"+tc+ " ");
			for(String z:arr) {
				System.out.print(z+" ");
				
			}
			System.out.println();
			
			arr.clear();
		}
	}

}
