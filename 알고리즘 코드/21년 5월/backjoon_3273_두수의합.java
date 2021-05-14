package argorithm_study_May;

import java.util.Arrays;
import java.util.Scanner;

public class backjoon_3273_두수의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num[] = new int[N];
		for (int i = 0; i < N; i++) {
			num[i]=sc.nextInt();
		}
		int target = sc.nextInt();
		Arrays.sort(num);
		int i=0,j=N-1;
		int cnt=0;
		while(i<j) {
			if(num[i]+num[j]==target) {
				cnt++;
				i++;
				j--;
				continue;
			}
			if(num[i]+num[j]<target) {
				i++;
				continue;
			}
			if(num[i]+num[j]>target) {
				j--;
				continue;
			}
		}
		System.out.println(cnt);
	}
}
