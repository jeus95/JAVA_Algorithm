package com.study31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_1920_¼öÃ£±â {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int map[];
	static int N;
	public static int search(int start,int last,int target) {
		if(start > last)
			return 0;
		int mid = (start + last)/2;
		
		if(target==map[mid])
			return 1;
		if(target<map[mid])
			return search(start, mid-1,target);
		if(target>map[mid])
			return search(mid+1,last,target);
		
		return 0;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map=new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(map);
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int target =Integer.parseInt(st.nextToken());
			System.out.println(search(0,N-1,target));
		
			}
				
		}
	}

