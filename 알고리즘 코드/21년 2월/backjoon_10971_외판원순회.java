package com.study15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*1234�� 1324�� �ּ� ����� �ٸ��� ������ ������ Ǯ� ���̴�.
 * 
 * 
 * 
*/

public class backjoon_10971_���ǿ���ȸ {
	static int N; // ��ü ������ �� 
	static int cnt; //������ ���� ī��Ʈ
	static int map[][]; // �������� ����� ������ �˰� �ִ� �迭
	static boolean isSelected[];
	static int min=9999999;
	static int start;
	static void dfs(int cnt,int x,int sum ) {
		
		if(cnt==N&&map[x][start]>0) {
			min=Math.min(min, sum+map[x][start]);
			//System.out.println(min);
			return;
		}
		
		isSelected[x]=true;
		
		
		for (int i = 1; i <= N; i++) {
			if(!isSelected[i]&&map[x][i]>0) {
			
			isSelected[i]=true;
			dfs(cnt+1,i,sum+map[x][i]);
			isSelected[i]=false;
			
			}
		}
		isSelected[x]=false;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //N�� �Է� -> ������ �� 
		
		map= new int[N+1][N+1];
		isSelected = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," "); 
			for (int j = 1; j <= N; j++) {
				map[i][j] =Integer.parseInt(st.nextToken());//-> ������ ����ġ �߰�
		
			}
		}
	
		for (int i = 1; i <= N; i++) {
			start =i;

			dfs(1,i,0);

		}
		System.out.println(min);
	}
}
