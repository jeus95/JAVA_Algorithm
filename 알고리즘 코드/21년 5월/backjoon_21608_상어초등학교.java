package argorithm_study_May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class backjoon_21608_상어초등학교 {
	static int N, map[][];
	static int info[][];
	static int favorite[][];
	static int dy[] = {0,0,1,-1};
	static int dx[] = {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.valueOf(br.readLine());
		map = new int[N][N];
		
		info = new int[N*N][5];
		
		for(int i=0; i<N*N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<5; j++) 
				info[i][j] = Integer.valueOf(st.nextToken());
		}
		map[1][1] = info[0][0];
		
		for(int i=1; i<N*N; i++) {
			favorite = new int[N][N]; 
			for(int j=1; j<5; j++)
				findFriend(info[i][j]); 
			int[] point = favorite();
			map[point[0]][point[1]] = info[i][0]; 
		}

		int answer = gethappy(); 
		System.out.println(answer);
	}
	
	static int findIndex(int number) { 
		int index = 0;
		for(int i=0; i<N*N; i++)
			if(info[i][0]==number)
				index = i;
		return index;
	}
	static int[] favorite() {
		int max = 0; 
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++)
				max = Math.max(max, favorite[i][j]);

		ArrayList<int[]> list = new ArrayList<int[]>(); 
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++) 
				if(favorite[i][j]==max && map[i][j]==0)
					list.add(new int[] {i, j, getZero(i, j)}); 

		Collections.sort(list, new Comparator<int[]>() { 
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2]==o2[2]) { 
					if(o1[0]==o2[0]) { 
						return Integer.compare(o1[1], o2[1]);
					}
					return Integer.compare(o1[0], o2[0]); 
				}
				return Integer.compare(o2[2], o1[2]); 
			}
		});
		return new int[] {list.get(0)[0], list.get(0)[1]};
	}
	static int getZero(int y, int x) { 
		int count = 0;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || ny<0 || ny>=N || nx>=N) continue;
			if(map[ny][nx]!=0) continue;
			count++;
		}
		return count;
	}
	static void findFriend(int number) { 
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(map[y][x]==number) {
					for(int i=0; i<4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(nx<0 || ny<0 || ny>=N || nx>=N) continue;
						if(map[ny][nx]!=0) continue;
						
						favorite[ny][nx]++;
					}
				}
			}
		}
	}
	static int gethappy() { 
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int count = 0;
				int curIndex = findIndex(map[i][j]); 
				for(int d=0; d<4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					if(nx<0 || ny<0 || ny>=N || nx>=N) continue;
						for(int k=1; k<5; k++) 
							if(map[ny][nx]==info[curIndex][k])
								count++;
					
				}
				if(count==1) 		sum += 1;
				else if(count==2)	sum += 10;
				else if(count==3)	sum += 100;
				else if(count==4)	sum += 1000;
			}
		}
		return sum;
	}

}