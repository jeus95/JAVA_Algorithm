package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

public class SWEA_1251_하나로2 {
	public static int N;
	public static long[][] adjMatrix;
	static class Vertex implements Comparable<Vertex>{
		int no; 
		long cost;
		public Vertex(int no, long cost) {
			super();
			this.no = no;
			this.cost = cost;
		}
		@Override
		public int compareTo(Vertex o) {
			
			return Long.compare(this.cost, o.cost);
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t< tc; t++) {
			N = Integer.parseInt(br.readLine());
			int x[]= new int[N];
			
			StringTokenizer st =new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i]= Integer.parseInt(st.nextToken());
			}// 각섬의 x 좌표
			
			int y[] = new int [N];
			 st =new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i]= Integer.parseInt(st.nextToken());
			}// 각섬의 y 좌표
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					//무향 그래프
					adjMatrix[i][j]=adjMatrix[j][i]=getDistance(x[i], x[j], y[i], y[j]);
				}
			}
			double E = Double.parseDouble(br.readLine());
			System.out.println("#"+t+" "+Math.round(makeMst()*E));
			
			
		}
	}
	private static long makeMst() {
		long[] minEdge = new long[N];
		boolean[] visted = new boolean[N];
		
		Arrays.fill(minEdge, Long.MAX_VALUE);
		//임의의 정점을 시작점으로 만듦
		minEdge[0]=0;
		
		PriorityQueue<Vertex> que = new PriorityQueue<>();
		que.offer(new Vertex(0, minEdge[0]));
		
		long result = 0; //최소신장트리 비용
		int cnt =0; //정점의 개수
		while(true) {
			//신장 트리에 포함되지 않은 정점중 최소간선비용의 정점 선택
			Vertex minVertex = que.poll();
			if(visted[minVertex.no]) continue;
			//신장트리에 포함시킴
			visted[minVertex.no]=true;
			result +=minVertex.cost;

			if(++cnt == N) break;
			//v번 수행
			for (int i = 0; i < N; i++) {
				if (!visted[i] && minEdge[i]>adjMatrix[minVertex.no][i]) {
					minEdge[i]=adjMatrix[minVertex.no][i];
					que.offer(new Vertex(i, minEdge[i]));
					
				}
			}
			//=> 시간 복잡도 2Vqjs -> 2V^2 => O(V^2) => 100만
		}
		return result;
	}
	static long getDistance(int x1,int x2, int y1, int y2) {
		return (long)Math.pow(x1-x2, 2)+(long)Math.pow(y1-y2, 2);
	}
	
	
}
