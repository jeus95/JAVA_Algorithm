package com.study08;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_Flatten_retry {
	static int []boxheight = new int[101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Tc = sc.nextInt();
		for(int tc =1;tc <=10;tc++) {
			int diff =0; //�ְ����� �������� ������
			int dumpCount = sc.nextInt();//���� Ƚ�� 1~1000
		
		
		int[] nums= new int[100];
		for(int i=0;i<nums.length;i++) {
			nums[i]=sc.nextInt();
		}
		//System.out.println(Arrays.toString(nums));
		
		//�ְ��� , ������ �˾ƾ� ������ ���� �Ǹ� ����
		//��źȭ �Ϸ� -> ���� ���� ��
		while(true) {
			Arrays.sort(nums); //��������
			
			//��źȭ�� �Ϸ� �Ǿ��ų� ���� ī��Ʈ�� �� �����
			if(nums[99] - nums[0] <= 1 || dumpCount <= 0) {
				diff = nums[99]-nums[0];
				break;
			}
			//��� ���� 
			dumpCount--;
			nums[99]--;
			nums[0]++;

			}	
		}
	}
}
