package com.study39;

import java.util.Arrays;
import java.util.Scanner;

public class DP3_LISTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//������ ����
		int[] arr = new int[N]; //������ ��
		int[] LIS = new int[N]; //�� ��ġ ==> LIS ���̸� �����ϴ� ������ �ּҰ�
		
		
		for (int i = 0; i < N; i++) {
			arr[i]= sc.nextInt();
		}
		int size = 0;
		for (int i = 0; i < LIS.length; i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);
			temp = Math.abs(temp)-1; //�ߺ����� �����Ƿ� Ž���� �����ϰ� �������� ����
			LIS[temp] = arr[i]; //�ǵڿ� �߰��ǰų� ���� ��ġ�� ����ų�
			
			if(temp == size) ++size;
			
		}
		System.out.println(size);
	}

}
