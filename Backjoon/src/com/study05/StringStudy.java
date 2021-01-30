package com.study05;



public class StringStudy {
	public static int findString(String Parent, String Pattern) {
		int parentsize = Parent.length();
		int patternsize = Pattern.length();
		for(int i  = 0; i<=parentsize -patternsize; i++) {
			boolean finded = true;
			for(int j=0; j<patternsize; j++ ) {
				if(Parent.charAt(i+j) != Pattern.charAt(j)) {
					finded =false;
					break;
				}
			
			}
			if(finded) {
				return i+1;
			}
		}
		
		
		return -1;
	}
public static void main(String[] args) {
		String parent = "Hello World";
		String pattern = "llo W";
		int result = findString(parent, pattern);
		if(result == -1) {
			System.out.println("찾을 수 없습니다.");
		}else {
			System.out.println(result + " 번째 에서 찾았습니다.");
		}
		
	}
}
 