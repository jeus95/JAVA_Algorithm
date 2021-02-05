package com.study09;

import java.util.Scanner;

public class SWEA_2805_professor {
	static int[][] map;
	static int N, center;
	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int tc = sc.nextInt();
	        for(int t=1; t<=tc; t++) {
	        	N= sc.nextInt();
	        	map = new int[N][N];
	        	center = N/2;
	        	
	        	for (int i = 0; i < N; i++) {
					char[] tmp =sc.next().toCharArray(); //캐릭터 배열로 숫자를 잘라서 넣음 임시로 사용
					
					for (int j = 0; j < N; j++) {
						//char 타입의 숫자 '2' -> int 타입의 숫자로 바꾸기 -'0'을 이용해서 가능하다. 
						map[i][j]= tmp[j] - '0';
						//System.out.println((int)tmp[j]+ " : "+ (int)'0');
					}
	        	}
	        	System.out.println("#" + tc + " "+ getHarvest());
	        }
	}
	//배열 안의 다이아몬드 영역에 해당하는 값들을 더해서 리턴(begin~end)
	private static int getHarvest() {
		int harvest = 0,begin =0,end =0,gap =0;
		//harvest 총합, begin : 각행에서 수확할 칸의 시작 인덱스 
		// end : 각행에서 수확할 칸의 마지막 인덱스 
		//gap : 매행마다 begin, end값을 조정할 변수
		
		for (int i = 0; i < N; i++) { //행
			begin = center -gap; //중앙에서 앞쪽으로 이동
			end = center +gap; //중앙에서 뒷쪽으로 이동
			for (int j = begin; j <= end; j++) { //열
				harvest += map[i][j];
			}
			if(i< center) {
				gap++;
			}
			if(i>center) {
				gap--;
			}
		}
		return 0;
	}
	
}
