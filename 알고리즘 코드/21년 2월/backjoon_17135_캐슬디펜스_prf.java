package com.study19;


import java.util.ArrayList;
import java.util.Scanner;

public class backjoon_17135_ĳ�����潺_prf {
	static int N, M, D, max;
	static int selected[];//�ü��� ��ġ.���� ��� 0, 1, 2
	static ArrayList<Enemy> elist;
	
	static class Enemy{
		int r, c;
		public Enemy(int r, int c) {			
			this.r = r;//���� �ϰ��� �� ���� +1
			this.c = c;//�� ���ʿ� �ִ� �� ������ �� ���
		}		
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1.�ʱⰪ �Է�
		N = sc.nextInt();//��
		M = sc.nextInt();//��
		D = sc.nextInt();//��ȿ�Ÿ�
		
		//2.�� ���� �Է� 
		elist = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(sc.nextInt() == 1) {
					elist.add(new Enemy(i,j));
				}
			}
		}		
		
		//3.�ü��� ������ ����� �� ���ո��� ����� ���� �� �ִ��� ��� =>max
		combination(0,0);
		
		//4.max ���
		System.out.println(max);
		
	}
	//�ü� ���� �����. ���� �׿����� max ����
	private static void combination(int cnt, int start) {
		if(cnt == 3) {//���� �Ѱ� �ϼ�. �ü� 3�� �غ�-> ������
			ArrayList<Enemy> elist2 = new ArrayList<>();//copy
			for(Enemy x: elist) {
				elist2.add(new Enemy(x.r, x.c));
			}//���纻. �� ���ո��� ������ �ϹǷ� �������� �մ�� �ȵ�
			
			int killed = gameStart(elist2, selected);//�ϳ��� �ü� ���� �� ���� ���� ��
			max = Math.max(max, killed);
			return;
		}
		
		for (int i = start; i < M; i++) {
			selected[cnt] = i;//0~
			combination(cnt + 1, i + 1);
		}
	}
	
	//�ϳ��� �ü� �������� ���� �� �ִ� ���� �� ����ؼ� ����
	private static int gameStart(ArrayList<Enemy> elist2, int[] selected) {
		int cnt = 0;//���� ��
		
		while(elist2.size() != 0) {//���� �ִ� ����
			
			ArrayList<Enemy> tmp = new ArrayList<>();
			
			//�ü�3���� �����.�ڽſ��Լ� ���� ����� ���� ã�Ƽ� ��Ƴ�.
			for (int pos: selected) {
				int targetIndex = findNear(elist2, pos);//�ڽſ��Լ� ���� ����� ���� ã��
				
				if(targetIndex >= 0) {//���� ������
					tmp.add(elist2.get(targetIndex));					
				}
			}//������ ���� �ü� 3���� tmp�� ���� �� ������ ������ ��!!!
			
			//��⼭ ����
			for(Enemy x : tmp) {
				if(elist2.remove(x)) {//������ ���
					cnt++;//���ϳ� ����
				}
			}
			
			enemyDown(elist2);//�� �ϰ�
		}	
		
		return cnt;
	}
	
	
	
	private static void enemyDown(ArrayList<Enemy> elist2) {
		//list���� �ϳ��� ������ r�� +1
		//N�� ���� �ʴ��� üũ -> ������ ����
	}
	
	private static int findNear(ArrayList<Enemy> elist2, int pos) {		
		
		return 0;
	}	
	

}
