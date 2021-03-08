package com.off.day4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class JUN17135_CastleDefense {
	static int N, M, D;//N 행, M 열, D 공격 거리 제한 
	static int max = 0;//궁수의 공격으로 제거할 수 있는 적의 최대 수
	static int selected[];//선택된 궁수들의 위치
	static ArrayList<Enemy> elist;

	static class Enemy {
		int r, c;
		Enemy(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//1.초기값 입력
		N = sc.nextInt();// 행
		M = sc.nextInt();// 열
		D = sc.nextInt();// 유효거리
		selected = new int[3];

		//2.적군 입력: 입력받은 적군의 위치를 객체리스트로 저장
		elist = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (sc.nextInt() == 1) {
					elist.add(new Enemy(i, j));//적군정보 저장
				}
			}
		}		
		
		//3. 궁수조합:가능한 모든 궁수 조합 만들어서 각 조합마다  몇명의 적을  죽일 수 있는지 계산.->max값 구하기 
		combination(0,0);
	
		//4.최대값 출력
		System.out.println(max);
	}

	private static void combination(int cnt, int start) {
		if(cnt == 3) {//궁수조합 완성. 이 조합으로 적을 쏴서 몇명 죽일수 있나 계산->max 갱신
			ArrayList<Enemy> list2 = new ArrayList<>();
			
			for (Enemy e : elist) {//원본리스트에서 데이터 꺼내 복사본 만듬. 조합이 완성될 때마다 적을 죽여봐야 하니까 원본은 그대로 두고 (다른 조합에서도 사용해야 함)복사해서 사용
				list2.add(new Enemy(e.r, e.c));
			}
			
			// 게임 시작
			//int killed = gameStart(list2, new int[] { selected[0], selected[1], selected[2]});	//하나의 궁수조합 당 사살된 적의 수				
			int killed = gameStart(list2, selected);	//하나의 궁수조합 당 사살된 적의 수				
			max = Math.max(killed, max);			
			return;
		}
		
		for (int i = start; i < M ; i++) {//열의 수만큼
			selected[cnt] = i;
			combination(cnt + 1, i + 1);
		}		
	}

	//하나의 궁수 조합으로 죽일 수 있는 적의 수 계산해서 리턴
	// 궁수 한사람씩 꺼내서 그 궁수에서 제일 가까운 적 위치를 찾아 죽일놈 리스트에 추가
	// archers :궁수위치(y)배열. 열값
	static int gameStart(List<Enemy> list, int[] archers) {
		int cnt = 0;//죽일 수 있는 적의 수

		// 적군이 모두 사라질때까지 반복
		while (list.size() != 0) {
			
			//0) 매 회차당 죽일놈 리스트
			List<Enemy> tmp = new ArrayList<>();

			//1) 궁수 3명이 다 쏴 본다고 가정: 한사람씩 자신에서 제일 가까운 적(죽일 놈) 위치를 찾아 모아놈. 죽일놈 리스트에 추가
			for (int a : archers) {				
				// 사수로부터 젤 가까운 적군의 위치(index)를 찾아
				int targetIndex = findNear(list, a);				

				if (targetIndex >= 0) {//있으면					
					tmp.add(list.get(targetIndex));// 원리스트에서 꺼내서 죽일놈 리스트에 추가
				}
			}//요기까지 오면 궁수3명이 모두 tmp에 죽일놈 정보 저장한 후임
			
			//2) 죽일놈들을 리스트에서 삭제
			for (Enemy e : tmp) {
				if (list.remove(e))//복사해 둔 리스트에서 삭제
					cnt++;//죽인놈 수 증가
			}
			
			//3) 적군 하강
			EnemyDown(list);
			
		}// while 적군이 모두 사라질때까지 반복
		return cnt;
	}

	// pos:궁수 위치 row 열값 . 리스트에 저장된 적 중에서 궁수위치와 가장 가까운 적의 인덱스를 리턴(몇번째 적인지)
	static int findNear(List<Enemy> list, int pos) {
		
		int minDist = Integer.MAX_VALUE;//적과의 가장 가까운 거리
		int minColumn = 50;//가장 가까운 적의 컬럼 값. 같은 거리의 적이 있다면 왼쪽의 적이 우선. 더 작아야 함
		int index = -1;//리스트에서 가장 가까운 적의 위치. 왼쪽 적 우선. 동일 거리인 경우

		for (int i = 0; i < list.size(); i++) {//현 궁수 위치에서 적들 다 조사해 봄
			Enemy e = list.get(i);//한놈 꺼내고

			int d = N - e.r + Math.abs(pos - e.c);//궁수와 적과의 실거리계산(행열 차이값)
			
			// 지정한 유효범위 거리를 초과하는 적군은 무시
			if (d > D)	continue;

			// 아까 저장해 놨던 (알고있던 가장 가까운 거리보다 더 가까운 적이 나타나면)적의 정보보다 보다  더 가까운 적이 나타나면
			if (d < minDist) {
				// 적군과의 거리와 그 적군의 가로좌표를 저장
				minDist = d;//적군과의 가장 가까운  거리 저장
				minColumn = e.c;//열값 저장(왼쪽 적 사살이 우선이므로). 같은 거리의 적이 발견되면 왼쪽 적이 우선이니까
				index = i;// 리스트안에서의 적군의 위치
				
			}else if (d == minDist) {// 같은 거리를 갖는 적군이 발견되면
				if (minColumn > e.c) {
					// 더 작은 가로 좌표값을 기억(왼쪽 적 사살이 우선이므로)
					minColumn = e.c;
					index = i;
				}
			}
		}
		return index;
	}

	//리스트에 저장되어 있는 적군을 하나 꺼내서 행값 조정. 증가시키기. 만약 배열 경계선 넘어가면 삭제(죽은거니까). 그리고 인덱스 조정
	  static void EnemyDown(List<Enemy> list) { 
		  Iterator<Enemy> it = list.iterator(); 
		  while(it.hasNext()){ 
			  Enemy e = it.next(); 
			  e.r++;//아래로 내려오니깐 열값 증가		  
	  
			  if (e.r == N) { //다 내려 옴.성벽에 닿음. 죽음 
				  it.remove();
			  }
		  }
	  }

}
