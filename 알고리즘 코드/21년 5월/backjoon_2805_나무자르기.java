package argorithm_study_May;

import java.util.Scanner;

public class backjoon_2805_나무자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int height = sc.nextInt();
		int Tmax=0;
		int[] t = new int[N];
		for (int i = 0; i < N; i++) {
			t[i]=sc.nextInt();
			if(t[i]>Tmax) {
				Tmax=t[i];
			}
		}	
		
		long start = 0;
		long end = Tmax;
		while(start<=end) {
			long mid = (start + end)/2;
			long sum=0;
			
			for (int i = 0; i < N; i++) {
				if(t[i]>mid) {
					sum+=t[i]-mid;
				}
				
				if(sum>=height) {
					start=mid+1;
				}
				
			}
			if(sum<height) {
				end= mid -1;
			}
		}
		System.out.println(end);
	}
}
