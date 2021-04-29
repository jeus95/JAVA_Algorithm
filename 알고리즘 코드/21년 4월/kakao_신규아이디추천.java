package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kakao_신규아이디추천 {
	public static void main(String[] args) throws IOException {
		
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		//1단계
		String step1= new_id.toLowerCase();
		
		System.out.println("1 "+step1);
		//2단계
		char[] step1_arr = step1.toCharArray();
		StringBuilder step2 = new StringBuilder();
		
		for (char z : step1_arr) {
			if((z>='a'&&z<='z')||(z>='0'&&z<='9')||z=='-'||z=='_'||z=='.') {
				step2.append(z);
			}
		}
		System.out.println("2 "+step2);
		//3단계
		String step3 = step2.toString();
		while(step3.contains("..")) {
			step3= step3.replace("..", ".");
		}
		
		System.out.println("3 "+step3);
		//4단계
		String step4 = step3;
		if(step4.length() > 0) {
			if(step4.charAt(0)=='.') {
				step4= step4.substring(1,step4.length());
			}
		}
		
		if(step4.length() > 0) {
			if(step4.charAt(step4.length()-1)=='.') {
				step4 = step4.substring(0,step4.length()-1);
			}
		}
		
		System.out.println("4 "+step4);
		//5단계
		String step5 = step4;
		if(step5.equals("")) {
			step5 = "a";
		}
		
		System.out.println("5 "+step5);
		//6단계
		String step6 = step5;
		if(step6.length()>=16) {
			step6 = step6.substring(0, 15);
		}
		if(step6.length() > 0) {
			if(step6.charAt(step6.length()-1)=='.') {
				step6 = step6.substring(0,step6.length()-1);
			}
		}
		
		System.out.println("6 "+step6);
		//7단계
		StringBuilder step7 = new StringBuilder(step6);
		if(step7.length()<=2) {
			char last = step7.charAt(step7.length()-1);
			
			while(step7.length()<3) {
				step7.append(last);
			}
		}
		System.out.println("7 "+step7);
		String answer =String.valueOf(step7);
		System.out.println(answer);
	}
}
