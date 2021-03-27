package com.study40;

import java.util.Arrays;

public class SortTest {
	public static void main(String[] args) {
		int[] arr = {4,2,6,1,8};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr); // �ㅻ�李⑥��
		System.out.println(Arrays.toString(arr));
		
		String[] srr = {"xds", "atr", "dsj", "ppp"};
		System.out.println(Arrays.toString(srr));
		Arrays.sort(srr);
		System.out.println(Arrays.toString(srr));
		
		Some[] aarr = {new Some("xx",7), new Some("abc", 9), new Some("bbb",5), new Some("ttt", 6)};
		System.out.println(Arrays.toString(aarr));
		Arrays.sort(aarr);
		System.out.println(Arrays.toString(aarr));
	} // end of main
	
	static class Some implements Comparable<Some>{
		String s;
		int i;
		double d;
		public Some(String s, int i) {
			this.s = s;
			this.i = i;
		}
		@Override
		public String toString() {
			return "[" + s + "," + i + "]";
		}
		@Override
		public int compareTo(Some o) { // 鍮�援�湲곗��� ����湲�		
			return new Integer(this.i).compareTo(o.i); // �ㅻ�李⑥��  this.i - o.i
//			return this.s.compareTo(o.s); // �ㅻ�李⑥�� this.s - o.s
//			return o.s.compareTo(this.s); // �대┝李⑥�� o.s - this.s
		}
	}
}
