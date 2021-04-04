package com.study41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class backjoon_12907_동물원 {
	static int N;
	static int animal[];
	static boolean isSelected[];
	static int Mcnt=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		animal = new int[N];
		isSelected = new boolean[N];
		st=new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			animal[i]=Integer.parseInt(st.nextToken());
		}
		powerset(0);
		System.out.println(Mcnt);
	}
	public static void powerset(int cnt) {
		if(cnt ==N) {
			List<Integer> Llist = new ArrayList<Integer>();
			List<Integer> Clist = new ArrayList<Integer>();
			//Llist.add(0);
			//Clist.add(0);
			int Lcnt=0;
			int Ccnt=0;

			
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					//if (animal[i]==0) continue; 
					Llist.add(animal[i]);
					Lcnt++;
					
				}
				else {
					//if (animal[i]==0) continue;
					Clist.add(animal[i]);
					Ccnt++;
				}
			}
			Llist = getDistinctTreeSet(Llist);
			Clist = getDistinctTreeSet(Clist);
			if (Llist.size()<Lcnt||Clist.size()<Ccnt)
				return;
			if (Lcnt==0) {
				if(Clist.get(Ccnt-1)==Ccnt-1) {
					Mcnt++;
				}
				return;
			}
			if (Ccnt==0) {
				if(Llist.get(Lcnt-1)==Lcnt-1) {
					Mcnt++;
				}
				return;
			}
			if (Llist.get(Lcnt-1)==Lcnt-1&&Clist.get(Ccnt-1)==Ccnt-1) {
				if(Lcnt+Ccnt==N) {
					Mcnt++;
				}
				return;
			}
			return;
		}
		
		
		//if (isSelected[cnt]) return;
		
		isSelected[cnt]=true;
		powerset(cnt+1);
		isSelected[cnt]=false;
		powerset(cnt+1);
		
		
		
		
		
	}
	public static List<Integer> getDistinctTreeSet(List<Integer> llist) {
		 
        
        List<Integer> resultList = new ArrayList<Integer>();
 
        TreeSet<Integer> distinctData = new TreeSet<Integer>(llist);
        resultList = new ArrayList<Integer>(distinctData);
 
        return resultList;
    }
	
}
