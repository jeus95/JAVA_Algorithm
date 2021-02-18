 package com.study21;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//bfs������ ���� Ž���� �̿��� Ǯ�̸� ���
 //dx[], d
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//bfs �ȹ�Ž������ ����
class position{
		int x,y,cnt;
		
		public position(int x, int y,int cnt) {

			this.x = x;
			this.y = y;
			this.cnt=cnt;
		}	
}
 public class backjoon_7562��_����Ʈ���̵� {
	 static Queue<position> que = new LinkedList<>();
	 //�ð���� Ž��
	 static int N;
	 static int dx[]= {-2,-1,1,2,2,1,-1,-2};
	 static int dy[]= {1,2,2,1,-1,-2,-2,-1};
	 static int map[][];
	 static boolean [][]isSelected;
	 static int move;
	public static void bfs() {
		while(!que.isEmpty()) {
			position p = que.poll();
			int x = p.x;
			int y = p.y;
			int cnt =p.cnt;
			if(map[x][y]==1) {
				move=cnt;
				que.clear();
				return;
			}
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=N||isSelected[nx][ny]) continue; //�迭�� ������ ����°��
				isSelected[nx][ny]=true;
				que.offer(new position(nx,ny,cnt+1));
				
			}
			
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			move =0;
			que.clear();
			isSelected = new boolean[N][N];
			map = new int[N][N];
			st = new StringTokenizer(br.readLine()," ");
			//������ ť�� �ֱ�
			int x = Integer.parseInt(st.nextToken());
			int y =	Integer.parseInt(st.nextToken());
			
			que.offer(new position(x,y,0));
			
			isSelected[x][y]=true;
			st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			map[x1][y1]=1;
			bfs();
			System.out.println(move);
		
		}
			
		}
	}


