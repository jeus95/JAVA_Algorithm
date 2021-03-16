package com.study34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//먼저 인접 그래프를 만들고 그래프를 Q를 이용하여 탐색 할 예정
public class SWEA_contact {
	static int N,start,result;
	static int D[][];
	static int isSelected[];
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <=10; tc++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		//LinkedList<Integer> graph = new LinkedList<>();
		
		D = new int [N][N];
		isSelected = new int[N+1];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < N/2; i++) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			D[x][y]=1;
			
		}
		BFS();
		
		System.out.println("#"+tc+" "+result);
		
		}
	}
	public static void BFS() {
		Queue<Integer> q =new LinkedList<>();
		q.offer(start);
		int max = Integer.MIN_VALUE;
		int level=0;
		isSelected[start]=1;
		while(!q.isEmpty()) {
			
			int temp = q.poll();
			
			
			
			for (int i = 0; i < N; i++) {
				if(D[temp][i]==1&&isSelected[i]==0){
					isSelected[i]=isSelected[temp]+1;
					q.offer(i);
					
				}
			}
			
		}
		int maxNum =0;                  //마지막에 연락 받은 사람중 가장 큰 숫자
        for(int i=0;i<N;i++) {
        	if (isSelected[i] >= max) {
                if (i >= maxNum) {
                	max = isSelected[i];
                	maxNum = i;
                }
            }
	}
        result=maxNum;
	}
}
