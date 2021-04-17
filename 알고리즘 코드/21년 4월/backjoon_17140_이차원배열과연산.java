package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class backjoon_17140_이차원배열과연산 {
	static int R,C,K;
	static int row,col;
	static int map[][] = new int[101][101];
	static class Point implements Comparable<Point>{
		int num,count;

		public Point(int num, int count) {
			this.num = num;
			this.count = count;
		}

		@Override
		public int compareTo(Point o) {
			if(this.count==o.count) {
				return this.num-o.num;
			}
			return this.count-o.count;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int row =3,col=3;
		boolean flag =false;
	
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(i==R&&j==C&&map[i][j]==K)
				{	
					flag =true;
				}	
			}
			
			
			
			
		}
		
		if(flag) {
			System.out.println(0);
			return;
		}
		int t =0;
		while(true) {
			t++;
			if(t==100) {
				System.out.println(-1);
				return;
			}
			
			if(row>=col) {
				for
			}
			else {
				
			}
			
		}
		
		
		
	}
}
