package com.study24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_���μ��������ϱ� {

   static int N, max, totalCnt, min, map[][];
   static int dr[] = { -1, 1, 0, 0 };
   static int dc[] = { 0, 0, -1, 1 };
   static ArrayList<int[]> list; // ����ؾ��ϴ� �ھ ��� �ִ� ����Ʈ(�����ڸ� �ھ�� ����)

   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int T = Integer.parseInt(br.readLine());
      for (int tc = 1; tc <= T; tc++) {
         N = Integer.parseInt(br.readLine());
         map = new int[N][N];
         list = new ArrayList<int[]>();
         max = 0;
         min = Integer.MAX_VALUE;
         totalCnt = 0;

         for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
               if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
                  continue; // �����ڸ��� �Ѱ�
               // �����ڸ��� �ƴ� ���� ���μ����� �ִٸ� ī��Ʈ ���ش�.
               if (map[i][j] == 1) {
                  list.add(new int[] { i, j });
                  totalCnt++;
               }
            }
         }
         
         go(0,0);
         System.out.println("#"+tc+" "+min);
      }
   }

   private static void go(int index, int cCnt) { // index : �κ����տ� ����� �ھ� �ε���, cCnt: ����� �ھ� ���� 
      
      if(index == totalCnt) {
         int res = getLength(); // ������ ������ ���� ���ϱ�
         
         if(max<cCnt) {
            max = cCnt;
            min = res;
         }else if(max == cCnt) {
            if(res<min) min = res;
         }
         
         return;
      }

      // �ھ� ���� ���� ���ƺ��� (4�������� ���ƺ���)
      int[] cur = list.get(index);

      int r = cur[0];
      int c = cur[1];
      for (int d = 0; d < 4; d++) {
         if(isAvailable(r,c,d)) {
            //���� ����
            setStatus(r,c,d,2);
            // ���� �ھ�� �Ѿ��
            go(index+1, cCnt+1);
            //���Ҵ� ���� �ǵ��� ����
            setStatus(r,c,d,0);
         }

      }
      // �ھ� ����
      go(index+1,cCnt);
   }
   
   private static void setStatus(int r, int c, int d, int s) {
      int nr =r, nc =c;
      while(true) {
         nr += dr[d];
         nc += dc[d];
         if(nr<0 || nr>=N || nc<0 || nc>= N) break;
         map[nr][nc] = s;
      }

   }

   private static boolean isAvailable(int r, int c, int d) {
      int nr = r, nc = c;
      while (true) {
         nr += dr[d];
         nc += dc[d];
         if (nr < 0 || nr >= N || nc < 0 || nc >= N)
            break; // ����ؼ� �ش�������� ������ �ؼ� ��� ��� : �������� ����
         if(map[nr][nc]>=1) return false; // �ھ ������ �������־� �Ұ���.
      }
      return true;
   }
   
   private static int getLength() {
      int lCnt =0;
      for (int i=0; i<N; i++) {
         for (int j=0; j<N; j++) {
            if(map[i][j]==2) lCnt++;
         }
      }
      return lCnt;
   }

}