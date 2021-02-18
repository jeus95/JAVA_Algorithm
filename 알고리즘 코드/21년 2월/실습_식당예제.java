package com.study21;
//dfs를 이용한 백트레킹으로 문제를 해결한다.
//경로는 서로 접할 수 없고 겹칠 수 없으니 isSelected배열을 이용하여 판단한다.
//또 열의 처음부터 시작해서 오른쪽과 오른쪽대각선 위 아래로 움직임이 가능하고 열의 끝을만나면 종료

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 실습_식당예제 {
	static int N,M,ans;
	static char[][] map;
	static boolean [][] isSelected;
	static int dx[]= {-1,0,1}; //우 대각선 위 대각선 아래
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
