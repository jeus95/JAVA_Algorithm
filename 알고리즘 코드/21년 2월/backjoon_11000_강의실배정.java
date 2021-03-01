package com.study25;
//isSelected함수를 이용해서 해결 시간을 배열로 구성하였으니  너무 커서 불가능
//우선 순위 큐를 사용해서 시작시간이 같은경우 끝나는시간으로 우선순위를 나누어서 분류
//그다음 처리를 어떻게 할까 
//아래와 같은 방식으로 코드를 작성할 경우 새로 생성된 강의실이 끝난후에 재사용 할 수 잇는 경우를 생각하지 못한다.
//해결방법으로는 우선순위 큐안의 원소를 강의실의 개수로 생각해서 문제를 해결하자
//int cnt=0;
//while(N>=0) {
//	time current = pQue.poll();
//	//System.out.println(current.start);
//	if(!pQue.isEmpty()&&pQue.peek().start<current.end) {
//		//System.out.println("poll "+ pQue.peek().start);
//		pQue.poll();
//		
//		cnt++;
//	}
//	pQue.offer(current);
//	N--;
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class time implements Comparable<time>{
	int start;
	int end;
	public time(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(time o) {
		if(this.start==o.start) {
			return this.end-o.end;
		}
		return this.start-o.start;
	}

	
}
public class backjoon_11000_강의실배정 {
		
		static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQue = new PriorityQueue<>();
		time[] time = new time[N]; 
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			time[i] = new time(start,end);
			//pQue.add(time);
		}
		Arrays.sort(time);
//		for(time z : time) {
//			System.out.println(z.start+" "+z.end);
//		}
//		
			for (int i = 0; i < N; i++) {
				
			
			int currentend = time[i].end;
			//i번째 강의가 끝나는 시간 저장
			//System.out.println(current.start);
			if(!pQue.isEmpty()&&pQue.peek()<=time[i].start) {
				//큐가 비어 있지 않고 큐의 값이 배열의 i번째 강의의 시작시간보다 같거나 작으면 
				//System.out.println("poll "+ pQue.peek());
				pQue.poll();
				//q에 있는 값 하나 제거 
				//cnt++;
			}
			
			
			pQue.offer(currentend);
			//N--;
			
		}
		System.out.println(pQue.size());
	}
}