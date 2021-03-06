package com.study30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class point{
	int num,cnt;

	public point(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
	
	
}
public class backjoon_1039_±³È¯_bfs {
	static int N,K;
	static boolean isSelected[][] = new boolean[1000001][11];
	static int ans = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		String N1 = st.nextToken();
		N = Integer.parseInt(N1);
		char[] N2 =N1.toCharArray();
		K = Integer.parseInt(st.nextToken());
		int numbers[] =new int[N2.length];
		
		for (int i = 0; i < N2.length; i++) {
			numbers[i]=(N2[i]-'0');
		}
		if(numbers.length==1) 
			{ 
				System.out.println(-1);
				return;
			}
		if(numbers.length==2&&numbers[1]==0) {
			System.out.println(-1);
			return;
		}
		
		bfs();
		System.out.println(ans);
	}

	private static void bfs() {
		Queue<point> que = new LinkedList<>();
		isSelected[N][0] = true;
		que.add(new point(N,0));
		
		while(!que.isEmpty()) {
			point now = que.poll();
			
			if(now.cnt==K) {
				ans = Math.max(ans, now.num);
				continue;
			}
			
			int len = String.valueOf(N).length();
			
			for (int i = 0; i < len-1; i++) {
				for (int j = i+1; j < len; j++) {
					char[] swapped = swap(now.num,i,j);
					int num = Integer.parseInt(String.valueOf(swapped));
					
					if(swapped[0]=='0'|| isSelected[num][now.cnt+1]) continue;
					
					isSelected[num][now.cnt+1]=true;
					
					que.offer(new point(num, now.cnt+1));
					
				}
			}
			
			
		}
		
	}
	private static char[] swap(int num, int i, int j) {
		StringBuilder sb = new StringBuilder(String.valueOf(num));
		
		char tmp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, tmp);
		
		return sb.toString().toCharArray();
	}

}
