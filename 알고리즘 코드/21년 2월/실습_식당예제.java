package com.study21;
//dfs�� �̿��� ��Ʈ��ŷ���� ������ �ذ��Ѵ�.
//��δ� ���� ���� �� ���� ��ĥ �� ������ isSelected�迭�� �̿��Ͽ� �Ǵ��Ѵ�.
//�� ���� ó������ �����ؼ� �����ʰ� �����ʴ밢�� �� �Ʒ��� �������� �����ϰ� ���� ���������� ����

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class �ǽ�_�Ĵ翹�� {
	static int N,M,ans;
	static char[][] map;
	static boolean [][] isSelected;
	static int dx[]= {-1,0,1}; //�� �밢�� �� �밢�� �Ʒ�
	static int dy[]= {1,1,1};
			
	public static int dfs(int x,int y) {
		
		  if(y == M-1) {
	            ans++;
	            return 1;
	        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + 1;
            if(nx < 0 || nx >= N) continue;
            
            if(map[nx][ny] == 'x' || isSelected[nx][ny]) continue;
           
            isSelected[nx][ny] = true;
            
            if(dfs(nx,ny)==1) return 1;
        }
        
        return 0;
    }
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map= new char[N][M];
		isSelected = new boolean[N][M];
		ans=0;
		for (int i = 0; i <N; i++) {
			st =new StringTokenizer(br.readLine());
			map[i]=st.nextToken().toCharArray();
			
		}
		for (int i = 0; i < N; i++) {
			isSelected[i][0]=true;
			dfs(i,0);	
		}
		
		System.out.println(ans);
		
	}
}
