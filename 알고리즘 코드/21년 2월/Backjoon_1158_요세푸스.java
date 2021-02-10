package com.study13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*큐를 먼자 만든 후에 첫번째 노드를 집어 넣고 마지막인 경우 다시 1의 값을 집넣는다.
*/
public class Backjoon_1158_요세푸스 {
	static int N;
	static int K;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Queue<Integer> que = new LinkedList<>();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int cnt=0;
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}
		System.out.print("<");
		while(!que.isEmpty()) {
			if(que.size()==1) {
				System.out.print(que.poll());
				break;
			}
			int current = que.poll();
			cnt++;
			
			if(cnt==K) {
				cnt=0;
				System.out.print(current+", ");
				continue;
			}
			
			que.add(current);
			
			
		}
		System.out.print(">");
	}

}
