package com.study05;

public class KMPAlgorithm {
	public static int[] makeTable(String pattern) {
		int []table = new int[pattern.length()];
		
		int j=0;
		
		for(int i=1;i<pattern.length();i++) {
			
			while(j>0 && pattern.charAt(i) != pattern.charAt(j) ) {
				j = table[j-1];
				
			}
			if(pattern.charAt(i) == pattern.charAt(j)) {
				table[i]=++j;
			}
		}
		return table;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		String pattern = "abacaaba";
		int[] table = makeTable(pattern);
		for(int i = 0 ; i < table.length;i++) {
			System.out.println(table[i]);
		}
	
	}
}
