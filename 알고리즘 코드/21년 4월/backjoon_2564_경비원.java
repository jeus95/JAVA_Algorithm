package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//마주보는 경우 2가지의 구간중 짧은 것중 작은것을 구해서 더한다
//0,0을 기준으로 x+y 값을 더한다 
public class backjoon_2564_경비원 {
	static int N,M,S;
	static int sum=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		ArrayList<int[]> store =new ArrayList<int[]>();
		int sd=0;
		int sy=0;
		int sx=0;
		for (int i = 0; i <= S; i++) {
			st = new StringTokenizer(br.readLine());
			int d =Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			int x=0;
			if(d==1) { x=y;y=0;
			} 
			if(d==2) { x=y;y=M;
			} 
			if(d==3){ x=0;
			} 
			if(d==4){x=N;
			}
			
			if(i!=S)
			store.add(new int[] {d,x,y});
			
			sd =d;
			sy =y;
			sx =x;
		}
		
		
		
		
		for (int i = 0; i < S; i++) {
			int curr[]= store.get(i);
			
			int D=sd+curr[0];
			
			if(D%4==3) {
				//동 서 마주 보는 경우
				if(D>4) { //위에서 떨어진 거리를 더한것과 , 전체 세로 길이에서 위에서 떨어진 거리를 빼서 값을 구한다.
					
					sum+=Math.min(curr[2]+sy , 2*M - (curr[2]+sy)) + N;
					//System.out.println("1 "+sum);
					continue;
				}
				else { //북 남쪽 마주 보는 경우
					
					sum+=Math.min(curr[1]+sx , 2*N - (curr[1]+sx)) + M;
					//System.out.println("2 "+sum);
					continue;
				}
					
			}
			
			sum+=Math.abs(curr[1]-sx)+Math.abs(curr[2]-sy);
			
			//System.out.println("3 "+sum);
		}
		
		System.out.println(sum);
	}

}
