package com.study07;

import java.util.Scanner;

public class recursive {
	public static void underbar(int i) {
		for(int j=0;j<i;j++) {
		System.out.print("____");
		}
	}
	
	
	public static int cnt=1;
	public static void prof(int i) {
		underbar(cnt);
		System.out.println("\"����Լ��� ������?\"");
		
		if(i ==1) {
			underbar(cnt);
			System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			return;
		}

		underbar(cnt);
		System.out.println("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		underbar(cnt);
		System.out.println("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		underbar(cnt);
		System.out.println("���� ���� ��κ� �ǾҴٰ� ��"
				+ ""
				+ "��. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		cnt++;
		prof(i-1);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		System.out.println("\"����Լ��� ������?\"");
		System.out.println("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		System.out.println("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		System.out.println("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		
	
		prof(N);
		for(int i =0;i<=N;i++) {
			underbar(cnt--);
			System.out.println("��� �亯�Ͽ���.");
			
		}
		
	
	
	
	}
	

	
}
