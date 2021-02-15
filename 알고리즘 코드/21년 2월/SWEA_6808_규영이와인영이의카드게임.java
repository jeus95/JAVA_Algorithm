package com.study17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*���� Ž���� ������ �ذ� �Ұ�
 * �Կ��̰� ���Ϳ� ���� �ο����� ��� ���� �����ؼ� ��� Ȯ��
 * �Կ��̰� ������ ���� �����͸� �ο��̰� ������ �־���Ѵ� ��� ��Ÿ����
 * 
 * */ 
public class SWEA_6808_�Կ��̿��ο�����ī����� {
	static int[] card;
	static int[] card2;
	static int nums[];
	static int win,lose;
	static int min,gue;
	static boolean[] isSelected= new boolean[9];
	public static void permutation(int cnt) {
		if(cnt==9) {
			play();
			return;
		} 
		for (int i = 0; i <9; i++) {
			
		
		
		if(isSelected[i]) continue;
		
			isSelected[i]=true;
			
			nums[i]=cnt;
			
			permutation(cnt+1);
			
			isSelected[i]=false;
		
		}
	}
	public static void play() {
		
		for (int i = 0; i < 9; i++) {
			
			if(card[i]>card2[nums[i]])
				gue+=card[i]+card2[nums[i]];
			
			if(card[i]<card2[nums[i]])
				min+=card[i]+card2[nums[i]];
		}
		if(gue>min)
			win++;
		if(gue<min)
			lose++;
		gue=0;
		min=0;
		//if(gue==min)
			
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums = new int[9];
			card = new int[9];
			card2= new int[9];
			win=0;
			lose=0;
			min =0;
			gue = 0;
			isSelected= new boolean[9];
			int allcard[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
			for (int i = 0; i < 9; i++) {
				card[i]=Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 18; i++) {
				for (int j = 0; j < 9; j++) {
					if(allcard[i]==card[j])
						allcard[i]=0;
				}
			}
			int cnt=0;
			for (int i = 0; i < 18; i++) {
					if(allcard[i]!=0) {
						card2[cnt++]=allcard[i];
					}
			}
			//System.out.print(Arrays.toString(card2));
			permutation(0);
			System.out.println("#"+tc+" "+ win + " " + lose);
		}
		
	}

}
