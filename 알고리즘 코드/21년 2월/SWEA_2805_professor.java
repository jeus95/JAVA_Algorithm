package com.study09;

import java.util.Scanner;

public class SWEA_2805_professor {
	static int[][] map;
	static int N, center;
	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int tc = sc.nextInt();
	        for(int t=1; t<=tc; t++) {
	        	N= sc.nextInt();
	        	map = new int[N][N];
	        	center = N/2;
	        	
	        	for (int i = 0; i < N; i++) {
					char[] tmp =sc.next().toCharArray(); //ĳ���� �迭�� ���ڸ� �߶� ���� �ӽ÷� ���
					
					for (int j = 0; j < N; j++) {
						//char Ÿ���� ���� '2' -> int Ÿ���� ���ڷ� �ٲٱ� -'0'�� �̿��ؼ� �����ϴ�. 
						map[i][j]= tmp[j] - '0';
						//System.out.println((int)tmp[j]+ " : "+ (int)'0');
					}
	        	}
	        	System.out.println("#" + tc + " "+ getHarvest());
	        }
	}
	//�迭 ���� ���̾Ƹ�� ������ �ش��ϴ� ������ ���ؼ� ����(begin~end)
	private static int getHarvest() {
		int harvest = 0,begin =0,end =0,gap =0;
		//harvest ����, begin : ���࿡�� ��Ȯ�� ĭ�� ���� �ε��� 
		// end : ���࿡�� ��Ȯ�� ĭ�� ������ �ε��� 
		//gap : ���ึ�� begin, end���� ������ ����
		
		for (int i = 0; i < N; i++) { //��
			begin = center -gap; //�߾ӿ��� �������� �̵�
			end = center +gap; //�߾ӿ��� �������� �̵�
			for (int j = begin; j <= end; j++) { //��
				harvest += map[i][j];
			}
			if(i< center) {
				gap++;
			}
			if(i>center) {
				gap--;
			}
		}
		return 0;
	}
	
}
