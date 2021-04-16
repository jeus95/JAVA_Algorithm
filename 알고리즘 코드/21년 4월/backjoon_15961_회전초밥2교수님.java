package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//회전 초밥의 벨트의 개수 %N을 이용해서 원형을 구성을 하고 k개수가 만들어 질때마다 총 종류의 개수를 구하는 방식, 만약 배열안에 쿠폰 번호의 회가 없다면 +1
public class backjoon_15961_회전초밥2교수님 {
	static int N,D,K,C;
	static int dishes[],eaten[];
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		eaten = new int[D+1];//가짓 수 만큼
		dishes =new int[N];

		for (int i = 0; i < N; i++) {
			dishes[i]=Integer.parseInt(br.readLine());
			
		}
		
			System.out.println(conveyorbelt());
		
	}
		

	public static int conveyorbelt() {
		int max = 0, kind =0;
		
		//1. 0~k개의 초밥을 윈도우에 포함시키고 시작
		for (int i = 0; i < K; i++) {
			int sushi_no = dishes[i];//초밥 번호
			
			if(eaten[sushi_no]==0)//처음 먹는거
				kind++; //초밥 종류++
			
			eaten[sushi_no]++;//해당번호의 초밥 갯수 증가
			
		}
		//2 맨 처음에 먹은 초밥 종류가 최대 종류다
		max = kind;
		
		//3.왼쪽에서 부터 하나씩 윈도우 에서 제외시키고 오른쪽 초밥을 윈도우에 포함시키면서 이동할것
		for (int i = 1; i < N; i++) {//모든 접시에 대해
			
			int front = dishes[i-1];//빠질애
			
			eaten[front]--;//먹은 초밥 갯수에서 -1
			
			if(eaten[front]==0) //한번만 먹었던 초밥이 빠지면 -> 종류 -1
				kind--;
		
			//오른쪽 초밥 처리
			
			int end = ( i + K - 1 ) % N ; //i번째 접시를 시작으로 k개 뽑았을때  오른쪽 끝 초밥 번호 
			
			int sushi_no = dishes[end];
			
			if(eaten[sushi_no]==0) {//윈도우에 포함시켰는데 그전에 안먹어본 초밥
				kind++;
			}
			eaten[sushi_no]++;
			
			//먹은 종류가 많아지거나 같은 경우 쿠폰에 반영하여 max값 갱신
			if(max<=kind) {
				if(eaten[C]==0)//쿠폰 번호의 초밥은 안먹은 경우
					max= kind+1;
				else
					max =kind;
			}
		}
		
		
		return max;
	}
}
