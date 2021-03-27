package com.study39;

import java.util.Scanner;

/*플로이드 : 모든 정점 간의 최소 비용
음수도 허용, 사이클 x
for 3개 사용
for 경유지 
	for 출발지
		for 도착지
*/
public class floydTest {
	static final int INF = 999;
	static int N, AdjMatrix[][];
	static String src = "5\r\n" + 
			"0 4 2 5 0\r\n" + 
			"0 0 1 0 4\r\n" + 
			"1 3 0 1 2\r\n" + 
			"-2 0 0 0 2\r\n" + 
			"0 -3 3 1 0";
	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
		N = sc.nextInt();
		AdjMatrix = new int [N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AdjMatrix[i][j] =sc.nextInt();
				
				if(i!= j && AdjMatrix[i][j]==0) {
					AdjMatrix[i][j]=INF;
				}
			}
		}
		System.out.println("입력값");
		print();
		
		//최소 비용 계산 하러 감 
		//경유지 -> 출발지 -> 도착지 
		for (int via = 0; via < N; via++) { // 경유지
			for (int from = 0; from < N; from++) {//출발지
				if(via==from) continue;
				
				for (int to = 0; to < N; to++) {//도착지
					if(via==from||via==to) continue;
					
					if(AdjMatrix[from][to] > AdjMatrix[from][via] +AdjMatrix[via][to]) {
						AdjMatrix[from][to] = AdjMatrix[from][via] +AdjMatrix[via][to];
					}
				}
			}
			print();
		}
		
	}
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(AdjMatrix[i][j]+"\t");
				
			}
			System.out.println();
		}
		System.out.println("======================================");
	}
}
